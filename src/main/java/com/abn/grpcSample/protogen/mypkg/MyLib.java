package com.abn.grpcSample.protogen.mypkg;

import com.abn.grpcSample.HelloResponse;
import com.abn.grpcSample.SampleBuilder.HelloRequest;
import com.abn.grpcSample.SampleBuilder.HelloRequestBuilder;
import com.abn.grpcSample.protogen.*;
import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetails;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.Descriptors.*;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.DynamicMessage;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.grpc.MethodDescriptor.newBuilder;

public class MyLib<In extends Serializable, Out> {


    private FileDescriptor getFileDescriptor(Path descFile, String protoWithExtention) throws Exception
    {

        Map<String, FileDescriptorProto> fileDescProtos =
                ProtoUtility.getFileDescriptorProtos(descFile.toAbsolutePath().toString());

        FileDescriptorProto fileDescProto = fileDescProtos.get(protoWithExtention);

        FileDescriptor[] dependencies = ProtoUtility.getDependencies(fileDescProtos, fileDescProto);

        FileDescriptor fileDesc = FileDescriptor.buildFrom(fileDescProto, dependencies);

        return fileDesc;

    }

    public Out getResponse(ProtoDetails protoDetails, String methodName,
                           String messageTypeName,
                           In requestObject) throws Exception
    {

        Path descFile = Files.createTempFile("protoDesc", ".desc");

        ImmutableList<String> protocArgs = ImmutableList.<String>builder()
                .add("--include_imports")
                .add("--proto_path=" + protoDetails.getProtoPath())
                .add("--descriptor_set_out=" + descFile.toAbsolutePath().toString())
                .add(protoDetails.getProtoWithExtention())
                .build();

        int status = new ProtocInvoker().invoke(protocArgs);
        System.out.println("status :" + status);


        FileDescriptor fileDesc = getFileDescriptor(descFile, protoDetails.getProtoWithExtention());

        ServiceDescriptor serviceDescriptor = ProtoUtility.getServiceDescriptor(fileDesc,protoDetails.getServiceName());

        MethodDescriptor methodDescriptor = ProtoUtility.getMethodDesciptor(serviceDescriptor,methodName);

        Descriptor desc = fileDesc.findMessageTypeByName(messageTypeName);

//        DynamicMessage requestAsDynamicMessage = DynamicMessage.newBuilder(desc)
//                .setField(desc.findFieldByName("name"), "ABN")
//                .build();

        byte[] requestObjectAsByteArray = convertObjectToByteArray(requestObject);
        System.out.println(Arrays.toString(requestObjectAsByteArray));
        DynamicMessage requestAsDynamicMessage = DynamicMessage.parseFrom(desc, requestObjectAsByteArray);


        io.grpc.MethodDescriptor.Builder<DynamicMessage,DynamicMessage> builder = newBuilder();
        builder.setRequestMarshaller(new MarshallFor(methodDescriptor.getInputType()))
                .setResponseMarshaller(new MarshallFor(methodDescriptor.getOutputType()))
                .setFullMethodName(protoDetails.getPackageName()+"."+ protoDetails.getServiceName()+"/"+methodName)
                .setType(ProtoUtility.getMethodType(methodDescriptor));

        io.grpc.MethodDescriptor<DynamicMessage,DynamicMessage> getMethodDescriptor = builder.build();

        ManagedChannel managedChannel= ManagedChannelBuilder
                .forAddress("localhost", 42422)
                .usePlaintext()
                .build();

        CallOptions callOptions = CallOptions.DEFAULT;

        DynamicMessage responseAsDynamicMessage =
                new GrpcGenericClient().unaryCall(managedChannel,getMethodDescriptor,callOptions,requestAsDynamicMessage);

        managedChannel.shutdown();


        //form the dynamic requestAsDynamicMessage from the java object passed
        //invoke the method using java object
        //collect the reponse and send back as object
        return null;
    }

    private InputStream convertObjectToInputStream(In requestObject) throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);


        oos.writeObject(requestObject);

        oos.flush();
        oos.close();

        return new ByteArrayInputStream(baos.toByteArray());
    }

     private byte[] convertObjectToByteArray(In inputObject)
     {
         byte[] stream = null;
         // ObjectOutputStream is used to convert a Java object into OutputStream
         try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
              ObjectOutputStream oos = new ObjectOutputStream(baos);) {
             oos.writeObject(inputObject);
             stream = baos.toByteArray();
         } catch (IOException e) {
             // Error in serialization
             e.printStackTrace();
         }
         return stream;
     }

    public static void main(String[] args) throws Exception {

        final String protoPath = "/Users/aswathyn/Personal/Docs/Java-WS/gRPC-Java/src/main/proto";
        final String proto = "HelloService";
        final String messageTypeName = "HelloRequest";


        String serviceName = "Greeter";
        String methodName = "SayHello";
        String packageName = "helloworld";


        // new code begin

        ProtoDetails protoDetails = new ProtoDetails(protoPath, proto, packageName, serviceName);
        HelloRequest helloRequest = new HelloRequestBuilder().build();

        MyLib<HelloRequest, HelloResponse> myLib = new MyLib<>();
        myLib.getResponse(protoDetails, methodName, messageTypeName, helloRequest);

        //new code ends

    }


}

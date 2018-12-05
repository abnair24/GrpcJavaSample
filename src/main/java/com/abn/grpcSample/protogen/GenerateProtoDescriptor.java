package com.abn.grpcSample.protogen;

import com.google.common.collect.ImmutableList;
import com.google.protobuf.DescriptorProtos.*;
import com.google.protobuf.Descriptors.*;
import com.google.protobuf.DynamicMessage;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.ClientCalls;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static io.grpc.MethodDescriptor.newBuilder;

public class GenerateProtoDescriptor {

    public static void main(String[] args) throws Exception {

        final String protoPath = "/Users/aswathyn/Personal/Docs/Java-WS/gRPC-Java/src/main/proto";
        final String proto = "HelloService.proto";
        final String messageTypeName = "HelloRequest";

        //pb.bin or .desc whats the diff?
        Path descFile = Files.createTempFile("protoDesc", ".desc");
        String serviceName ="Greeter";
        String methodName ="SayHello";
        String packageName= "helloworld";

        ImmutableList<String> protocArgs = ImmutableList.<String>builder()
                .add("--include_imports")
                .add("--proto_path=" + protoPath)
                .add("--descriptor_set_out=" + descFile.toAbsolutePath().toString())
                .add(proto)
                .build();
//
        int status = new ProtocInvoker().invoke(protocArgs);
        System.out.println("status :" + status);

        /*
        Getting fd protos from fdset
         */
        Map<String, FileDescriptorProto> fileDescProtos =
                ProtoUtility.getFileDescriptorProtos(descFile.toAbsolutePath().toString());


        /*
        Extract fdproto details of proto of interest from fdprotos
         */
        FileDescriptorProto fileDescProto = fileDescProtos.get(proto);


        FileDescriptor[] dependencies = ProtoUtility.getDependencies(fileDescProtos, fileDescProto);


        FileDescriptor fileDesc = FileDescriptor.buildFrom(fileDescProto, dependencies);

        ServiceDescriptor serviceDescriptor = ProtoUtility.getServiceDescriptor(fileDesc,serviceName);

        MethodDescriptor methodDescriptor = ProtoUtility.getMethodDesciptor(serviceDescriptor,methodName);

        List<ServiceDescriptor> services = fileDesc.getServices();

        Descriptor desc = fileDesc.findMessageTypeByName(messageTypeName);



        displayFieldDetails(desc.findFieldByName("name"));


        DynamicMessage request = DynamicMessage.newBuilder(desc)
                .setField(desc.findFieldByName("name"), "John Lao")
                .build();

        io.grpc.MethodDescriptor.Builder<DynamicMessage,DynamicMessage> builder = newBuilder();
        builder.setRequestMarshaller(new MarshallFor(methodDescriptor.getInputType()))
                .setResponseMarshaller(new MarshallFor(methodDescriptor.getOutputType()))
                .setFullMethodName(packageName+"."+ serviceName+"/"+methodName)
                .setType(ProtoUtility.getMethodType(methodDescriptor));

        io.grpc.MethodDescriptor<DynamicMessage,DynamicMessage> getMethodDescriptor = builder.build();

        ManagedChannel managedChannel= ManagedChannelBuilder
                .forAddress("localhost", 42422)
                .usePlaintext()
                .build();

        CallOptions callOptions = CallOptions.DEFAULT;

        //DynamicMessage response = ClientCalls.blockingUnaryCall(managedChannel,getMethodDescriptor, callOptions, request);


        managedChannel.shutdown();

//        byte[] dynMessageInBytes = request.toByteArray();
//
//        DynamicMessage dynMessage2 = DynamicMessage.parseFrom(desc, dynMessageInBytes);
//
//        System.out.println("Dynmessage2: "+dynMessage2);

    }


    private static void displayFieldDetails(FieldDescriptor fieldDesc) {
        System.out.printf("%s : %s",
                fieldDesc.getName(),
                fieldDesc.getJavaType().name());
        if (fieldDesc.getJavaType().name().equals("MESSAGE")) {
            System.out.printf(" (%s)", fieldDesc.getMessageType().getName());
        }
        else if (fieldDesc.getJavaType().name().equals("ENUM")) {
            System.out.printf(" (%s)", fieldDesc.getEnumType().getName());
        }
        System.out.println();
    }


}

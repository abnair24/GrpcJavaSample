package com.abn.grpcSample.protogen.mypkg;

import com.abn.grpcSample.protogen.*;
import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.abn.grpcSample.protogen.mypkg.domain.ServerConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.Descriptors.*;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.util.JsonFormat;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import jdk.nashorn.internal.codegen.CompilerConstants;


public class MyLib<In, Out> {


    public Out getResponse(ServerConfig serverConfig, ProtoDetail protoDetail, In requestObject, Class<Out> outputClass) throws Exception
    {

        //convert requestObjecttoDynamicMessage
        //invoke the service
        //processoutput


        MethodDescriptor methodDescriptor = ProtoUtility.getMethodDescriptor(protoDetail);

        Descriptor methodDescriptorInputType = methodDescriptor.getInputType();

        DynamicMessage requestAsDynamicMessage =
                convertRequestObjectToDynamicMessage(methodDescriptorInputType, requestObject);

        io.grpc.MethodDescriptor.MethodType methodType = ProtoUtility.getMethodType(methodDescriptor);


        io.grpc.MethodDescriptor<DynamicMessage,DynamicMessage> getMethodDescriptor =
                io.grpc.MethodDescriptor.<DynamicMessage, DynamicMessage>newBuilder().
                        setRequestMarshaller(new MarshallFor(methodDescriptorInputType))
                        .setResponseMarshaller(new MarshallFor(methodDescriptor.getOutputType()))
                        .setFullMethodName(protoDetail.getMethodFullName())
                        .setType(methodType).build();

        ManagedChannel managedChannel= serverConfig.getManagedChannel();

        DynamicMessage responseAsDynamicMessage = null;
        if(methodType == io.grpc.MethodDescriptor.MethodType.UNARY) {

            responseAsDynamicMessage = new GrpcGenericClient()
                    .unaryCall(managedChannel ,getMethodDescriptor, CallOptions.DEFAULT,requestAsDynamicMessage);

        } else if(methodType == io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING) {

            new GrpcGenericClient()
                    .serverStreamingCall(managedChannel,getMethodDescriptor,CallOptions.DEFAULT,requestAsDynamicMessage);
        } else if(methodType == io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING) {

            new GrpcGenericClient()
                    .clientStreamingCall(managedChannel,getMethodDescriptor, CallOptions.DEFAULT,requestAsDynamicMessage);
        } else {
            new GrpcGenericClient()
                    .bidirectionalStreaming(managedChannel,getMethodDescriptor,CallOptions.DEFAULT,requestAsDynamicMessage);
        }


        JsonFormat.Printer printer = JsonFormat.printer();
        String response = printer.print(responseAsDynamicMessage);
        System.out.println("response: " +response);

        Out responseAsObject = new Gson().fromJson(response, outputClass);

        managedChannel.shutdown();


        //collect the reponse and send back as object
        return responseAsObject;
    }

    private DynamicMessage convertRequestObjectToDynamicMessage(Descriptor desc, In requestObject) throws Exception{

        String jsonString = new GsonBuilder().create().toJson(requestObject);
        JsonFormat.Parser jsonParser = JsonFormat.parser();

        DynamicMessage.Builder dynamicMessageBuilder = DynamicMessage.newBuilder(desc);
        jsonParser.merge(jsonString, dynamicMessageBuilder);

        return dynamicMessageBuilder.build();
    }
}

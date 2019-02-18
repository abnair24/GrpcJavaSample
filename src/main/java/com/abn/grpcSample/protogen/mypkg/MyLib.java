package com.abn.grpcSample.protogen.mypkg;

import com.abn.grpcSample.protogen.*;
import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.abn.grpcSample.protogen.mypkg.domain.ServerConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.protobuf.Descriptors.*;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor.MethodType;


public class MyLib<Out> {

    public Out getResponse(ServerConfig serverConfig, ProtoDetail protoDetail, String requestJsonAsString,
                           Class<Out> outputClass) throws Exception {

        MethodDescriptor methodDescriptor = ProtoUtility.getMethodDescriptor(protoDetail);

        DynamicMessage requestAsDynamicMessage =
                convertRequestObjectToDynamicMessage(methodDescriptor, requestJsonAsString);


        ManagedChannel managedChannel= getManagedChannel(serverConfig);
        String methodFullName = protoDetail.getMethodFullName();

        return getOut(managedChannel, methodFullName, outputClass, methodDescriptor, requestAsDynamicMessage);
    }


    public <In> Out getResponse(ServerConfig serverConfig, ProtoDetail protoDetail, In requestObject,
                           Class<Out> outputClass) throws Exception {

        MethodDescriptor methodDescriptor = ProtoUtility.getMethodDescriptor(protoDetail);

        DynamicMessage requestAsDynamicMessage =
                convertRequestObjectToDynamicMessage(methodDescriptor, requestObject);


        ManagedChannel managedChannel= getManagedChannel(serverConfig);
        String methodFullName = protoDetail.getMethodFullName();

        return getOut(managedChannel, methodFullName, outputClass, methodDescriptor, requestAsDynamicMessage);
    }

    private Out getOut(ManagedChannel managedChannel, String methodFullName, Class<Out> outputClass,
                       MethodDescriptor methodDescriptor,
                       DynamicMessage requestAsDynamicMessage) throws InvalidProtocolBufferException {

        Out responseAsObject;
        MethodType methodType = ProtoUtility.getMethodType(methodDescriptor);

        if(methodType == MethodType.UNARY)
        {
            Descriptor methodDescriptorInputType = methodDescriptor.getInputType();

            io.grpc.MethodDescriptor<DynamicMessage,DynamicMessage> getMethodDescriptor =
                    io.grpc.MethodDescriptor.<DynamicMessage, DynamicMessage>newBuilder().
                            setRequestMarshaller(new MarshallFor(methodDescriptorInputType))
                            .setResponseMarshaller(new MarshallFor(methodDescriptor.getOutputType()))
                            .setFullMethodName(methodFullName)
                            .setType(methodType).build();

            DynamicMessage responseAsDynamicMessage = new GrpcGenericClient()
                .unaryCall(managedChannel ,getMethodDescriptor, CallOptions.DEFAULT,requestAsDynamicMessage);

            responseAsObject = convertDynamicMessagetoResponseObject(responseAsDynamicMessage, outputClass);

            managedChannel.shutdown();

        }
        else {
            throw new RuntimeException("only UNARY methods supported");
        }

        return responseAsObject;
    }

    private Out convertDynamicMessagetoResponseObject(DynamicMessage dynamicMessage, Class<Out> outputClass)
            throws InvalidProtocolBufferException {
        JsonFormat.Printer printer = JsonFormat.printer();
        String response = printer.print(dynamicMessage);
        System.out.println("response: " +response);

        return new Gson().fromJson(response, outputClass);
    }


    private <In> DynamicMessage convertRequestObjectToDynamicMessage(MethodDescriptor methodDescriptor,
                                                                In requestObject) throws Exception{

        String jsonString = new GsonBuilder().create().toJson(requestObject);
        JsonFormat.Parser jsonParser = JsonFormat.parser();

        Descriptor descriptor = methodDescriptor.getInputType();

        DynamicMessage.Builder dynamicMessageBuilder = DynamicMessage.newBuilder(descriptor);
        jsonParser.merge(jsonString, dynamicMessageBuilder);

        return dynamicMessageBuilder.build();
    }

    private DynamicMessage convertRequestObjectToDynamicMessage(MethodDescriptor methodDescriptor,
                                                                     String requestJsonAsString) throws Exception{

        JsonFormat.Parser jsonParser = JsonFormat.parser();

        Descriptor descriptor = methodDescriptor.getInputType();

        DynamicMessage.Builder dynamicMessageBuilder = DynamicMessage.newBuilder(descriptor);
        jsonParser.merge(requestJsonAsString, dynamicMessageBuilder);

        return dynamicMessageBuilder.build();
    }

    private ManagedChannel getManagedChannel(ServerConfig serverConfig)
    {
        return ManagedChannelBuilder
                .forAddress(serverConfig.getHostName(),serverConfig.getPortNumber())
                .usePlaintext()
                .build();


    }
}

package com.abn.grpcSample.protogen.mypkg;

import com.abn.grpcSample.protogen.mypkg.domain.ChannelBuilder;
import com.abn.grpcSample.protogen.mypkg.domain.GrpcGenericClient;
import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.abn.grpcSample.protogen.mypkg.domain.ServerConfig;
import com.abn.grpcSample.protogen.mypkg.utils.MarshallFor;
import com.abn.grpcSample.protogen.mypkg.utils.ProtoUtility;
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

import java.nio.file.Path;

public class MyLib {

    public <Out> Out getResponse(ServerConfig serverConfig, ProtoDetail protoDetail, String requestJsonAsString,
                           Class<Out> outputClass) throws Exception {

        Path binaryFilePath = ProtoUtility.getDescriptorBinary(protoDetail);

        MethodDescriptor methodDescriptor = ProtoUtility.getMethodDescriptor(protoDetail,binaryFilePath);

        DynamicMessage requestAsDynamicMessage =
                convertJsonRequestToDynamicMessage(methodDescriptor, requestJsonAsString);

        return getOut(serverConfig, protoDetail, outputClass, methodDescriptor, requestAsDynamicMessage);
    }


    public <In,Out> Out getResponse(ServerConfig serverConfig, ProtoDetail protoDetail, In requestObject,
                           Class<Out> outputClass) throws Exception {

        Path binaryFilePath = ProtoUtility.getDescriptorBinary(protoDetail);

        MethodDescriptor methodDescriptor = ProtoUtility.getMethodDescriptor(protoDetail,binaryFilePath);

        DynamicMessage requestAsDynamicMessage =
                convertJsonRequestToDynamicMessage(methodDescriptor, requestObject);

        Out out = getOut(serverConfig, protoDetail, outputClass, methodDescriptor, requestAsDynamicMessage);

        return out;
    }

    private <Out> Out getOut(ServerConfig serverConfig, ProtoDetail protoDetail, Class<Out> outputClass,
                       MethodDescriptor methodDescriptor,
                       DynamicMessage requestAsDynamicMessage) throws InvalidProtocolBufferException {

        ManagedChannel managedChannel= new ChannelBuilder().createChannel(serverConfig);

        String methodFullName = protoDetail.getMethodFullName();

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

    private <Out> Out convertDynamicMessagetoResponseObject(DynamicMessage dynamicMessage, Class<Out> outputClass)
            throws InvalidProtocolBufferException {

        JsonFormat.Printer printer = JsonFormat.printer();

        String response = printer.print(dynamicMessage);

        System.out.println("response: " +response);

        return new Gson().fromJson(response, outputClass);
    }

    private <In> DynamicMessage convertJsonRequestToDynamicMessage(MethodDescriptor methodDescriptor,
                                                                   In requestObject) throws Exception{

        String requestObjectAsJson = new GsonBuilder().create().toJson(requestObject);

        return getDynamicMessageBuilder(methodDescriptor, requestObjectAsJson).build();
    }

    private DynamicMessage convertJsonRequestToDynamicMessage(MethodDescriptor methodDescriptor,
                                                              String jsonRequestAsString) throws Exception{

        return getDynamicMessageBuilder(methodDescriptor, jsonRequestAsString).build();
    }

    private DynamicMessage.Builder getDynamicMessageBuilder(MethodDescriptor methodDescriptor, String jsonRequest) throws InvalidProtocolBufferException {

        JsonFormat.Parser jsonParser = JsonFormat.parser();

        Descriptor descriptor = methodDescriptor.getInputType();

        DynamicMessage.Builder dynamicMessageBuilder = DynamicMessage.newBuilder(descriptor);

        jsonParser.merge(jsonRequest, dynamicMessageBuilder);

        return dynamicMessageBuilder;
    }


}

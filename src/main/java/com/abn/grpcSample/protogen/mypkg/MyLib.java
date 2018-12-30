package com.abn.grpcSample.protogen.mypkg;

import com.abn.grpcSample.HelloResponse;
import com.abn.grpcSample.SampleBuilder.HelloRequest;
import com.abn.grpcSample.SampleBuilder.HelloRequestBuilder;
import com.abn.grpcSample.protogen.*;
import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.abn.grpcSample.protogen.mypkg.domain.ServerConfig;
import com.google.gson.GsonBuilder;
import com.google.protobuf.Descriptors.*;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.util.JsonFormat;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;

public class MyLib<In, Out> {


    public Out getResponse(ServerConfig serverConfig, ProtoDetail protoDetail, In requestObject) throws Exception
    {

        //convert requestObjecttoDynamicMessage
        //invoke the service
        //processoutput


        MethodDescriptor methodDescriptor = ProtoUtility.getMethodDescriptor(protoDetail);

        Descriptor methodDescriptorInputType = methodDescriptor.getInputType();

        DynamicMessage requestAsDynamicMessage =
                convertRequestObjectToDynamicMessage(methodDescriptorInputType, requestObject);

        io.grpc.MethodDescriptor<DynamicMessage,DynamicMessage> getMethodDescriptor =
                io.grpc.MethodDescriptor.<DynamicMessage, DynamicMessage>newBuilder().
                        setRequestMarshaller(new MarshallFor(methodDescriptorInputType))
                        .setResponseMarshaller(new MarshallFor(methodDescriptor.getOutputType()))
                        .setFullMethodName(protoDetail.getMethodFullName())
                        .setType(ProtoUtility.getMethodType(methodDescriptor)).build();

        ManagedChannel managedChannel= serverConfig.getManagedChannel();


        DynamicMessage responseAsDynamicMessage =
                new GrpcGenericClient().unaryCall(managedChannel ,getMethodDescriptor,
                        CallOptions.DEFAULT,requestAsDynamicMessage);

        managedChannel.shutdown();


        //collect the reponse and send back as object
        return null;
    }

    private DynamicMessage convertRequestObjectToDynamicMessage(Descriptor desc, In requestObject) throws Exception{

        String jsonString = new GsonBuilder().create().toJson(requestObject);
        JsonFormat.Parser jsonParser = JsonFormat.parser();

        DynamicMessage.Builder dynamicMessageBuilder = DynamicMessage.newBuilder(desc);
        jsonParser.merge(jsonString, dynamicMessageBuilder);

        return dynamicMessageBuilder.build();
    }
}

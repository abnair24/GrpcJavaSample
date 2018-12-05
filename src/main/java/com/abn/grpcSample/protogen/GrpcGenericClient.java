package com.abn.grpcSample.protogen;




import com.google.protobuf.DynamicMessage;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import io.grpc.stub.ClientCalls;

import java.util.Iterator;
import java.util.logging.Logger;

public class GrpcGenericClient {

    private static final Logger logger = Logger.getLogger(GrpcGenericClient.class.getName());
    //private final ManagedChannel channel;


    /*
    Need a generic format for return type
     */
    public String unaryCall(ManagedChannel managedChannel,
                          MethodDescriptor<DynamicMessage,DynamicMessage> methodDescriptor,
                          CallOptions callOptions,DynamicMessage request) {

        DynamicMessage response = ClientCalls.blockingUnaryCall(managedChannel,methodDescriptor,callOptions,request);

        return response.toString();
    }

    public void serverStreamingCall(ManagedChannel managedChannel,
                                      MethodDescriptor<DynamicMessage,DynamicMessage> methodDescriptor,
                                      CallOptions callOptions,DynamicMessage request) {

        Iterator<DynamicMessage> response = ClientCalls.blockingServerStreamingCall(managedChannel,
                methodDescriptor,callOptions,request);

        response.forEachRemaining(r -> r.toString());
    }

    public void clientStreamingCall(ManagedChannel managedChannel,
                                    MethodDescriptor<DynamicMessage,DynamicMessage> methodDescriptor,
                                    CallOptions callOptions,DynamicMessage request) {


    }

}

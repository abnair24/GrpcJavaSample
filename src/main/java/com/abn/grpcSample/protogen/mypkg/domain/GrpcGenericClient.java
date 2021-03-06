package com.abn.grpcSample.protogen.mypkg.domain;

import com.google.protobuf.DynamicMessage;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;

public class GrpcGenericClient {

    private static final Logger logger = LoggerFactory.getLogger(GrpcGenericClient.class);

    /*
    Need a generic format for return type
     */
    public DynamicMessage unaryCall(ManagedChannel managedChannel,
                          MethodDescriptor<DynamicMessage,DynamicMessage> methodDescriptor,
                          CallOptions callOptions,DynamicMessage request) {

        DynamicMessage response = ClientCalls.blockingUnaryCall(managedChannel,methodDescriptor,callOptions,request);

        return response;
    }

    public void serverStreamingCall(ManagedChannel managedChannel,
                                      MethodDescriptor<DynamicMessage,DynamicMessage> methodDescriptor,
                                      CallOptions callOptions,DynamicMessage request) {

        Iterator<DynamicMessage> response = ClientCalls.blockingServerStreamingCall(managedChannel,
                methodDescriptor,callOptions,request);

        response.forEachRemaining(r -> {
            System.out.println(r.toString());
        });
    }

    public void clientStreamingCall(ManagedChannel managedChannel,
                                    MethodDescriptor<DynamicMessage,DynamicMessage> methodDescriptor,
                                    CallOptions callOptions,DynamicMessage request) {

        ClientCall<DynamicMessage,DynamicMessage> clientCall = managedChannel.newCall(methodDescriptor,callOptions);


        StreamObserver<DynamicMessage> streamResponse = ClientCalls.asyncClientStreamingCall(clientCall,
                new StreamObserver<DynamicMessage>() {

            @Override
            public void onNext(DynamicMessage value) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }

    public void bidirectionalStreaming(ManagedChannel managedChannel,
                                       MethodDescriptor<DynamicMessage,DynamicMessage> methodDescriptor,
                                       CallOptions callOptions, DynamicMessage request) {

        ClientCall<DynamicMessage, DynamicMessage> clientCall = managedChannel.newCall(methodDescriptor, callOptions);


        StreamObserver<DynamicMessage> streamResponse = ClientCalls.asyncBidiStreamingCall(clientCall,
                new StreamObserver<DynamicMessage>() {
                    @Override
                    public void onNext(DynamicMessage value) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onCompleted() {

                    }
                });

    }
}

package com.abn.grpcSample.protogen;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.ClientCalls;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrpcCaller {

    private ManagedChannel managedChannel;

    public GrpcCaller(String hostname, int port) {
        this.managedChannel = ManagedChannelBuilder.forAddress(hostname, port)
                .usePlaintext()
                .build();

    }
}

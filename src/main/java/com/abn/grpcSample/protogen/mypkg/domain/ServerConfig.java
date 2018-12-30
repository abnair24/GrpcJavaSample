package com.abn.grpcSample.protogen.mypkg.domain;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ServerConfig {

    private final String hostName;
    private final int portNumber;

    public ServerConfig(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public ManagedChannel getManagedChannel()
    {
        return ManagedChannelBuilder
                .forAddress(this.hostName,this.portNumber)
                .usePlaintext()
                .build();


    }

}

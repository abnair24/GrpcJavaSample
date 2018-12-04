package com.abn.grpcSample.sample;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GreeterServer {

    public static void main(String[] args) throws Exception {
        System.out.println("Startng server");

        Server server = ServerBuilder
                                .forPort(42422)
                                .addService(new GreeterServiceImpl())
                                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));

        server.awaitTermination();
    }
}

package com.abn.grpcSample.sample;

import com.google.protobuf.Any;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import polyglot.test.TestProto;

public class TestServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(44444)
                .addService(new TestServerImpl())
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

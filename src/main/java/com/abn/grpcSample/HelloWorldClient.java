package com.abn.grpcSample;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloWorldClient {

    private static final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());
    private final ManagedChannel channel;
    private GreeterGrpc.GreeterBlockingStub blockingStub;

    public HelloWorldClient(String hostname, int port) {
        channel = ManagedChannelBuilder.forAddress(hostname,port)
                .usePlaintext()
                .build();

        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void greet(String name) {
        logger.info("Greeting : "+name);
        try {
            HelloRequest request = HelloRequest.newBuilder().setName(name).build();
            HelloResponse response = blockingStub.sayHello(request);
            logger.info("Response "+response.getMessage());
        }catch (RuntimeException ex) {
            logger.log(Level.WARNING,"Failed", ex);
        }
    }

    public static void main(String[] args) throws  Exception {
        HelloWorldClient client = new HelloWorldClient("localhost", 42421);
        String name = "abn";

        try {
            client.greet(name);
        } finally {
            client.shutdown();
        }
   }


}

package com.abn.grpcSample.sample;

import com.abn.grpcSample.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GreeterClient {

    private static final Logger logger = Logger.getLogger(GreeterClient.class.getName());
    private final ManagedChannel channel;
    private GreeterGrpc.GreeterBlockingStub stub;
    private GreeterGrpc.GreeterStub asyncStub;

    public GreeterClient(String hostname,int port) {
        channel = ManagedChannelBuilder
                .forAddress(hostname,port)
                .usePlaintext()
                .build();

        stub = GreeterGrpc.newBlockingStub(channel);
    }

    public GreeterClient(String hostname,int port, String service) {

         /*
        Client streaming requires async stub
         */
        channel = ManagedChannelBuilder.forAddress(hostname,port).usePlaintext().build();


        asyncStub = GreeterGrpc.newStub(channel);

    }

    public void unaryCallGreet() {
        logger.info("Greet : "  );
        try {
            Greeting greeting = Greeting
                    .newBuilder()
                    .setFirstName("ABN")
                    .setLastName("test")
                    .build();
            GreetRequest request = GreetRequest
                    .newBuilder()
                    .setGreeting(greeting)
                    .build();

            /*
            Blocking unary call stub
             */
            GreetResponse response = stub.greet(request);

            /*
            Async stub unary call
             */


            logger.info("Response "+response.toString());
        } catch (RuntimeException ex) {
            logger.log(Level.WARNING, "Failed", ex);
        }
    }

    public void shutdown() throws InterruptedException{
        channel.shutdown().awaitTermination(5,TimeUnit.SECONDS);
    }

    public void serverStreamingGreetManyTimes() {
        logger.info("GreetManyTimes : "  );

        Greeting greeting = Greeting.newBuilder().setFirstName("ABN").setLastName("stream").build();

        GreetManyTimesRequest request = GreetManyTimesRequest.newBuilder().setGreeting(greeting).build();

        /*
        Server streaming using blocking stub
         */
        Iterator<GreetManyTimesResponse> greetManyTimesResponse = stub.greetManyTimes(request);


        greetManyTimesResponse.forEachRemaining(response -> {
            logger.info("Response :"+response.getResult());
        });
    }

    public void clientStreamingLongGreet() throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        StreamObserver<LongGreetRequest> requestStreamObserver = asyncStub.longGreet(new StreamObserver<LongGreetResponse>() {
            @Override
            public void onNext(LongGreetResponse value) {
                logger.info("Received response from server");
                logger.info(value.getResult());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                logger.info("Server completed response");
                countDownLatch.countDown();
            }
        });

        logger.info("Sending message #1");

        Greeting greeting1 = Greeting.newBuilder().setFirstName("abn1").setLastName("stream1").build();

        requestStreamObserver.onNext(LongGreetRequest.newBuilder().setGreeting(greeting1).build());

        logger.info("Sending message #2");

        Greeting greeting2 = Greeting.newBuilder().setFirstName("abn2").setLastName("stream2").build();

        requestStreamObserver.onNext(LongGreetRequest.newBuilder().setGreeting(greeting2).build());

        logger.info("Sending message #3");

        Greeting greeting3 = Greeting.newBuilder().setFirstName("abn3").setLastName("stream3").build();

        requestStreamObserver.onNext(LongGreetRequest.newBuilder().setGreeting(greeting3).build());

        requestStreamObserver.onCompleted();

        countDownLatch.await(2, TimeUnit.SECONDS);
    }

    public void bidirectGreetEveryone() {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        StreamObserver<GreetEveryoneRequest> requestStreamObserver = asyncStub.greetEveryone(new StreamObserver<GreetEveryoneResponse>() {
            @Override
            public void onNext(GreetEveryoneResponse value) {
                logger.info("Received response from server");
                logger.info(value.getResult());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                logger.info("Server completed response");
                countDownLatch.countDown();
            }
        });

        Arrays.asList("stream1", "stream2", "Stream3").forEach(name -> {
            System.out.println("Sending: " + name);
            requestStreamObserver.onNext(GreetEveryoneRequest
                    .newBuilder()
                    .setGreeting(Greeting
                            .newBuilder()
                            .setFirstName(name)
                            .build()
                    )
                    .build()
            );

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        try {
            countDownLatch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception{

        /*
        Unary client
         */
       // GreeterClient greeterClient = new GreeterClient("localhost",42422);
        /*
        streaming client
         */
        GreeterClient greeterClient = new GreeterClient("localhost",42422,"client streeaming");

        try {
            greeterClient.unaryCallGreet();
    //            greeterClient.serverStreamingGreetManyTimes();
//            greeterClient.clientStreamingLongGreet();
//            greeterClient.bidirectGreetEveryone();
        } finally {
            greeterClient.shutdown();
        }
    }
}

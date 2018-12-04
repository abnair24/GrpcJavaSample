package com.abn.grpcSample.sample;

import com.abn.grpcSample.*;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;

public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);

        HelloResponse response = HelloResponse
                .newBuilder()
                .setMessage("Hello "+request.getName())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }

    /*
    Unary
     */
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {

        Greeting greeting = request.getGreeting();
        String firstName = greeting.getFirstName();

        String result = "Hello" + firstName;

        GreetResponse response = GreetResponse
                .newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    /*
    Server streaming
     */

    @Override
    public void greetManyTimes(GreetManyTimesRequest request, StreamObserver<GreetManyTimesResponse> responseObserver)  {
        String firstName = request.getGreeting().getFirstName();

        try{
            for(int i =0; i<=10;i++){
                String result = "Hello "+ firstName +" : "+i;
                GreetManyTimesResponse response = GreetManyTimesResponse
                        .newBuilder()
                        .setResult(result)
                        .build();
                responseObserver.onNext(response);
                Thread.sleep(1000);
            }
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }
    }

    /*
    Client streaming
     */
    @Override
    public StreamObserver<LongGreetRequest> longGreet(StreamObserver<LongGreetResponse> responseObserver) {
        StreamObserver<LongGreetRequest> requestStreamObserver = new StreamObserver<LongGreetRequest>() {

            String result ="";

            @Override
            public void onNext(LongGreetRequest value) {
                result += "Hello "+ value.getGreeting().getFirstName();
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

                responseObserver.onNext(LongGreetResponse
                                            .newBuilder()
                                            .setResult(result)
                                            .build()
                );
                responseObserver.onCompleted();
            }
        };
        return requestStreamObserver;
    }

    /*
    Bidirectional
     */

    @Override
    public StreamObserver<GreetEveryoneRequest> greetEveryone(StreamObserver<GreetEveryoneResponse> responseObserver) {

        StreamObserver<GreetEveryoneRequest> requestStreamObserver = new StreamObserver<GreetEveryoneRequest>() {
            @Override
            public void onNext(GreetEveryoneRequest value) {
                String result = "Hello "+ value.getGreeting().getFirstName();
                GreetEveryoneResponse response = GreetEveryoneResponse
                        .newBuilder()
                        .setResult(result)
                        .build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
        return requestStreamObserver;
    }

    /*
    Deadline request
     */
    @Override
    public void greetWithDeadline(GreetWithDeadlineRequest request, StreamObserver<GreetWithDeadlineResponse> responseObserver) {
        Context context = Context.current();

        try {
            for (int i = 0; i < 3; i++) {
                if (!context.isCancelled()) {
                    System.out.println("Sleep for 100 ms");
                    Thread.sleep(100);
                } else {
                    return;
                }
            }

            System.out.println("Send response");
            responseObserver.onNext(
                    GreetWithDeadlineResponse
                            .newBuilder()
                            .setResult("Hello: " + request.getGreeting().getFirstName())
                            .build()
            );

            responseObserver.onCompleted();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

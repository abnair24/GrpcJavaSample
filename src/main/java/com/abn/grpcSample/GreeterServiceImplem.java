package com.abn.grpcSample;

import io.grpc.stub.StreamObserver;

public class GreeterServiceImplem extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseStreamObserver) {
        System.out.println(request);

        HelloResponse response = HelloResponse
                .newBuilder()
                .setMessage("Hello "+request.getName())
                .build();

        responseStreamObserver.onNext(response);

        responseStreamObserver.onCompleted();
    }
}

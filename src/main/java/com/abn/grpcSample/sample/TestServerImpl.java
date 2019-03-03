package com.abn.grpcSample.sample;


import com.google.protobuf.Duration;
import helloworld.test.TestProto;
import helloworld.test.TestServiceGrpc;
import io.grpc.stub.StreamObserver;


public class TestServerImpl extends TestServiceGrpc.TestServiceImplBase {

    @Override
    public void testMethod(TestProto.TestRequest request, StreamObserver<TestProto.TestResponse> responseStream) {


       TestProto.TestResponse response = TestProto.TestResponse.newBuilder()
                .setMessage("some fancy message : "+ request.getMessage())
                .setDuration(Duration.newBuilder()
                        .setSeconds(12)
                        .setNanos(45))
                .build();
        responseStream.onNext(response);
        responseStream.onCompleted();
    }
}

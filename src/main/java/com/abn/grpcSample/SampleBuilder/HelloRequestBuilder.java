package com.abn.grpcSample.SampleBuilder;

public class HelloRequestBuilder {

    HelloRequest helloRequest;

    public HelloRequestBuilder() {
        helloRequest = new HelloRequest();
        helloRequest.setName("sasi");

    }

    public HelloRequest build() {
        return helloRequest;
    }
}

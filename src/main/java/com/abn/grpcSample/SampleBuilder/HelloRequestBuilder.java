package com.abn.grpcSample.SampleBuilder;

public class HelloRequestBuilder {

    HelloRequest helloRequest;

    public HelloRequestBuilder() {
        helloRequest = new HelloRequest("DEFAULT_NAME");
        helloRequest.setName("sasi");
    }

    public HelloRequest build() {
        return helloRequest;
    }
}

package com.abn.grpcSample.SampleBuilder;

public class HelloRequestBuilder {

    HelloRequest helloRequest;

    public HelloRequestBuilder() {
        helloRequest = new HelloRequest();
        helloRequest.setName("ABN");
    }

    public HelloRequest build() {
        return helloRequest;
    }
}

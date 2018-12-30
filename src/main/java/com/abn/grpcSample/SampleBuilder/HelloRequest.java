package com.abn.grpcSample.SampleBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloRequest {

    private String name;

    public HelloRequest(String name) {
        this.name = name;
    }
}

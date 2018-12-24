package com.abn.grpcSample.SampleBuilder;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class HelloRequest implements Serializable {

    private static final long serialVersionUID = 5230549922091722630L;

    private String name;
}

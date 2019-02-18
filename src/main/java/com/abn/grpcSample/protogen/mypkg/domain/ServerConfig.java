package com.abn.grpcSample.protogen.mypkg.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServerConfig {

    private final String hostName;
    private final int portNumber;

}

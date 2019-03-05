package com.abn.grpcSample.protogen.mypkg.domain;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

@Getter
@Setter
public class ServerConfig {

    private static final Logger logger = LoggerFactory.getLogger(ServerConfig.class);

    private final String hostName;
    private final int portNumber;
    private Map<String,String> metadata;

    public ServerConfig(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public ServerConfig(String hostName, int portNumber, Map<String, String> metadata) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.metadata = metadata;
    }
}

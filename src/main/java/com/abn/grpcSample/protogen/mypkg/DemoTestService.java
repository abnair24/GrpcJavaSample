package com.abn.grpcSample.protogen.mypkg;

import com.abn.grpcSample.SampleBuilder.HelloResponse;
import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.abn.grpcSample.protogen.mypkg.domain.ServerConfig;

public class DemoTestService {

    public static void main(String[] args) throws Exception {
        ServerConfig serverConfig = new ServerConfig("localhost", 44444);

        final String protoPath = "/Users/aswathyn/Personal/Docs/Java-WS/gRPC-Java/src/main/proto";
        final String proto = "TestService";

        String fullMethod = "helloworld.test.TestService/TestMethod";

        ProtoDetail protoDetail = new ProtoDetail(protoPath, proto, fullMethod);
//        HelloRequest helloRequest = new HelloRequestBuilder().build();
//
//        requestAsObject(serverConfig,protoDetail,helloRequest);

        String request = "{ message :\"Some message\",number : 1 }";

        HelloResponse helloResponse = new MyLib().getResponse(serverConfig,protoDetail,request,HelloResponse.class);

    }
}

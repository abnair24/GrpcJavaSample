package com.abn.grpcSample.protogen.mypkg;

import com.abn.grpcSample.HelloResponse;
import com.abn.grpcSample.SampleBuilder.HelloRequest;
import com.abn.grpcSample.SampleBuilder.HelloRequestBuilder;
import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.abn.grpcSample.protogen.mypkg.domain.ServerConfig;

public class DemoMain {

    public static void main(String[] args) throws Exception {

        ServerConfig serverConfig = new ServerConfig("localhost", 42422);

        final String protoPath = "/Users/aswathyn/Personal/Docs/Java-WS/gRPC-Java/src/main/proto";
        final String proto = "HelloService";
        String packageName = "helloworld";
        String serviceName = "Greeter";
        String methodName = "SayHello";

        ProtoDetail protoDetail = new ProtoDetail(protoPath, proto, packageName, serviceName, methodName);
        HelloRequest helloRequest = new HelloRequestBuilder().build();

        MyLib<HelloRequest, HelloResponse> myLib = new MyLib<>();
        myLib.getResponse(serverConfig, protoDetail, helloRequest);

    }

    //pending :
    //converting response to output object
    //exception catching - now its all thrown
    //writing unit tests
    // using it in other places
    // documentation

}

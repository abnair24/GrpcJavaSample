package com.abn.grpcSample.protogen.mypkg;

import com.abn.grpcSample.SampleBuilder.HelloRequest;
import com.abn.grpcSample.SampleBuilder.HelloRequestBuilder;
import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.abn.grpcSample.protogen.mypkg.domain.ServerConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.abn.grpcSample.protogen.mypkg.DemoMain.jsonStringRequest;
import static com.abn.grpcSample.protogen.mypkg.DemoMain.requestAsObject;

public class TestDemo {

    String protoPath;
    ServerConfig serverConfig;
    String fullMethod;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
        serverConfig = new ServerConfig("localhost",42422);
        protoPath = "/Users/aswathyn/Personal/Docs/Java-WS/gRPC-Java/src/main/proto";
        fullMethod ="helloworld.Greeter/SayHello";
    }

    @Test
    public void test1() throws Exception{
        ProtoDetail protoDetail = new ProtoDetail(protoPath, fullMethod);
        HelloRequest helloRequest = new HelloRequestBuilder().build();
        requestAsObject(serverConfig,protoDetail,helloRequest);
    }

    @Test
    public void test2() throws Exception {
        ProtoDetail protoDetail = new ProtoDetail(protoPath, fullMethod);
        String helloRequest1 = "{ name :\"Sasi\"}";
        jsonStringRequest(serverConfig,protoDetail,helloRequest1);
    }

    @Test
    public void test3() throws Exception{
        ProtoDetail protoDetail = new ProtoDetail(protoPath, fullMethod);
        HelloRequest helloRequest = new HelloRequestBuilder().build();
        requestAsObject(serverConfig,protoDetail,helloRequest);
    }

    @Test
    public void test4() throws Exception {
        ProtoDetail protoDetail = new ProtoDetail(protoPath, fullMethod);
        String helloRequest1 = "{ name :\"Sasi\"}";
        jsonStringRequest(serverConfig,protoDetail,helloRequest1);
    }


}

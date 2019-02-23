package com.abn.grpcSample.protogen.mypkg;

import com.abn.grpcSample.SampleBuilder.HelloRequest;
import com.abn.grpcSample.SampleBuilder.HelloRequestBuilder;
import com.abn.grpcSample.SampleBuilder.HelloResponse;
import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.abn.grpcSample.protogen.mypkg.domain.ServerConfig;

import java.util.Properties;


public class DemoMain {

    public static void main(String[] args) throws Exception {

        ServerConfig serverConfig = new ServerConfig("localhost", 42422);

        final String protoPath = "/Users/aswathyn/Personal/Docs/Java-WS/gRPC-Java/src/main/proto";
        final String proto = "HelloService";

        String fullMethod = "helloworld.Greeter/SayHello";

        ProtoDetail protoDetail = new ProtoDetail(protoPath, proto, fullMethod);
            HelloRequest helloRequest = new HelloRequestBuilder().build();
//
        requestAsObject(serverConfig,protoDetail,helloRequest);

//        String helloRequest = "{ name :\"Sasi\"}";
//        jsonStringRequest(serverConfig,protoDetail,helloRequest);
    }


    public static void jsonStringRequest(ServerConfig serverConfig,ProtoDetail protoDetail, String helloRequest)
            throws Exception {
        MyLib myLib = new MyLib();
        HelloResponse helloResponse = myLib.getResponse(serverConfig, protoDetail, helloRequest, HelloResponse.class);

    }

    public static void requestAsObject(ServerConfig serverConfig, ProtoDetail protoDetail, HelloRequest helloRequest)
            throws Exception {
        MyLib myLib = new MyLib();
        HelloResponse helloResponse = myLib.getResponse(serverConfig, protoDetail, helloRequest, HelloResponse.class);
    }

    //pending :
    // using it in real world case : identify the gaps and fill them
    //exception catching - now its all thrown
    //writing unit tests
    // documentation


    /*Observations :
     and use inbuilt METHODS to seperate out.
                     3) Clean up structure out protoparsing and arrange
                     */

}

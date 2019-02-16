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

        MyLib<HelloRequest, HelloResponse> myLib = new MyLib<>();
        HelloResponse helloResponse = myLib.getResponse(serverConfig, protoDetail, helloRequest, HelloResponse.class);
        System.out.println("from the object:  " +helloResponse.getMessage());
    }

    //pending :
    // using it in real world case : identify the gaps and fill them
    //exception catching - now its all thrown
    //writing unit tests
    // documentation


    /*Observations : 1) Too many input arguments - input method name in full format (package+service+method name)
     and use inbuilt METHODS to seperate out.
                     2) Allow to take input in json format (just like passing json body in rest -assured)
                     3) Clean up structure out protoparsing and arrange
                     */

}

package com.abn.grpcSample.protogen.mypkg.domain;

import io.grpc.MethodDescriptor;

import java.sql.SQLOutput;

public class ProtoDetail {

    private final String protoPath;
    private final String proto;
    private final String serviceName;
    private final String packageName;
    private final String methodName;

    private static final  String PROTO_FILE_EXTENSION = ".proto";

    public ProtoDetail(String protoPath, String proto, String fullMethodName) {

        String fullService = MethodDescriptor.extractFullServiceName(fullMethodName);
        String methodName = fullMethodName.substring(fullService.length()+1);
        int index = fullMethodName.lastIndexOf('.');
        String packageName = fullMethodName.substring(0, index);

        String serviceName = fullService.substring(index + 1);

        this.protoPath = protoPath;
        this.proto = proto;
        this.serviceName = serviceName;
        this.packageName = packageName;
        this.methodName = methodName;

    }

    public String getProtoPath() {
        return protoPath;
    }

    public String getProtoWithExtention() {
        return proto+ PROTO_FILE_EXTENSION;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getMethodFullName()
    {
        return this.getPackageName()+"."+ this.getServiceName()+"/"+this.getMethodName();
    }

}

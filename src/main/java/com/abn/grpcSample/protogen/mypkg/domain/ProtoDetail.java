package com.abn.grpcSample.protogen.mypkg.domain;

import io.grpc.MethodDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDetail {

    private static final Logger logger = LoggerFactory.getLogger(ProtoDetail.class);

    private final String protoPath;
    private final String proto;
    private final String serviceName;
    private final String packageName;
    private final String methodName;

    private static final  String PROTO_FILE_EXTENSION = ".proto";

    public ProtoDetail(String protoPath, String proto, String fullMethodName) {

        String fullService = MethodDescriptor.extractFullServiceName(fullMethodName);

        if(fullService == null) {
            throw new IllegalArgumentException("Failed extracting service name"+fullMethodName);
        }

        String methodName = getMethodName(fullMethodName, fullService.length());

        String packageName = getPackageName(fullMethodName);

        String serviceName = getServiceName(fullService, fullMethodName.lastIndexOf('.'));

        this.protoPath = protoPath;
        this.proto = proto;
        this.serviceName = serviceName;
        this.packageName = packageName;
        this.methodName = methodName;
    }

    private String getServiceName(String fullService, int i) {
        return getMethodName(fullService, i);
    }

    private String getPackageName(String fullMethodName) {
        return fullMethodName.substring(0, fullMethodName.lastIndexOf('.'));
    }

    private String getMethodName(String fullMethodName, int length) {
        return fullMethodName.substring(length + 1);
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

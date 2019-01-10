package com.abn.grpcSample.protogen.mypkg.domain;

public class ProtoDetail {

    private final String protoPath;
    private final String proto;
    private final String serviceName;
    private final String packageName;
    private final String methodName;

    private static final  String PROTO_FILE_EXTENSION = ".proto";

    public ProtoDetail(String protoPath, String proto, String packageName, String serviceName, String methodName) {
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

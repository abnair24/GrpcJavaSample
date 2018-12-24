package com.abn.grpcSample.protogen.mypkg.domain;

public class ProtoDetails {

    private final String protoPath;
    private final String proto;
    private final String serviceName;
    private final String packageName;

    private static final  String PROTO_FILE_EXTENSION = ".proto";

    public ProtoDetails(String protoPath, String proto, String packageName, String serviceName) {
        this.protoPath = protoPath;
        this.proto = proto;
        this.serviceName = serviceName;
        this.packageName = packageName;
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
}

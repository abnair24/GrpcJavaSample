package com.abn.grpcSample.protogen.mypkg.utils;

import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ProtoBufDecoder {

    public static Descriptors.MethodDescriptor getDescriptor(ProtoDetail protoDetail,
                                                             String protoDescriptorFilePath) throws Exception {

        DescriptorProtos.FileDescriptorSet fdSet = DescriptorProtos
                .FileDescriptorSet.parseFrom(new FileInputStream(protoDescriptorFilePath));

        Map<String, Set<Descriptors.FileDescriptor>> fdDependencyMap = new HashMap<>();

        Map<String, Descriptors.FileDescriptor> fdMap = new HashMap<>();

        ProtoBufDecoder.getAllFileDescriptors(fdSet,fdDependencyMap,fdMap);

        return getMethodDescriptor(protoDetail,fdMap);
    }

    private static void getAllFileDescriptors(DescriptorProtos.FileDescriptorSet fdSet,
                                             Map<String,Set<Descriptors.FileDescriptor>>fdDependencyMap,
                                             Map<String,Descriptors.FileDescriptor>fdMap) {

        List<DescriptorProtos.FileDescriptorProto> fdProtoList = fdSet.getFileList();

        for (DescriptorProtos.FileDescriptorProto fdProto : fdSet.getFileList()) {
            if (!fdMap.containsKey(fdProto.getName())) {
                System.out.println("inside fdmap");
                Set<Descriptors.FileDescriptor> dependencies = fdDependencyMap.get(fdProto.getName());
                if (dependencies == null) {
                    dependencies = new LinkedHashSet<>();
                    fdDependencyMap.put(fdProto.getName(), dependencies);
                    try {
                        dependencies.addAll(getDependencies(fdDependencyMap, fdMap, fdProto, fdSet));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                Descriptors.FileDescriptor fileDescriptor = null;
                try {
                    fileDescriptor = Descriptors.FileDescriptor
                            .buildFrom(fdProto,
                                    dependencies.toArray(new Descriptors.FileDescriptor[dependencies.size()]));
                } catch (Descriptors.DescriptorValidationException e) {
                    e.printStackTrace();
                }
                fdMap.put(fdProto.getName(), fileDescriptor);
            }
        }
    }

    private static Collection<? extends Descriptors.FileDescriptor> getDependencies(
            Map<String, Set<Descriptors.FileDescriptor>> fdDependencyMap,
            Map<String, Descriptors.FileDescriptor> fdMap,
            DescriptorProtos.FileDescriptorProto fdProto,
            DescriptorProtos.FileDescriptorSet fdSet) throws Exception{

        Set<Descriptors.FileDescriptor> result = new LinkedHashSet<>();
        for(String name : fdProto.getDependencyList()){
            DescriptorProtos.FileDescriptorProto fileDescriptorProto = null;
            for(DescriptorProtos.FileDescriptorProto fdp : fdSet.getFileList()) {
                if(name.equals(fdp.getName())) {
                    fileDescriptorProto = fdp;
                    break;
                }
            }
            if(fileDescriptorProto ==  null) {
                throw new Exception("FD proto null");
            }
            Descriptors.FileDescriptor fileDescriptor = null;
            if(fdMap.containsKey(fileDescriptorProto.getName())) {
                fileDescriptor = fdMap.get(fileDescriptorProto.getName());
            } else {
                Set<Descriptors.FileDescriptor>dependency = new LinkedHashSet<>();
                if(fdDependencyMap.containsKey(name)) {
                    dependency.addAll(fdDependencyMap.get(name));
                } else {
                    dependency.addAll(getDependencies(fdDependencyMap,fdMap,fileDescriptorProto,fdSet));
                }
                try {
                    fileDescriptor = Descriptors.FileDescriptor
                            .buildFrom(fileDescriptorProto,
                                    dependency.toArray(new Descriptors.FileDescriptor[dependency.size()]));
                } catch (Descriptors.DescriptorValidationException e) {
                    e.printStackTrace();
                }
            }
            result.add(fileDescriptor);
        }
        return result;
    }

    public static Descriptors.MethodDescriptor getMethodDescriptor(ProtoDetail protoDetail,
                                                                   Map<String,Descriptors.FileDescriptor>fileDescriptorMap) {
        String serviceName = protoDetail.getServiceName();
        String methodName = protoDetail.getMethodName();
        String packageName = protoDetail.getPackageName();

        Descriptors.ServiceDescriptor serviceDescriptor=null;

        List<Descriptors.FileDescriptor> fileDescriptorList = fileDescriptorMap
                .values()
                .stream()
                .collect(Collectors.toList());

        for(Descriptors.FileDescriptor fileDescriptor : fileDescriptorList) {
            if (!fileDescriptor.getPackage().equals(packageName)) {
                continue;
            } else {
                serviceDescriptor = fileDescriptor.findServiceByName(serviceName);

                if (serviceDescriptor == null) {
                    throw new IllegalArgumentException("Service Not found :" + serviceName);
                }
                break;
            }
        }
        return serviceDescriptor.findMethodByName(methodName);
    }

    public static io.grpc.MethodDescriptor.MethodType getMethodType(Descriptors.MethodDescriptor methodDescriptor){
        if(!methodDescriptor.toProto().getServerStreaming() && !methodDescriptor.toProto().getClientStreaming()) {
            return io.grpc.MethodDescriptor.MethodType.UNARY;
        } else if(!methodDescriptor.toProto().getServerStreaming() && methodDescriptor.toProto().getClientStreaming()) {
            return io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING;
        } else if(methodDescriptor.toProto().getServerStreaming() && !methodDescriptor.toProto().getClientStreaming()) {
            return io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING;
        } else {
            return io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING;
        }
    }
}
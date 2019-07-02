package com.abn.grpcSample.protogen.mypkg.utils;

import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.*;


public class ProtoBufDecoder {

    private static Descriptors.MethodDescriptor getDescriptor(ProtoDetail protoDetail,
                                                             String protoDescriptorFilePath) throws Exception {

        DescriptorProtos.FileDescriptorSet fdSet = DescriptorProtos
                .FileDescriptorSet.parseFrom(new FileInputStream(protoDescriptorFilePath));

        List<Descriptors.FileDescriptor> fdList = new ArrayList<>();

        for(DescriptorProtos.FileDescriptorProto fileDescriptorProto: fdSet.getFileList()) {
            fdList.add(ProtoCache.getFileDescriptor(fileDescriptorProto));
        }
        return getMethodDescriptor(protoDetail,fdList);
    }


    public static Descriptors.FileDescriptor getAllFileDescriptors(DescriptorProtos.FileDescriptorProto fileDescriptorProto) throws Exception {

        Descriptors.FileDescriptor fileDescriptor =null;
        List<String>dependencies = fileDescriptorProto.getDependencyList();

        List<Descriptors.FileDescriptor> fdlist = new ArrayList<>();
        for(String dep : dependencies) {
            Descriptors.FileDescriptor fd = null;
            for(DescriptorProtos.FileDescriptorProto fdp : ProtoCache.getAllFileDescriptorFromCache()) {
                if (dep.equals(fdp.getName())) {
                    fd = ProtoCache.getFileDescriptor(fdp);
                }
            }
            if(fd!=null) {
                fdlist.add(fd);
            }
        }
        if(fdlist.size()== dependencies.size()) {
            Descriptors.FileDescriptor[] fds = new Descriptors.FileDescriptor[fdlist.size()];
            fileDescriptor = Descriptors.FileDescriptor.buildFrom(fileDescriptorProto,fdlist.toArray(fds));
        }
        return fileDescriptor;
    }

    public static Descriptors.MethodDescriptor getMethodDescriptor(ProtoDetail protoDetail, Path descFile) throws Exception {
        return ProtoBufDecoder.getDescriptor(protoDetail,descFile.toAbsolutePath().toString());
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

    private static Descriptors.MethodDescriptor getMethodDescriptor(ProtoDetail protoDetail,
                                                                   List<Descriptors.FileDescriptor>fileDescriptorList) {
        String serviceName = protoDetail.getServiceName();
        String methodName = protoDetail.getMethodName();
        String packageName = protoDetail.getPackageName();

        Descriptors.ServiceDescriptor serviceDescriptor=null;

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

//    public static Descriptors.MethodDescriptor getD(ProtoDetail pd, String pdpath) throws  Exception {
//        DescriptorProtos.FileDescriptorSet fdSet = DescriptorProtos
//                .FileDescriptorSet.parseFrom(new FileInputStream(pdpath));
//
//        List<Descriptors.FileDescriptor> fdList = null;
//
//        for(DescriptorProtos.FileDescriptorProto fdProto : fdSet.getFileList()) {
//            fdList.add(ProtoCache.getFileDescriptor(fdProto));
//        }
//
//    }

//    private static void getAllFileDescriptors(DescriptorProtos.FileDescriptorSet fdSet,
//                                             Map<String,Set<Descriptors.FileDescriptor>>fdDependencyMap,
//                                             Map<String,Descriptors.FileDescriptor>fdMap) {
//
//
//      //  List<DescriptorProtos.FileDescriptorProto> fdProtoList = fdSet.getFileList();
//
//        for (DescriptorProtos.FileDescriptorProto fdProto : fdSet.getFileList()) {
//            if (!fdMap.containsKey(fdProto.getName())) {
//                System.out.println("inside fdmap");
//                Set<Descriptors.FileDescriptor> dependencies = fdDependencyMap.get(fdProto.getName());
//                if (dependencies == null) {
//                    dependencies = new LinkedHashSet<>();
//                    fdDependencyMap.put(fdProto.getName(), dependencies);
//                    try {
//                        dependencies.addAll(getDependencies(fdDependencyMap, fdMap, fdProto, fdSet));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                Descriptors.FileDescriptor fileDescriptor = null;
//                try {
//                    fileDescriptor = Descriptors.FileDescriptor
//                            .buildFrom(fdProto,
//                                    dependencies.toArray(new Descriptors.FileDescriptor[dependencies.size()]));
//                } catch (Descriptors.DescriptorValidationException e) {
//                    e.printStackTrace();
//                }
//                fdMap.put(fdProto.getName(), fileDescriptor);
//            }
//        }
//    }
//
//    private static Map<String,Descriptors.FileDescriptor> getAll(DescriptorProtos.FileDescriptorSet fileDescriptorSet) throws Exception {
//
//        Map<String,Descriptors.FileDescriptor> fileDescMap = new HashMap<>();
//        for(DescriptorProtos.FileDescriptorProto fileDescriptorProto : fileDescriptorSet.getFileList() ) {
//            if(!fileDescMap.containsKey(fileDescriptorProto.getName())) {
//                List<String>dependencies = fileDescriptorProto.getDependencyList();
//                List<Descriptors.FileDescriptor> fdlist = new ArrayList<>();
//                for(String dep : dependencies) {
//                    Descriptors.FileDescriptor fd = fileDescMap.get(dep);
//                    if(fd!=null) {
//                        fdlist.add(fd);
//                    }
//                }
//                if(fdlist.size()== dependencies.size()) {
//                    Descriptors.FileDescriptor[] fds = new Descriptors.FileDescriptor[fdlist.size()];
//                    Descriptors.FileDescriptor fd = Descriptors.FileDescriptor.buildFrom(fileDescriptorProto,fdlist.toArray(fds));
//                    fileDescMap.put(fileDescriptorProto.getName(),fd);
//                }
//            }
//        }
//        return fileDescMap;
//    }



//    private static Collection<? extends Descriptors.FileDescriptor> getDependencies(
//            Map<String, Set<Descriptors.FileDescriptor>> fdDependencyMap,
//            Map<String, Descriptors.FileDescriptor> fdMap,
//            DescriptorProtos.FileDescriptorProto fdProto,
//            DescriptorProtos.FileDescriptorSet fdSet) throws Exception{
//
//        Set<Descriptors.FileDescriptor> result = new LinkedHashSet<>();
//        for(String name : fdProto.getDependencyList()){
//            DescriptorProtos.FileDescriptorProto fileDescriptorProto = null;
//            for(DescriptorProtos.FileDescriptorProto fdp : fdSet.getFileList()) {
//                if(name.equals(fdp.getName())) {
//                    fileDescriptorProto = fdp;
//                    break;
//                }
//            }
//            if(fileDescriptorProto ==  null) {
//                throw new Exception("FD proto null");
//            }
//            Descriptors.FileDescriptor fileDescriptor = null;
//            if(fdMap.containsKey(fileDescriptorProto.getName())) {
//                fileDescriptor = fdMap.get(fileDescriptorProto.getName());
//            } else {
//                Set<Descriptors.FileDescriptor>dependency = new LinkedHashSet<>();
//                if(fdDependencyMap.containsKey(name)) {
//                    dependency.addAll(fdDependencyMap.get(name));
//                } else {
//                    dependency.addAll(getDependencies(fdDependencyMap,fdMap,fileDescriptorProto,fdSet));
//                }
//                try {
//                    fileDescriptor = Descriptors.FileDescriptor
//                            .buildFrom(fileDescriptorProto,
//                                    dependency.toArray(new Descriptors.FileDescriptor[dependency.size()]));
//                } catch (Descriptors.DescriptorValidationException e) {
//                    e.printStackTrace();
//                }
//            }
//            result.add(fileDescriptor);
//        }
//        return result;
//    }


}
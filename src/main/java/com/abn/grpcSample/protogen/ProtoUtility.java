package com.abn.grpcSample.protogen;

import com.google.protobuf.DescriptorProtos.*;
import com.google.protobuf.*;
import com.google.protobuf.Descriptors.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtoUtility {

    /*
    Generating fileDescriptorSet from desc file.
     */
    public static FileDescriptorSet getFileDescriptorSet(String descriptorPath) throws Exception {
        FileDescriptorSet fileDescriptorSet = FileDescriptorSet.parseFrom(new FileInputStream(descriptorPath));
        return fileDescriptorSet;
    }

    /*
    Helper for generating fdset
     */

    public static Map<String, FileDescriptorProto> getFileDescriptorProtos(String descFilePath) throws Exception {
        FileDescriptorSet fileDescSet = getFileDescriptorSet(descFilePath);
        return getFileDescriptorProtos(fileDescSet);
    }

    /*
   Generating FileDescriptorProtos from fdset
    */
    public static Map<String, FileDescriptorProto> getFileDescriptorProtos(FileDescriptorSet fileDescSet) {
        Map<String, FileDescriptorProto> map = new HashMap<String, FileDescriptorProto>();
        List<FileDescriptorProto> fileDescProtos = fileDescSet.getFileList();
        for (FileDescriptorProto fileDescProto : fileDescProtos) {
            map.put(fileDescProto.getName(), fileDescProto);
        }
        return map;
    }

    public static ServiceDescriptor getServiceDescriptor(FileDescriptor fileDescriptor,String serviceName) {
        ServiceDescriptor serviceDescriptor = fileDescriptor.findServiceByName(serviceName);
        return serviceDescriptor;
    }

    public static MethodDescriptor getMethodDesciptor(ServiceDescriptor serviceDescriptor,String methodName) {
        return serviceDescriptor.findMethodByName(methodName);
    }

    public static FileDescriptor[] getDependencies(Map<String, FileDescriptorProto> fileDescProtos, FileDescriptorProto fileDescProto) throws Exception {
        if (fileDescProto.getDependencyCount() == 0)
            return new FileDescriptor[0];

        ProtocolStringList dependencyList = fileDescProto.getDependencyList();
        String[] dependencyArray = dependencyList.toArray(new String[0]);
        int noOfDependencies = dependencyList.size();

        FileDescriptor[] dependencies = new FileDescriptor[noOfDependencies];

        for (int i = 0; i < noOfDependencies; i++) {
            FileDescriptorProto dependencyFileDescProto = fileDescProtos.get(dependencyArray[i]);
            FileDescriptor dependencyFileDesc = FileDescriptor.buildFrom(dependencyFileDescProto, getDependencies(fileDescProtos, dependencyFileDescProto));
            dependencies[i] = dependencyFileDesc;
        }

        return dependencies;
    }
}


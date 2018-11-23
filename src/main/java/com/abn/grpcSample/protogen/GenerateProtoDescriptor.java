package com.abn.grpcSample.protogen;

import com.google.common.collect.ImmutableList;
import com.google.protobuf.DescriptorProtos.*;
import com.google.protobuf.Descriptors.*;
import com.google.protobuf.DynamicMessage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class GenerateProtoDescriptor {

    public static void main(String[] args) throws Exception {

        final String protoPath = "/Users/aswathyn/Personal/Docs/Java-WS/gRPC-Java/src/main/proto";
        final String proto = "DynamicProto.proto";
        final String messageTypeName = "DynamicRequest";

        //pb.bin or .desc whats the diff?
        Path descFile = Files.createTempFile("protoDesc", ".desc");

        ImmutableList<String> protocArgs = ImmutableList.<String>builder()
                .add("--include_imports")
                .add("--proto_path=" + protoPath)
                .add("--descriptor_set_out=" + descFile.toAbsolutePath().toString())
                .add(proto)
                .build();
//
        int status = new ProtocInvoker().invoke(protocArgs);
        System.out.println("status :" + status);

        Map<String, FileDescriptorProto> fileDescProtos =
                ProtoUtility.getFileDescriptorProtos(descFile.toAbsolutePath().toString());

        FileDescriptorProto fileDescProto = fileDescProtos.get(proto);

        FileDescriptor[] dependencies = ProtoUtility.getDependencies(fileDescProtos, fileDescProto);
        FileDescriptor fileDesc = FileDescriptor.buildFrom(fileDescProto, dependencies);
        Descriptor desc = fileDesc.findMessageTypeByName(messageTypeName);


        displayFieldDetails(desc.findFieldByName("id"));
        displayFieldDetails(desc.findFieldByName("name"));
        displayFieldDetails(desc.findFieldByName("address"));

        System.out.println();

        DynamicMessage dynMessage = DynamicMessage.newBuilder(desc)
                .setField(desc.findFieldByName("id"), 1)
                .setField(desc.findFieldByName("name"), "John Lao")
                .setField(desc.findFieldByName("address"), "Block 1 Happy St.")
                .build();

        byte[] dynMessageInBytes = dynMessage.toByteArray();

        DynamicMessage dynMessage2 = DynamicMessage.parseFrom(desc, dynMessageInBytes);

        System.out.println(dynMessage2);
    }


    private static void displayFieldDetails(FieldDescriptor fieldDesc) {
        System.out.printf("%s : %s",
                fieldDesc.getName(),
                fieldDesc.getJavaType().name());
        if (fieldDesc.getJavaType().name().equals("MESSAGE")) {
            System.out.printf(" (%s)", fieldDesc.getMessageType().getName());
        }
        else if (fieldDesc.getJavaType().name().equals("ENUM")) {
            System.out.printf(" (%s)", fieldDesc.getEnumType().getName());
        }
        System.out.println();
    }

}

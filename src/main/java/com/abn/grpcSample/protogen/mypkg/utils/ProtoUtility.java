package com.abn.grpcSample.protogen.mypkg.utils;

import com.abn.grpcSample.protogen.mypkg.domain.ProtoDetail;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Descriptors.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Files;
import java.nio.file.Path;


public class ProtoUtility {

    private static final Logger logger = LoggerFactory.getLogger(ProtoUtility.class);

    public static Path getDescriptorBinary(ProtoDetail protoDetail) throws Exception{

        int status;

        Path descFile = Files.createTempFile("protoDesc", ".desc");

        ImmutableList<String> protocArgs = ImmutableList.<String>builder()
                .add("--include_imports")
                .add("--include_std_types")
                .add("--proto_path=" + protoDetail.getProtoPath())
                .add("--descriptor_set_out=" + descFile.toAbsolutePath().toString())
                .addAll(protoDetail.getProtoFilesPath())
                .build();

        status = new ProtocInvoker().invoke(protocArgs);

        if(status != 0) {
            logger.error("Binary file generation failed with status : "+status);
        }

        return descFile;
    }

    public static MethodDescriptor getMethodDescriptor(ProtoDetail protoDetail, Path descFile) throws Exception {

        return ProtoBufDecoder.getDescriptor(protoDetail,descFile.toAbsolutePath().toString());
    }

}


package com.abn.grpcSample.protogen.mypkg.utils;

import com.github.os72.protocjar.Protoc;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtocInvoker {

    private static final Logger logger = LoggerFactory.getLogger(ProtocInvoker.class);


    public int invoke(ImmutableList<String> protocArgs) throws Exception {

        //int status = Protoc.
        return Protoc.runProtoc(protocArgs.toArray(new String[0]));

    }
}

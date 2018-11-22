package com.abn.grpcSample.protogen;

import com.github.os72.protocjar.Protoc;
import com.google.common.collect.ImmutableList;

public class ProtocInvoker {

    public int invoke(ImmutableList<String> protocArgs) throws Exception {

        //int status = Protoc.
        return Protoc.runProtoc(protocArgs.toArray(new String[0]));

    }
}

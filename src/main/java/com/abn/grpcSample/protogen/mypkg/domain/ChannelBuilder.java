package com.abn.grpcSample.protogen.mypkg.domain;

import io.grpc.*;

public class ChannelBuilder {

    public ManagedChannel createChannel(ServerConfig serverConfig) {

        return ManagedChannelBuilder
                .forAddress(serverConfig.getHostName(), serverConfig.getPortNumber())
                .usePlaintext()
                .intercept(interceptor(serverConfig))
                .build();
    }

    private ClientInterceptor interceptor(ServerConfig serverConfig) {
        ClientInterceptor interceptor = new ClientInterceptor() {
            @Override
            public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
                    final io.grpc.MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, final Channel next) {
                return new ClientInterceptors.CheckedForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
                    @Override
                    protected void checkedStart(Listener<RespT> responseListener, Metadata headers)
                            throws StatusException {

                        Metadata.Key<String> key = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
                        headers.put(key,serverConfig.getMetadata().get("Authorization"));
                        delegate().start(responseListener, headers);
                    }
                };
            }
        };

        return interceptor;
    }
}


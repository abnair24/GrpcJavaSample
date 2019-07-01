package com.abn.grpcSample.protogen.mypkg.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.protobuf.Descriptors;

import java.util.concurrent.TimeUnit;

public class ProtoCache {

//    LoadingCache<String, Descriptors.FileDescriptor> fdCache = CacheBuilder
//            .newBuilder()
//            .maximumSize(1000)
//            .expireAfterAccess(30, TimeUnit.MINUTES)
//            .build(new CacheLoader<String, Descriptors.FileDescriptor>() {
//                @Override
//                public Descriptors.FileDescriptor load(String key) throws Exception {
//                    return null;
//                }
//            })
}

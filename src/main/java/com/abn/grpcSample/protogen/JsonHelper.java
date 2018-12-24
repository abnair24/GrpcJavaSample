package com.abn.grpcSample.protogen;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class JsonHelper {

    public static InputStream jsonConvertor(Object object) {
        Gson gsonBuilder = new GsonBuilder().create();
        String jsonString = gsonBuilder.toJson(object);
        System.out.println("delete this "+ jsonString);
        return new ByteArrayInputStream(jsonString.getBytes());
    }
}

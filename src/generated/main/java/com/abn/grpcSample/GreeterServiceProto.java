// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HelloService.proto

package com.abn.grpcSample;

public final class GreeterServiceProto {
  private GreeterServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_Greeting_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_Greeting_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_HelloRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_HelloRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_HelloResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_HelloResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GreetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GreetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GreetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GreetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GreetManyTimesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GreetManyTimesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GreetManyTimesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GreetManyTimesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_LongGreetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_LongGreetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_LongGreetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_LongGreetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GreetEveryoneRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GreetEveryoneRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GreetEveryoneResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GreetEveryoneResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GreetWithDeadlineRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GreetWithDeadlineRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_helloworld_GreetWithDeadlineResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_helloworld_GreetWithDeadlineResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022HelloService.proto\022\nhelloworld\"1\n\010Gree" +
      "ting\022\022\n\nfirst_name\030\001 \001(\t\022\021\n\tlast_name\030\002 " +
      "\001(\t\"\034\n\014HelloRequest\022\014\n\004name\030\001 \001(\t\" \n\rHel" +
      "loResponse\022\017\n\007message\030\001 \001(\t\"6\n\014GreetRequ" +
      "est\022&\n\010greeting\030\001 \001(\0132\024.helloworld.Greet" +
      "ing\"\037\n\rGreetResponse\022\016\n\006result\030\001 \001(\t\"?\n\025" +
      "GreetManyTimesRequest\022&\n\010greeting\030\001 \001(\0132" +
      "\024.helloworld.Greeting\"(\n\026GreetManyTimesR" +
      "esponse\022\016\n\006result\030\001 \001(\t\":\n\020LongGreetRequ" +
      "est\022&\n\010greeting\030\001 \001(\0132\024.helloworld.Greet" +
      "ing\"#\n\021LongGreetResponse\022\016\n\006result\030\001 \001(\t" +
      "\">\n\024GreetEveryoneRequest\022&\n\010greeting\030\001 \001" +
      "(\0132\024.helloworld.Greeting\"\'\n\025GreetEveryon" +
      "eResponse\022\016\n\006result\030\001 \001(\t\"B\n\030GreetWithDe" +
      "adlineRequest\022&\n\010greeting\030\001 \001(\0132\024.hellow" +
      "orld.Greeting\"+\n\031GreetWithDeadlineRespon" +
      "se\022\016\n\006result\030\001 \001(\t2\367\003\n\007Greeter\022A\n\010SayHel" +
      "lo\022\030.helloworld.HelloRequest\032\031.helloworl" +
      "d.HelloResponse\"\000\022>\n\005Greet\022\030.helloworld." +
      "GreetRequest\032\031.helloworld.GreetResponse\"" +
      "\000\022[\n\016GreetManyTimes\022!.helloworld.GreetMa" +
      "nyTimesRequest\032\".helloworld.GreetManyTim" +
      "esResponse\"\0000\001\022L\n\tLongGreet\022\034.helloworld" +
      ".LongGreetRequest\032\035.helloworld.LongGreet" +
      "Response\"\000(\001\022Z\n\rGreetEveryone\022 .hellowor" +
      "ld.GreetEveryoneRequest\032!.helloworld.Gre" +
      "etEveryoneResponse\"\000(\0010\001\022b\n\021GreetWithDea" +
      "dline\022$.helloworld.GreetWithDeadlineRequ" +
      "est\032%.helloworld.GreetWithDeadlineRespon" +
      "se\"\000B+\n\022com.abn.grpcSampleB\023GreeterServi" +
      "ceProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_helloworld_Greeting_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_helloworld_Greeting_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_Greeting_descriptor,
        new java.lang.String[] { "FirstName", "LastName", });
    internal_static_helloworld_HelloRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_helloworld_HelloRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_HelloRequest_descriptor,
        new java.lang.String[] { "Name", });
    internal_static_helloworld_HelloResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_helloworld_HelloResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_HelloResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_helloworld_GreetRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_helloworld_GreetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GreetRequest_descriptor,
        new java.lang.String[] { "Greeting", });
    internal_static_helloworld_GreetResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_helloworld_GreetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GreetResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_helloworld_GreetManyTimesRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_helloworld_GreetManyTimesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GreetManyTimesRequest_descriptor,
        new java.lang.String[] { "Greeting", });
    internal_static_helloworld_GreetManyTimesResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_helloworld_GreetManyTimesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GreetManyTimesResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_helloworld_LongGreetRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_helloworld_LongGreetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_LongGreetRequest_descriptor,
        new java.lang.String[] { "Greeting", });
    internal_static_helloworld_LongGreetResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_helloworld_LongGreetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_LongGreetResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_helloworld_GreetEveryoneRequest_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_helloworld_GreetEveryoneRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GreetEveryoneRequest_descriptor,
        new java.lang.String[] { "Greeting", });
    internal_static_helloworld_GreetEveryoneResponse_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_helloworld_GreetEveryoneResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GreetEveryoneResponse_descriptor,
        new java.lang.String[] { "Result", });
    internal_static_helloworld_GreetWithDeadlineRequest_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_helloworld_GreetWithDeadlineRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GreetWithDeadlineRequest_descriptor,
        new java.lang.String[] { "Greeting", });
    internal_static_helloworld_GreetWithDeadlineResponse_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_helloworld_GreetWithDeadlineResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_helloworld_GreetWithDeadlineResponse_descriptor,
        new java.lang.String[] { "Result", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HelloService.proto

package com.abn.grpcSample;

/**
 * <pre>
 *Bidirectional
 * </pre>
 *
 * Protobuf type {@code helloworld.GreetEveryoneRequest}
 */
public  final class GreetEveryoneRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:helloworld.GreetEveryoneRequest)
    GreetEveryoneRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GreetEveryoneRequest.newBuilder() to construct.
  private GreetEveryoneRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GreetEveryoneRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GreetEveryoneRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.abn.grpcSample.Greeting.Builder subBuilder = null;
            if (greeting_ != null) {
              subBuilder = greeting_.toBuilder();
            }
            greeting_ = input.readMessage(com.abn.grpcSample.Greeting.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(greeting_);
              greeting_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.abn.grpcSample.GreeterServiceProto.internal_static_helloworld_GreetEveryoneRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.abn.grpcSample.GreeterServiceProto.internal_static_helloworld_GreetEveryoneRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.abn.grpcSample.GreetEveryoneRequest.class, com.abn.grpcSample.GreetEveryoneRequest.Builder.class);
  }

  public static final int GREETING_FIELD_NUMBER = 1;
  private com.abn.grpcSample.Greeting greeting_;
  /**
   * <code>.helloworld.Greeting greeting = 1;</code>
   */
  public boolean hasGreeting() {
    return greeting_ != null;
  }
  /**
   * <code>.helloworld.Greeting greeting = 1;</code>
   */
  public com.abn.grpcSample.Greeting getGreeting() {
    return greeting_ == null ? com.abn.grpcSample.Greeting.getDefaultInstance() : greeting_;
  }
  /**
   * <code>.helloworld.Greeting greeting = 1;</code>
   */
  public com.abn.grpcSample.GreetingOrBuilder getGreetingOrBuilder() {
    return getGreeting();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (greeting_ != null) {
      output.writeMessage(1, getGreeting());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (greeting_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getGreeting());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.abn.grpcSample.GreetEveryoneRequest)) {
      return super.equals(obj);
    }
    com.abn.grpcSample.GreetEveryoneRequest other = (com.abn.grpcSample.GreetEveryoneRequest) obj;

    boolean result = true;
    result = result && (hasGreeting() == other.hasGreeting());
    if (hasGreeting()) {
      result = result && getGreeting()
          .equals(other.getGreeting());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasGreeting()) {
      hash = (37 * hash) + GREETING_FIELD_NUMBER;
      hash = (53 * hash) + getGreeting().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.abn.grpcSample.GreetEveryoneRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.abn.grpcSample.GreetEveryoneRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *Bidirectional
   * </pre>
   *
   * Protobuf type {@code helloworld.GreetEveryoneRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:helloworld.GreetEveryoneRequest)
      com.abn.grpcSample.GreetEveryoneRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.abn.grpcSample.GreeterServiceProto.internal_static_helloworld_GreetEveryoneRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.abn.grpcSample.GreeterServiceProto.internal_static_helloworld_GreetEveryoneRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.abn.grpcSample.GreetEveryoneRequest.class, com.abn.grpcSample.GreetEveryoneRequest.Builder.class);
    }

    // Construct using com.abn.grpcSample.GreetEveryoneRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (greetingBuilder_ == null) {
        greeting_ = null;
      } else {
        greeting_ = null;
        greetingBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.abn.grpcSample.GreeterServiceProto.internal_static_helloworld_GreetEveryoneRequest_descriptor;
    }

    @java.lang.Override
    public com.abn.grpcSample.GreetEveryoneRequest getDefaultInstanceForType() {
      return com.abn.grpcSample.GreetEveryoneRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.abn.grpcSample.GreetEveryoneRequest build() {
      com.abn.grpcSample.GreetEveryoneRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.abn.grpcSample.GreetEveryoneRequest buildPartial() {
      com.abn.grpcSample.GreetEveryoneRequest result = new com.abn.grpcSample.GreetEveryoneRequest(this);
      if (greetingBuilder_ == null) {
        result.greeting_ = greeting_;
      } else {
        result.greeting_ = greetingBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.abn.grpcSample.GreetEveryoneRequest) {
        return mergeFrom((com.abn.grpcSample.GreetEveryoneRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.abn.grpcSample.GreetEveryoneRequest other) {
      if (other == com.abn.grpcSample.GreetEveryoneRequest.getDefaultInstance()) return this;
      if (other.hasGreeting()) {
        mergeGreeting(other.getGreeting());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.abn.grpcSample.GreetEveryoneRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.abn.grpcSample.GreetEveryoneRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.abn.grpcSample.Greeting greeting_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.abn.grpcSample.Greeting, com.abn.grpcSample.Greeting.Builder, com.abn.grpcSample.GreetingOrBuilder> greetingBuilder_;
    /**
     * <code>.helloworld.Greeting greeting = 1;</code>
     */
    public boolean hasGreeting() {
      return greetingBuilder_ != null || greeting_ != null;
    }
    /**
     * <code>.helloworld.Greeting greeting = 1;</code>
     */
    public com.abn.grpcSample.Greeting getGreeting() {
      if (greetingBuilder_ == null) {
        return greeting_ == null ? com.abn.grpcSample.Greeting.getDefaultInstance() : greeting_;
      } else {
        return greetingBuilder_.getMessage();
      }
    }
    /**
     * <code>.helloworld.Greeting greeting = 1;</code>
     */
    public Builder setGreeting(com.abn.grpcSample.Greeting value) {
      if (greetingBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        greeting_ = value;
        onChanged();
      } else {
        greetingBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.helloworld.Greeting greeting = 1;</code>
     */
    public Builder setGreeting(
        com.abn.grpcSample.Greeting.Builder builderForValue) {
      if (greetingBuilder_ == null) {
        greeting_ = builderForValue.build();
        onChanged();
      } else {
        greetingBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.helloworld.Greeting greeting = 1;</code>
     */
    public Builder mergeGreeting(com.abn.grpcSample.Greeting value) {
      if (greetingBuilder_ == null) {
        if (greeting_ != null) {
          greeting_ =
            com.abn.grpcSample.Greeting.newBuilder(greeting_).mergeFrom(value).buildPartial();
        } else {
          greeting_ = value;
        }
        onChanged();
      } else {
        greetingBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.helloworld.Greeting greeting = 1;</code>
     */
    public Builder clearGreeting() {
      if (greetingBuilder_ == null) {
        greeting_ = null;
        onChanged();
      } else {
        greeting_ = null;
        greetingBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.helloworld.Greeting greeting = 1;</code>
     */
    public com.abn.grpcSample.Greeting.Builder getGreetingBuilder() {
      
      onChanged();
      return getGreetingFieldBuilder().getBuilder();
    }
    /**
     * <code>.helloworld.Greeting greeting = 1;</code>
     */
    public com.abn.grpcSample.GreetingOrBuilder getGreetingOrBuilder() {
      if (greetingBuilder_ != null) {
        return greetingBuilder_.getMessageOrBuilder();
      } else {
        return greeting_ == null ?
            com.abn.grpcSample.Greeting.getDefaultInstance() : greeting_;
      }
    }
    /**
     * <code>.helloworld.Greeting greeting = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.abn.grpcSample.Greeting, com.abn.grpcSample.Greeting.Builder, com.abn.grpcSample.GreetingOrBuilder> 
        getGreetingFieldBuilder() {
      if (greetingBuilder_ == null) {
        greetingBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.abn.grpcSample.Greeting, com.abn.grpcSample.Greeting.Builder, com.abn.grpcSample.GreetingOrBuilder>(
                getGreeting(),
                getParentForChildren(),
                isClean());
        greeting_ = null;
      }
      return greetingBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:helloworld.GreetEveryoneRequest)
  }

  // @@protoc_insertion_point(class_scope:helloworld.GreetEveryoneRequest)
  private static final com.abn.grpcSample.GreetEveryoneRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.abn.grpcSample.GreetEveryoneRequest();
  }

  public static com.abn.grpcSample.GreetEveryoneRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GreetEveryoneRequest>
      PARSER = new com.google.protobuf.AbstractParser<GreetEveryoneRequest>() {
    @java.lang.Override
    public GreetEveryoneRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GreetEveryoneRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GreetEveryoneRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GreetEveryoneRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.abn.grpcSample.GreetEveryoneRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


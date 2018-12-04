package com.abn.grpcSample;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: HelloService.proto")
public final class GreeterGrpc {

  private GreeterGrpc() {}

  public static final String SERVICE_NAME = "helloworld.Greeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.abn.grpcSample.HelloRequest,
      com.abn.grpcSample.HelloResponse> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = com.abn.grpcSample.HelloRequest.class,
      responseType = com.abn.grpcSample.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.abn.grpcSample.HelloRequest,
      com.abn.grpcSample.HelloResponse> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.abn.grpcSample.HelloRequest, com.abn.grpcSample.HelloResponse> getSayHelloMethod;
    if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
          GreeterGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<com.abn.grpcSample.HelloRequest, com.abn.grpcSample.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.HelloResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.abn.grpcSample.GreetRequest,
      com.abn.grpcSample.GreetResponse> getGreetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Greet",
      requestType = com.abn.grpcSample.GreetRequest.class,
      responseType = com.abn.grpcSample.GreetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.abn.grpcSample.GreetRequest,
      com.abn.grpcSample.GreetResponse> getGreetMethod() {
    io.grpc.MethodDescriptor<com.abn.grpcSample.GreetRequest, com.abn.grpcSample.GreetResponse> getGreetMethod;
    if ((getGreetMethod = GreeterGrpc.getGreetMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGreetMethod = GreeterGrpc.getGreetMethod) == null) {
          GreeterGrpc.getGreetMethod = getGreetMethod = 
              io.grpc.MethodDescriptor.<com.abn.grpcSample.GreetRequest, com.abn.grpcSample.GreetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "Greet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.GreetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.GreetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("Greet"))
                  .build();
          }
        }
     }
     return getGreetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.abn.grpcSample.GreetManyTimesRequest,
      com.abn.grpcSample.GreetManyTimesResponse> getGreetManyTimesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GreetManyTimes",
      requestType = com.abn.grpcSample.GreetManyTimesRequest.class,
      responseType = com.abn.grpcSample.GreetManyTimesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.abn.grpcSample.GreetManyTimesRequest,
      com.abn.grpcSample.GreetManyTimesResponse> getGreetManyTimesMethod() {
    io.grpc.MethodDescriptor<com.abn.grpcSample.GreetManyTimesRequest, com.abn.grpcSample.GreetManyTimesResponse> getGreetManyTimesMethod;
    if ((getGreetManyTimesMethod = GreeterGrpc.getGreetManyTimesMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGreetManyTimesMethod = GreeterGrpc.getGreetManyTimesMethod) == null) {
          GreeterGrpc.getGreetManyTimesMethod = getGreetManyTimesMethod = 
              io.grpc.MethodDescriptor.<com.abn.grpcSample.GreetManyTimesRequest, com.abn.grpcSample.GreetManyTimesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "GreetManyTimes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.GreetManyTimesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.GreetManyTimesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GreetManyTimes"))
                  .build();
          }
        }
     }
     return getGreetManyTimesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.abn.grpcSample.LongGreetRequest,
      com.abn.grpcSample.LongGreetResponse> getLongGreetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LongGreet",
      requestType = com.abn.grpcSample.LongGreetRequest.class,
      responseType = com.abn.grpcSample.LongGreetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.abn.grpcSample.LongGreetRequest,
      com.abn.grpcSample.LongGreetResponse> getLongGreetMethod() {
    io.grpc.MethodDescriptor<com.abn.grpcSample.LongGreetRequest, com.abn.grpcSample.LongGreetResponse> getLongGreetMethod;
    if ((getLongGreetMethod = GreeterGrpc.getLongGreetMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getLongGreetMethod = GreeterGrpc.getLongGreetMethod) == null) {
          GreeterGrpc.getLongGreetMethod = getLongGreetMethod = 
              io.grpc.MethodDescriptor.<com.abn.grpcSample.LongGreetRequest, com.abn.grpcSample.LongGreetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "LongGreet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.LongGreetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.LongGreetResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("LongGreet"))
                  .build();
          }
        }
     }
     return getLongGreetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.abn.grpcSample.GreetEveryoneRequest,
      com.abn.grpcSample.GreetEveryoneResponse> getGreetEveryoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GreetEveryone",
      requestType = com.abn.grpcSample.GreetEveryoneRequest.class,
      responseType = com.abn.grpcSample.GreetEveryoneResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.abn.grpcSample.GreetEveryoneRequest,
      com.abn.grpcSample.GreetEveryoneResponse> getGreetEveryoneMethod() {
    io.grpc.MethodDescriptor<com.abn.grpcSample.GreetEveryoneRequest, com.abn.grpcSample.GreetEveryoneResponse> getGreetEveryoneMethod;
    if ((getGreetEveryoneMethod = GreeterGrpc.getGreetEveryoneMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGreetEveryoneMethod = GreeterGrpc.getGreetEveryoneMethod) == null) {
          GreeterGrpc.getGreetEveryoneMethod = getGreetEveryoneMethod = 
              io.grpc.MethodDescriptor.<com.abn.grpcSample.GreetEveryoneRequest, com.abn.grpcSample.GreetEveryoneResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "GreetEveryone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.GreetEveryoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.GreetEveryoneResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GreetEveryone"))
                  .build();
          }
        }
     }
     return getGreetEveryoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.abn.grpcSample.GreetWithDeadlineRequest,
      com.abn.grpcSample.GreetWithDeadlineResponse> getGreetWithDeadlineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GreetWithDeadline",
      requestType = com.abn.grpcSample.GreetWithDeadlineRequest.class,
      responseType = com.abn.grpcSample.GreetWithDeadlineResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.abn.grpcSample.GreetWithDeadlineRequest,
      com.abn.grpcSample.GreetWithDeadlineResponse> getGreetWithDeadlineMethod() {
    io.grpc.MethodDescriptor<com.abn.grpcSample.GreetWithDeadlineRequest, com.abn.grpcSample.GreetWithDeadlineResponse> getGreetWithDeadlineMethod;
    if ((getGreetWithDeadlineMethod = GreeterGrpc.getGreetWithDeadlineMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getGreetWithDeadlineMethod = GreeterGrpc.getGreetWithDeadlineMethod) == null) {
          GreeterGrpc.getGreetWithDeadlineMethod = getGreetWithDeadlineMethod = 
              io.grpc.MethodDescriptor.<com.abn.grpcSample.GreetWithDeadlineRequest, com.abn.grpcSample.GreetWithDeadlineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Greeter", "GreetWithDeadline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.GreetWithDeadlineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.abn.grpcSample.GreetWithDeadlineResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("GreetWithDeadline"))
                  .build();
          }
        }
     }
     return getGreetWithDeadlineMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterStub newStub(io.grpc.Channel channel) {
    return new GreeterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GreeterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GreeterFutureStub(channel);
  }

  /**
   */
  public static abstract class GreeterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting - Unary
     * </pre>
     */
    public void sayHello(com.abn.grpcSample.HelloRequest request,
        io.grpc.stub.StreamObserver<com.abn.grpcSample.HelloResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void greet(com.abn.grpcSample.GreetRequest request,
        io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGreetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void greetManyTimes(com.abn.grpcSample.GreetManyTimesRequest request,
        io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetManyTimesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGreetManyTimesMethod(), responseObserver);
    }

    /**
     * <pre>
     * GreeterClient streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.abn.grpcSample.LongGreetRequest> longGreet(
        io.grpc.stub.StreamObserver<com.abn.grpcSample.LongGreetResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getLongGreetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetEveryoneRequest> greetEveryone(
        io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetEveryoneResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGreetEveryoneMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC with deadlines
     * this RPC will complete in no less than 300ms
     * </pre>
     */
    public void greetWithDeadline(com.abn.grpcSample.GreetWithDeadlineRequest request,
        io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetWithDeadlineResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGreetWithDeadlineMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.abn.grpcSample.HelloRequest,
                com.abn.grpcSample.HelloResponse>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getGreetMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.abn.grpcSample.GreetRequest,
                com.abn.grpcSample.GreetResponse>(
                  this, METHODID_GREET)))
          .addMethod(
            getGreetManyTimesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.abn.grpcSample.GreetManyTimesRequest,
                com.abn.grpcSample.GreetManyTimesResponse>(
                  this, METHODID_GREET_MANY_TIMES)))
          .addMethod(
            getLongGreetMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.abn.grpcSample.LongGreetRequest,
                com.abn.grpcSample.LongGreetResponse>(
                  this, METHODID_LONG_GREET)))
          .addMethod(
            getGreetEveryoneMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.abn.grpcSample.GreetEveryoneRequest,
                com.abn.grpcSample.GreetEveryoneResponse>(
                  this, METHODID_GREET_EVERYONE)))
          .addMethod(
            getGreetWithDeadlineMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.abn.grpcSample.GreetWithDeadlineRequest,
                com.abn.grpcSample.GreetWithDeadlineResponse>(
                  this, METHODID_GREET_WITH_DEADLINE)))
          .build();
    }
  }

  /**
   */
  public static final class GreeterStub extends io.grpc.stub.AbstractStub<GreeterStub> {
    private GreeterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting - Unary
     * </pre>
     */
    public void sayHello(com.abn.grpcSample.HelloRequest request,
        io.grpc.stub.StreamObserver<com.abn.grpcSample.HelloResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void greet(com.abn.grpcSample.GreetRequest request,
        io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGreetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public void greetManyTimes(com.abn.grpcSample.GreetManyTimesRequest request,
        io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetManyTimesResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGreetManyTimesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GreeterClient streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.abn.grpcSample.LongGreetRequest> longGreet(
        io.grpc.stub.StreamObserver<com.abn.grpcSample.LongGreetResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLongGreetMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetEveryoneRequest> greetEveryone(
        io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetEveryoneResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGreetEveryoneMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * RPC with deadlines
     * this RPC will complete in no less than 300ms
     * </pre>
     */
    public void greetWithDeadline(com.abn.grpcSample.GreetWithDeadlineRequest request,
        io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetWithDeadlineResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGreetWithDeadlineMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GreeterBlockingStub extends io.grpc.stub.AbstractStub<GreeterBlockingStub> {
    private GreeterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting - Unary
     * </pre>
     */
    public com.abn.grpcSample.HelloResponse sayHello(com.abn.grpcSample.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.abn.grpcSample.GreetResponse greet(com.abn.grpcSample.GreetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGreetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server Streaming
     * </pre>
     */
    public java.util.Iterator<com.abn.grpcSample.GreetManyTimesResponse> greetManyTimes(
        com.abn.grpcSample.GreetManyTimesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGreetManyTimesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC with deadlines
     * this RPC will complete in no less than 300ms
     * </pre>
     */
    public com.abn.grpcSample.GreetWithDeadlineResponse greetWithDeadline(com.abn.grpcSample.GreetWithDeadlineRequest request) {
      return blockingUnaryCall(
          getChannel(), getGreetWithDeadlineMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GreeterFutureStub extends io.grpc.stub.AbstractStub<GreeterFutureStub> {
    private GreeterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting - Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.abn.grpcSample.HelloResponse> sayHello(
        com.abn.grpcSample.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.abn.grpcSample.GreetResponse> greet(
        com.abn.grpcSample.GreetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGreetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RPC with deadlines
     * this RPC will complete in no less than 300ms
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.abn.grpcSample.GreetWithDeadlineResponse> greetWithDeadline(
        com.abn.grpcSample.GreetWithDeadlineRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGreetWithDeadlineMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_GREET = 1;
  private static final int METHODID_GREET_MANY_TIMES = 2;
  private static final int METHODID_GREET_WITH_DEADLINE = 3;
  private static final int METHODID_LONG_GREET = 4;
  private static final int METHODID_GREET_EVERYONE = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreeterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreeterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.abn.grpcSample.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.abn.grpcSample.HelloResponse>) responseObserver);
          break;
        case METHODID_GREET:
          serviceImpl.greet((com.abn.grpcSample.GreetRequest) request,
              (io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetResponse>) responseObserver);
          break;
        case METHODID_GREET_MANY_TIMES:
          serviceImpl.greetManyTimes((com.abn.grpcSample.GreetManyTimesRequest) request,
              (io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetManyTimesResponse>) responseObserver);
          break;
        case METHODID_GREET_WITH_DEADLINE:
          serviceImpl.greetWithDeadline((com.abn.grpcSample.GreetWithDeadlineRequest) request,
              (io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetWithDeadlineResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LONG_GREET:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.longGreet(
              (io.grpc.stub.StreamObserver<com.abn.grpcSample.LongGreetResponse>) responseObserver);
        case METHODID_GREET_EVERYONE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.greetEveryone(
              (io.grpc.stub.StreamObserver<com.abn.grpcSample.GreetEveryoneResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.abn.grpcSample.GreeterServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter");
    }
  }

  private static final class GreeterFileDescriptorSupplier
      extends GreeterBaseDescriptorSupplier {
    GreeterFileDescriptorSupplier() {}
  }

  private static final class GreeterMethodDescriptorSupplier
      extends GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreeterMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getGreetMethod())
              .addMethod(getGreetManyTimesMethod())
              .addMethod(getLongGreetMethod())
              .addMethod(getGreetEveryoneMethod())
              .addMethod(getGreetWithDeadlineMethod())
              .build();
        }
      }
    }
    return result;
  }
}

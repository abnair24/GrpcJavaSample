package helloworld.test;

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
    comments = "Source: TestService.proto")
public final class TestServiceGrpc {

  private TestServiceGrpc() {}

  public static final String SERVICE_NAME = "helloworld.test.TestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest,
      helloworld.test.TestProto.TestResponse> getTestMethodMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestMethod",
      requestType = helloworld.test.TestProto.TestRequest.class,
      responseType = helloworld.test.TestProto.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest,
      helloworld.test.TestProto.TestResponse> getTestMethodMethod() {
    io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest, helloworld.test.TestProto.TestResponse> getTestMethodMethod;
    if ((getTestMethodMethod = TestServiceGrpc.getTestMethodMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestMethodMethod = TestServiceGrpc.getTestMethodMethod) == null) {
          TestServiceGrpc.getTestMethodMethod = getTestMethodMethod = 
              io.grpc.MethodDescriptor.<helloworld.test.TestProto.TestRequest, helloworld.test.TestProto.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.test.TestService", "TestMethod"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  helloworld.test.TestProto.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  helloworld.test.TestProto.TestResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("TestMethod"))
                  .build();
          }
        }
     }
     return getTestMethodMethod;
  }

  private static volatile io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest,
      helloworld.test.TestProto.TestResponse> getTestMethodStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestMethodStream",
      requestType = helloworld.test.TestProto.TestRequest.class,
      responseType = helloworld.test.TestProto.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest,
      helloworld.test.TestProto.TestResponse> getTestMethodStreamMethod() {
    io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest, helloworld.test.TestProto.TestResponse> getTestMethodStreamMethod;
    if ((getTestMethodStreamMethod = TestServiceGrpc.getTestMethodStreamMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestMethodStreamMethod = TestServiceGrpc.getTestMethodStreamMethod) == null) {
          TestServiceGrpc.getTestMethodStreamMethod = getTestMethodStreamMethod = 
              io.grpc.MethodDescriptor.<helloworld.test.TestProto.TestRequest, helloworld.test.TestProto.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.test.TestService", "TestMethodStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  helloworld.test.TestProto.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  helloworld.test.TestProto.TestResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("TestMethodStream"))
                  .build();
          }
        }
     }
     return getTestMethodStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest,
      helloworld.test.TestProto.TestResponse> getTestMethodClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestMethodClientStream",
      requestType = helloworld.test.TestProto.TestRequest.class,
      responseType = helloworld.test.TestProto.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest,
      helloworld.test.TestProto.TestResponse> getTestMethodClientStreamMethod() {
    io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest, helloworld.test.TestProto.TestResponse> getTestMethodClientStreamMethod;
    if ((getTestMethodClientStreamMethod = TestServiceGrpc.getTestMethodClientStreamMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestMethodClientStreamMethod = TestServiceGrpc.getTestMethodClientStreamMethod) == null) {
          TestServiceGrpc.getTestMethodClientStreamMethod = getTestMethodClientStreamMethod = 
              io.grpc.MethodDescriptor.<helloworld.test.TestProto.TestRequest, helloworld.test.TestProto.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.test.TestService", "TestMethodClientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  helloworld.test.TestProto.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  helloworld.test.TestProto.TestResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("TestMethodClientStream"))
                  .build();
          }
        }
     }
     return getTestMethodClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest,
      helloworld.test.TestProto.TestResponse> getTestMethodBidiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestMethodBidi",
      requestType = helloworld.test.TestProto.TestRequest.class,
      responseType = helloworld.test.TestProto.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest,
      helloworld.test.TestProto.TestResponse> getTestMethodBidiMethod() {
    io.grpc.MethodDescriptor<helloworld.test.TestProto.TestRequest, helloworld.test.TestProto.TestResponse> getTestMethodBidiMethod;
    if ((getTestMethodBidiMethod = TestServiceGrpc.getTestMethodBidiMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestMethodBidiMethod = TestServiceGrpc.getTestMethodBidiMethod) == null) {
          TestServiceGrpc.getTestMethodBidiMethod = getTestMethodBidiMethod = 
              io.grpc.MethodDescriptor.<helloworld.test.TestProto.TestRequest, helloworld.test.TestProto.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.test.TestService", "TestMethodBidi"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  helloworld.test.TestProto.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  helloworld.test.TestProto.TestResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("TestMethodBidi"))
                  .build();
          }
        }
     }
     return getTestMethodBidiMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestServiceStub newStub(io.grpc.Channel channel) {
    return new TestServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TestServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TestServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TestServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void testMethod(helloworld.test.TestProto.TestRequest request,
        io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTestMethodMethod(), responseObserver);
    }

    /**
     */
    public void testMethodStream(helloworld.test.TestProto.TestRequest request,
        io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTestMethodStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestRequest> testMethodClientStream(
        io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTestMethodClientStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestRequest> testMethodBidi(
        io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTestMethodBidiMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTestMethodMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                helloworld.test.TestProto.TestRequest,
                helloworld.test.TestProto.TestResponse>(
                  this, METHODID_TEST_METHOD)))
          .addMethod(
            getTestMethodStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                helloworld.test.TestProto.TestRequest,
                helloworld.test.TestProto.TestResponse>(
                  this, METHODID_TEST_METHOD_STREAM)))
          .addMethod(
            getTestMethodClientStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                helloworld.test.TestProto.TestRequest,
                helloworld.test.TestProto.TestResponse>(
                  this, METHODID_TEST_METHOD_CLIENT_STREAM)))
          .addMethod(
            getTestMethodBidiMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                helloworld.test.TestProto.TestRequest,
                helloworld.test.TestProto.TestResponse>(
                  this, METHODID_TEST_METHOD_BIDI)))
          .build();
    }
  }

  /**
   */
  public static final class TestServiceStub extends io.grpc.stub.AbstractStub<TestServiceStub> {
    private TestServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestServiceStub(channel, callOptions);
    }

    /**
     */
    public void testMethod(helloworld.test.TestProto.TestRequest request,
        io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestMethodMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void testMethodStream(helloworld.test.TestProto.TestRequest request,
        io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getTestMethodStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestRequest> testMethodClientStream(
        io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getTestMethodClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestRequest> testMethodBidi(
        io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTestMethodBidiMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TestServiceBlockingStub extends io.grpc.stub.AbstractStub<TestServiceBlockingStub> {
    private TestServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public helloworld.test.TestProto.TestResponse testMethod(helloworld.test.TestProto.TestRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestMethodMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<helloworld.test.TestProto.TestResponse> testMethodStream(
        helloworld.test.TestProto.TestRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getTestMethodStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TestServiceFutureStub extends io.grpc.stub.AbstractStub<TestServiceFutureStub> {
    private TestServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<helloworld.test.TestProto.TestResponse> testMethod(
        helloworld.test.TestProto.TestRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestMethodMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TEST_METHOD = 0;
  private static final int METHODID_TEST_METHOD_STREAM = 1;
  private static final int METHODID_TEST_METHOD_CLIENT_STREAM = 2;
  private static final int METHODID_TEST_METHOD_BIDI = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEST_METHOD:
          serviceImpl.testMethod((helloworld.test.TestProto.TestRequest) request,
              (io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse>) responseObserver);
          break;
        case METHODID_TEST_METHOD_STREAM:
          serviceImpl.testMethodStream((helloworld.test.TestProto.TestRequest) request,
              (io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse>) responseObserver);
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
        case METHODID_TEST_METHOD_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.testMethodClientStream(
              (io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse>) responseObserver);
        case METHODID_TEST_METHOD_BIDI:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.testMethodBidi(
              (io.grpc.stub.StreamObserver<helloworld.test.TestProto.TestResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return helloworld.test.TestProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestService");
    }
  }

  private static final class TestServiceFileDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier {
    TestServiceFileDescriptorSupplier() {}
  }

  private static final class TestServiceMethodDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestServiceFileDescriptorSupplier())
              .addMethod(getTestMethodMethod())
              .addMethod(getTestMethodStreamMethod())
              .addMethod(getTestMethodClientStreamMethod())
              .addMethod(getTestMethodBidiMethod())
              .build();
        }
      }
    }
    return result;
  }
}

package com.hooxi.collector.grpc.lib;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The hooxi collector service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: hooxi-eventpublisher.proto")
public final class HooxiCollectorGrpcServiceGrpc {

  private HooxiCollectorGrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "com.hooxi.collector.grpc.HooxiCollectorGrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.hooxi.collector.grpc.lib.HooxiEventRequest,
      com.hooxi.collector.grpc.lib.HooxiEventReply> getSendEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendEvent",
      requestType = com.hooxi.collector.grpc.lib.HooxiEventRequest.class,
      responseType = com.hooxi.collector.grpc.lib.HooxiEventReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.hooxi.collector.grpc.lib.HooxiEventRequest,
      com.hooxi.collector.grpc.lib.HooxiEventReply> getSendEventMethod() {
    io.grpc.MethodDescriptor<com.hooxi.collector.grpc.lib.HooxiEventRequest, com.hooxi.collector.grpc.lib.HooxiEventReply> getSendEventMethod;
    if ((getSendEventMethod = HooxiCollectorGrpcServiceGrpc.getSendEventMethod) == null) {
      synchronized (HooxiCollectorGrpcServiceGrpc.class) {
        if ((getSendEventMethod = HooxiCollectorGrpcServiceGrpc.getSendEventMethod) == null) {
          HooxiCollectorGrpcServiceGrpc.getSendEventMethod = getSendEventMethod =
              io.grpc.MethodDescriptor.<com.hooxi.collector.grpc.lib.HooxiEventRequest, com.hooxi.collector.grpc.lib.HooxiEventReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hooxi.collector.grpc.lib.HooxiEventRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.hooxi.collector.grpc.lib.HooxiEventReply.getDefaultInstance()))
              .setSchemaDescriptor(new HooxiCollectorGrpcServiceMethodDescriptorSupplier("sendEvent"))
              .build();
        }
      }
    }
    return getSendEventMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HooxiCollectorGrpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HooxiCollectorGrpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HooxiCollectorGrpcServiceStub>() {
        @java.lang.Override
        public HooxiCollectorGrpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HooxiCollectorGrpcServiceStub(channel, callOptions);
        }
      };
    return HooxiCollectorGrpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HooxiCollectorGrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HooxiCollectorGrpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HooxiCollectorGrpcServiceBlockingStub>() {
        @java.lang.Override
        public HooxiCollectorGrpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HooxiCollectorGrpcServiceBlockingStub(channel, callOptions);
        }
      };
    return HooxiCollectorGrpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HooxiCollectorGrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HooxiCollectorGrpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HooxiCollectorGrpcServiceFutureStub>() {
        @java.lang.Override
        public HooxiCollectorGrpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HooxiCollectorGrpcServiceFutureStub(channel, callOptions);
        }
      };
    return HooxiCollectorGrpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The hooxi collector service definition.
   * </pre>
   */
  public static abstract class HooxiCollectorGrpcServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a event
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.hooxi.collector.grpc.lib.HooxiEventRequest> sendEvent(
        io.grpc.stub.StreamObserver<com.hooxi.collector.grpc.lib.HooxiEventReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendEventMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendEventMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.hooxi.collector.grpc.lib.HooxiEventRequest,
                com.hooxi.collector.grpc.lib.HooxiEventReply>(
                  this, METHODID_SEND_EVENT)))
          .build();
    }
  }

  /**
   * <pre>
   * The hooxi collector service definition.
   * </pre>
   */
  public static final class HooxiCollectorGrpcServiceStub extends io.grpc.stub.AbstractAsyncStub<HooxiCollectorGrpcServiceStub> {
    private HooxiCollectorGrpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HooxiCollectorGrpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HooxiCollectorGrpcServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a event
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.hooxi.collector.grpc.lib.HooxiEventRequest> sendEvent(
        io.grpc.stub.StreamObserver<com.hooxi.collector.grpc.lib.HooxiEventReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getSendEventMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * The hooxi collector service definition.
   * </pre>
   */
  public static final class HooxiCollectorGrpcServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HooxiCollectorGrpcServiceBlockingStub> {
    private HooxiCollectorGrpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HooxiCollectorGrpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HooxiCollectorGrpcServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * The hooxi collector service definition.
   * </pre>
   */
  public static final class HooxiCollectorGrpcServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HooxiCollectorGrpcServiceFutureStub> {
    private HooxiCollectorGrpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HooxiCollectorGrpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HooxiCollectorGrpcServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_EVENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HooxiCollectorGrpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HooxiCollectorGrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_EVENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendEvent(
              (io.grpc.stub.StreamObserver<com.hooxi.collector.grpc.lib.HooxiEventReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HooxiCollectorGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HooxiCollectorGrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.hooxi.collector.grpc.lib.HooxiCollectorGrpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HooxiCollectorGrpcService");
    }
  }

  private static final class HooxiCollectorGrpcServiceFileDescriptorSupplier
      extends HooxiCollectorGrpcServiceBaseDescriptorSupplier {
    HooxiCollectorGrpcServiceFileDescriptorSupplier() {}
  }

  private static final class HooxiCollectorGrpcServiceMethodDescriptorSupplier
      extends HooxiCollectorGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HooxiCollectorGrpcServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HooxiCollectorGrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HooxiCollectorGrpcServiceFileDescriptorSupplier())
              .addMethod(getSendEventMethod())
              .build();
        }
      }
    }
    return result;
  }
}

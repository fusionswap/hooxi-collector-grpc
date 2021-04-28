package com.hooxi.client.service;

import com.hooxi.collector.grpc.lib.HooxiCollectorGrpcServiceGrpc;
import com.hooxi.collector.grpc.lib.HooxiEventReply;
import com.hooxi.collector.grpc.lib.HooxiEventRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class HooxiTestGrpcClientServiceImpl implements {
    private static final Logger logger = LoggerFactory.getLogger(HooxiTestGrpcClientServiceImpl.class);

    @GrpcClient("hooxi-grpc-server")
    private HooxiCollectorGrpcServiceGrpc.HooxiCollectorGrpcServiceStub hooxiCollectorGrpcStub;

    StreamObserver<HooxiEventRequest> requestObserver;

    @PostConstruct
    public void postConstruct() {
        logger.info("testing grpc collector ");
        requestObserver =
                hooxiCollectorGrpcStub.sendEvent(new StreamObserver<HooxiEventReply>() {
                    @Override
                    public void onNext(HooxiEventReply msg) {
                        logger.info("Got message "  + msg);
                    }

                    @Override
                    public void onError(Throwable t) {
                        logger.error("error sending message", t);
                    }

                    @Override
                    public void onCompleted() {
                        logger.info("Finished sending messages");
                    }
                });
    }

    @Scheduled()
    public void generateTestMessages() {


        try {
            Stream.generate(new Random()::nextInt).forEach(i ->  {
                HooxiEventRequest hr = HooxiEventRequest.newBuilder().setEventId("TestEvent-"+i).setPayload("sending event " + i).setEventMetadata(
                        HooxiEventRequest.EventMetadata.newBuilder().setEventSource("http://localhost:9090").setEventType("TestEventType1").
                                setEventURI("http://localhost:9090/mytestapp0").setTenant("MyTenant1").setTimestamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)).build()
                ).build();
                requestObserver.onNext(hr);
            });


        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver.onError(e);
            throw e;
        }
        // Mark the end of requests
        requestObserver.onCompleted();

    }
}

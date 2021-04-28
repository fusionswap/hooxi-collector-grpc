package com.hooxi.collector.grpc.service;

import com.hooxi.collector.grpc.event.HooxiEvent;
import com.hooxi.collector.grpc.event.HooxiEventMetada;
import com.hooxi.collector.grpc.lib.HooxiCollectorGrpcServiceGrpc;
import com.hooxi.collector.grpc.lib.HooxiEventReply;
import com.hooxi.collector.grpc.lib.HooxiEventRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.GenericEventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.time.OffsetDateTime;

@GrpcService
public class HooxiCollectorGrpcServiceImpl extends HooxiCollectorGrpcServiceGrpc.HooxiCollectorGrpcServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(HooxiCollectorGrpcServiceImpl.class);

    private final EventBus eventBus;

    @Autowired
    public HooxiCollectorGrpcServiceImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public StreamObserver<HooxiEventRequest> sendEvent(StreamObserver<HooxiEventReply> responseObserver) {
        return new StreamObserver<HooxiEventRequest>() {
            @Override
            public void onNext(HooxiEventRequest request) {
                HooxiEventRequest.EventMetadata heReqMeta = request.getEventMetadata();
                OffsetDateTime.parse(heReqMeta.getTimestamp());
                HooxiEventMetada heMeta = HooxiEventMetada.HooxiEventMetadaBuilder.aHooxiEventMetada().withTenant(heReqMeta.getTenant())
                .withEventSource(URI.create(heReqMeta.getEventSource())).withEventType(heReqMeta.getEventType()).build();
                HooxiEvent he = HooxiEvent.HooxiEventBuilder.aHooxiEvent().withEventId(request.getEventId()).withMetadata(heMeta).withPayload(request.getPayload()).build();

                EventMessage em = GenericEventMessage.asEventMessage(he);
                eventBus.publish(em);
                HooxiEventReply reply = HooxiEventReply.newBuilder().setHooxiEventId(em.getIdentifier()).build();
                responseObserver.onNext(reply);
            }

            @Override
            public void onError(Throwable t) {
                logger.error("Error during processing hoox event requests", t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}

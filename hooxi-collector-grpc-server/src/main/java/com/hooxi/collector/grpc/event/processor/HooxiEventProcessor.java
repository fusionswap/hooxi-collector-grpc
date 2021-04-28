package com.hooxi.collector.grpc.event.processor;

import com.hooxi.collector.grpc.event.HooxiEvent;
import com.hooxi.relay.router.HooxiEventRouter;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HooxiEventProcessor {

    private static final Logger logger = LoggerFactory.getLogger(HooxiEventProcessor.class);

    private HooxiEventRouter hooxiEventRouter;

    @Autowired
    public HooxiEventProcessor(HooxiEventRouter hooxiEventRouter) {
        this.hooxiEventRouter = hooxiEventRouter;
    }


    @EventHandler
    public void handle(EventMessage<HooxiEvent> eventMessage) throws IOException {
        HooxiEvent he = eventMessage.getPayload();
        logger.debug("handling message " + he);
        logger.debug("id:"  + eventMessage.getIdentifier() + "  timestamp:" + eventMessage.getTimestamp() + " payload type:" + eventMessage.getPayloadType() + " " + eventMessage.toString());
        try {
            hooxiEventRouter.routeEvent(he);
        } catch (IOException e) {
            logger.error("failed to route event", e);
            throw e;
        }

    }
}

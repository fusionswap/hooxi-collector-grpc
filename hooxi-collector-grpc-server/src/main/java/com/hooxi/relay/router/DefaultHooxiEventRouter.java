package com.hooxi.relay.router;

import com.hooxi.collector.grpc.event.HooxiEvent;
import com.hooxi.relay.config.ConfigService;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class DefaultHooxiEventRouter implements HooxiEventRouter {

    private ConfigService configService;

    @Autowired
    public DefaultHooxiEventRouter(ConfigService configService) {
        this.configService = configService;
    }

    @Override
    public void routeEvent(HooxiEvent he) throws IOException {
        CloudEvent ce = CloudEventBuilder.v1().withId(he.getEventId())
                .withData(he.getPayload().getBytes(StandardCharsets.UTF_8))
                .withType(he.getMetadata().getEventType())
                .withTime(he.getMetadata().getTimestamp())
                .withSource(he.getMetadata().getEventSource()).build();
        configService.deriveEventPublisher(he).publish(ce);
    }
}

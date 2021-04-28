package com.hooxi.relay.router;

import com.hooxi.collector.grpc.event.HooxiEvent;
import com.hooxi.collector.grpc.event.HooxiEventMetada;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;

import java.io.IOException;

public interface HooxiEventRouter {
    void routeEvent(HooxiEvent he) throws IOException;
}

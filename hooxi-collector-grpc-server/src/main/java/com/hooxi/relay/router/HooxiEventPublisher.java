package com.hooxi.relay.router;

import io.cloudevents.CloudEvent;

public interface HooxiEventPublisher {
    void publish(CloudEvent he);
}

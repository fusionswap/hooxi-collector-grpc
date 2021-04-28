package com.hooxi.collector.grpc.event;

import java.net.URI;
import java.time.OffsetDateTime;

public class HooxiEventMetada {
    private String tenant;
    private String eventType;
    private URI eventSource;
    private OffsetDateTime timestamp;

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public URI getEventSource() {
        return eventSource;
    }

    public void setEventSource(URI eventSource) {
        this.eventSource = eventSource;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "HooxiEventMetada{" +
                "tenant='" + tenant + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventSource=" + eventSource +
                ", timestamp=" + timestamp +
                '}';
    }

    public static final class HooxiEventMetadaBuilder {
        private String tenant;
        private String eventType;
        private URI eventSource;
        private OffsetDateTime timestamp;

        private HooxiEventMetadaBuilder() {
        }

        public static HooxiEventMetadaBuilder aHooxiEventMetada() {
            return new HooxiEventMetadaBuilder();
        }

        public HooxiEventMetadaBuilder withTenant(String tenant) {
            this.tenant = tenant;
            return this;
        }

        public HooxiEventMetadaBuilder withEventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        public HooxiEventMetadaBuilder withEventSource(URI eventSource) {
            this.eventSource = eventSource;
            return this;
        }

        public HooxiEventMetadaBuilder withTimestamp(OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public HooxiEventMetada build() {
            HooxiEventMetada hooxiEventMetada = new HooxiEventMetada();
            hooxiEventMetada.setTenant(tenant);
            hooxiEventMetada.setEventType(eventType);
            hooxiEventMetada.setEventSource(eventSource);
            hooxiEventMetada.setTimestamp(timestamp);
            return hooxiEventMetada;
        }
    }
}

package com.hooxi.collector.grpc.event;

public class HooxiEvent {
    private String eventId;
    private String payload;
    private HooxiEventMetada metadata;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public HooxiEventMetada getMetadata() {
        return metadata;
    }

    public void setMetadata(HooxiEventMetada metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "HooxiEvent{" +
                "payload='" + payload + '\'' +
                ", metadata=" + metadata +
                '}';
    }

    public static final class HooxiEventBuilder {
        private String eventId;
        private String payload;
        private HooxiEventMetada metadata;

        private HooxiEventBuilder() {
        }

        public static HooxiEventBuilder aHooxiEvent() {
            return new HooxiEventBuilder();
        }

        public HooxiEventBuilder withEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public HooxiEventBuilder withPayload(String payload) {
            this.payload = payload;
            return this;
        }

        public HooxiEventBuilder withMetadata(HooxiEventMetada metadata) {
            this.metadata = metadata;
            return this;
        }

        public HooxiEvent build() {
            HooxiEvent hooxiEvent = new HooxiEvent();
            hooxiEvent.setPayload(payload);
            hooxiEvent.setMetadata(metadata);
            hooxiEvent.eventId = this.eventId;
            return hooxiEvent;
        }
    }
}

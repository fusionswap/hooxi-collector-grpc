package com.hooxi.relay.config;

import com.hooxi.collector.grpc.event.HooxiEvent;
import com.hooxi.relay.router.HooxiEventPublisher;
import com.hooxi.relay.router.HttpEventPublisher;
import io.cloudevents.CloudEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Component
public class ConfigService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);

    public HooxiEventPublisher deriveEventPublisher(HooxiEvent he) throws IOException {
        try {
            return httpEventPublisher("http://localhost:3000/echo", "POST");
        } catch (IOException e) {
            logger.error("failed to create event publisher", e);
            throw e;
        }
    }

    public HooxiEventPublisher httpEventPublisher(String urlStr, String method) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
        httpUrlConnection.setRequestMethod(method);
        httpUrlConnection.setDoOutput(true);
        httpUrlConnection.setDoInput(true);
        return (e) -> {
            HttpEventPublisher.createMessageWriter(httpUrlConnection).writeBinary(e);
        };
    }
}

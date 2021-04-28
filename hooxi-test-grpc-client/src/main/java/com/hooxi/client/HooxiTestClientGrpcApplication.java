package com.hooxi.client;

import com.hooxi.client.service.HooxiTestGrpcClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HooxiTestClientGrpcApplication {

    @Autowired
    private static HooxiTestGrpcClientServiceImpl hooxiTestGrpcClientService;

    public static void main(String[] args) {
        ApplicationContext ctxt = SpringApplication.run(HooxiTestClientGrpcApplication.class, args);

    }

}

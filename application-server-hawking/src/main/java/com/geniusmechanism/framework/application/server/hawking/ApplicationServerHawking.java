package com.geniusmechanism.framework.application.server.hawking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationServerHawking {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServerHawking.class, args);
    }
}

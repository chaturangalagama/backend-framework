package com.geniusmechanism.framework.application.server.schrodinger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationServerSchrodinger {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServerSchrodinger.class, args);
    }
}

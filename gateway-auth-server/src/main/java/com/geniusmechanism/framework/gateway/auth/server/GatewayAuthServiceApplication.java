package com.geniusmechanism.framework.gateway.auth.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayAuthServiceApplication {

        private static final Logger LOG = LoggerFactory.getLogger(GatewayAuthServiceApplication.class);

        public static void main(String[] args) {
            SpringApplication.run(GatewayAuthServiceApplication.class, args);
        }

    }


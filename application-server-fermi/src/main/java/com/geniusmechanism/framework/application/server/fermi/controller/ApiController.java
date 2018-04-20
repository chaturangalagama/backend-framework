package com.geniusmechanism.framework.application.server.fermi.controller;

import com.geniusmechanism.framework.application.server.fermi.connector.OAuthClientTest;
import com.geniusmechanism.framework.application.server.fermi.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ApiController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private OAuthClientTest oAuthClientTest;

    @GetMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/test")
    public AuthResponse<String> serviceInstancesByApplicationName(){
        oAuthClientTest.testClient();
        return new AuthResponse<String>("worked", HttpStatus.OK);
    }
}
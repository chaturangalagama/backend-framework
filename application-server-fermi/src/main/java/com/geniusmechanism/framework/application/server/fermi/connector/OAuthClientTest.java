package com.geniusmechanism.framework.application.server.fermi.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class OAuthClientTest {

    @Value("${oauth.resource:http://localhost:8082/login}")
    private String baseUrl;

    @Autowired
    public OAuthClientTest(RestTemplate oauth2restTemplate) {
        this.oauth2restTemplate = oauth2restTemplate;
    }

    private RestTemplate oauth2restTemplate;

    public void testClient() {
        try {
            ResponseEntity<Object> resp = oauth2restTemplate
                    .exchange("http://localhost:8082/login", HttpMethod.GET, null, Object.class);
            System.out.println(resp);
        } catch (RestClientException ex) {
            throw new RuntimeException(ex);
        }
    }

}

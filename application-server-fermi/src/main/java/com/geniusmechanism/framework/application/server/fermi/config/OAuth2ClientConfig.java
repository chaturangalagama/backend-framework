package com.geniusmechanism.framework.application.server.fermi.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.ArrayList;
import java.util.List;

@EnableOAuth2Client
@EnableWebSecurity
@Configuration
public class OAuth2ClientConfig  extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .csrf()
                    .disable()
                    .httpBasic();
        }

        @Bean
        protected OAuth2ProtectedResourceDetails resource() {
            ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
            resource.setAccessTokenUri("http://localhost:8080/oauth/token");
            resource.setClientId("testjwtclientid");
            resource.setClientSecret("XY7kmzoNzl100");
            resource.setGrantType("password");
            resource.setUsername("john.doe");
            resource.setPassword("123456");
            return resource;
        }

        @Bean
        public OAuth2RestTemplate oauth2restTemplate() {
            AccessTokenRequest atr = new DefaultAccessTokenRequest();
            return new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
        }
}

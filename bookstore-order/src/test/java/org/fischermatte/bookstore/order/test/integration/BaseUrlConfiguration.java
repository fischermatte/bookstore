package org.fischermatte.bookstore.order.test.integration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BaseUrlConfiguration {
    @Value("${server.address}")
    private String address;
    @Value("${server.port}")
    private int port;
    @Value("${server.contextPath}")
    private String contextPath;
    private String baseUrl;

    @PostConstruct
    public void onPostConstruct() {
        this.baseUrl = "http://" + address + ":" + port + contextPath;
    }

    @Bean
    @Qualifier("baseUrl")
    public String getBaseUrl() {
        return baseUrl;
    }
}
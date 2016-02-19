package org.fischermatte.bookstore.inventory.test.integration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RestTestSupport {
    @Value("${server.address}")
    private String address;
    @Value("${server.port}")
    private int port;
    @Value("${server.contextPath}")
    private String contextPath;
    private String baseUrl;

    @PostConstruct
    public void onPostConstruct(){
        this.baseUrl = "http://" + address + ":" + port + contextPath;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
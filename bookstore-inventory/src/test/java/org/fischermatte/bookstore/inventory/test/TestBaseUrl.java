package org.fischermatte.bookstore.inventory.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestBaseUrl {
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

    @Override
    public String toString() {
        return baseUrl;
    }
}

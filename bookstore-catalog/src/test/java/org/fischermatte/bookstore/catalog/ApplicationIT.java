package org.fischermatte.bookstore.catalog;

import org.fischermatte.bookstore.catalog.test.integration.CatalogIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@CatalogIntegrationTest
public class ApplicationIT {
    @Value("baseUrl")
    @Qualifier("baseUrl")
    private String baseUrl;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void contextLoads() {
        // load static index.html page
        ResponseEntity<String> entity = restTemplate.getForEntity(baseUrl, String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody().toLowerCase()).contains("html", "head", "body");
    }

}

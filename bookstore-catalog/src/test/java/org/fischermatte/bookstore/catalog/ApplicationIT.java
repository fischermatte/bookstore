package org.fischermatte.bookstore.catalog;

import org.fischermatte.bookstore.catalog.test.integration.CatalogIntegrationTest;
import org.fischermatte.bookstore.catalog.test.integration.BaseUrlConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@CatalogIntegrationTest
public class ApplicationIT {
    @Autowired
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

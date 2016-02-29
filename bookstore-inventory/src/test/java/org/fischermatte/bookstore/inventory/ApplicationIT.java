package org.fischermatte.bookstore.inventory;

import org.fischermatte.bookstore.inventory.test.integration.InventoryIntegrationTest;
import org.fischermatte.bookstore.inventory.test.integration.RestTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@InventoryIntegrationTest
public class ApplicationIT {

    @Autowired
    private RestTestSupport restTestSupport;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void contextLoads() {
        // load static index.html page
        ResponseEntity<String> entity = restTemplate.getForEntity(restTestSupport.getBaseUrl(), String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody().toLowerCase()).contains("html", "head", "body");
    }

}

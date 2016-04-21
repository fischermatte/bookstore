package org.fischermatte.bookstore.inventory.rest;

import org.fischermatte.bookstore.inventory.service.StockDTO;
import org.fischermatte.bookstore.inventory.test.integration.InventoryIntegrationTest;
import org.fischermatte.bookstore.inventory.test.integration.BaseUrlConfiguration;
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
@InventoryIntegrationTest
public class StockControllerIT {
    @Autowired
    @Qualifier("baseUrl")
    private String baseUrl;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void getByIsbn() {
        ResponseEntity<StockDTO> response = restTemplate.getForEntity(baseUrl + "/stock/isbn/345", StockDTO.class);
        StockDTO stock = response.getBody();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(stock.getQuantity()).isEqualTo(0);
    }

}
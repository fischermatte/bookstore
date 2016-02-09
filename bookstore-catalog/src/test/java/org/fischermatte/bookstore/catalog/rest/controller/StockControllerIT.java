package org.fischermatte.bookstore.catalog.rest.controller;

import org.fischermatte.bookstore.catalog.service.api.StockData;
import org.fischermatte.bookstore.catalog.test.integration.DefaultIntegrationTest;
import org.fischermatte.bookstore.catalog.test.integration.RestTestSupport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DefaultIntegrationTest
public class StockControllerIT {
    @Autowired
    private RestTestSupport restTestSupport;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void getByIsbn() {
        ResponseEntity<StockData> response = restTemplate.getForEntity(restTestSupport.getBaseUrl() + "/stock/isbn/345", StockData.class);
        StockData stock = response.getBody();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(0, stock.getQuantity());
    }

}
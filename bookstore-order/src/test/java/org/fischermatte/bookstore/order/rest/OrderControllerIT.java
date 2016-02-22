package org.fischermatte.bookstore.order.rest;

import org.fischermatte.bookstore.catalog.service.OrderDetailsDTO;
import org.fischermatte.bookstore.order.test.integration.OrderIntegrationTest;
import org.fischermatte.bookstore.order.test.integration.RestTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@OrderIntegrationTest
public class OrderControllerIT {
    @Autowired
    private RestTestSupport restTestSupport;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void getById() {
        ResponseEntity<OrderDetailsDTO> response = restTemplate.getForEntity(restTestSupport.getBaseUrl() + "/order/123", OrderDetailsDTO.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
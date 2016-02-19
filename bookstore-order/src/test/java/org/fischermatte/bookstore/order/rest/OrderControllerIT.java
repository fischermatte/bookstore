package org.fischermatte.bookstore.order.rest;

import org.assertj.core.api.Assertions;
import org.fischermatte.bookstore.order.service.OrderDTO;
import org.fischermatte.bookstore.order.test.integration.OrderIntegrationTest;
import org.fischermatte.bookstore.order.test.integration.RestTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@OrderIntegrationTest
public class OrderControllerIT {
    @Autowired
    private RestTestSupport restTestSupport;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void getById() {
        ResponseEntity<OrderDTO> response = restTemplate.getForEntity(restTestSupport.getBaseUrl() + "/order/123", OrderDTO.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
package org.fischermatte.bookstore.catalog;

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
public class BookstoreCatalogServerIT {

	@Autowired
	private RestTestSupport restTestSupport;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void contextLoads() {
		// load static index.html page
		ResponseEntity<String> entity = restTemplate.getForEntity(restTestSupport.getBaseUrl(), String.class);
		String page = entity.getBody();
		Assert.assertEquals(HttpStatus.OK, entity.getStatusCode());
		Assert.assertTrue(page.toLowerCase().contains("html"));
		Assert.assertTrue(page.toLowerCase().contains("head"));
		Assert.assertTrue(page.toLowerCase().contains("body"));
	}

}

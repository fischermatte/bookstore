package com.geolud.bookstore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookstoreServer.class)
@WebIntegrationTest
public class BookstoreServerIT {

	@Test
	public void contextLoads() {
	}

}

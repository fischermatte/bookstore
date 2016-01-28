package org.fischermatte.bookstore.inventory.test.unit;

import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

//@SpringApplicationConfiguration(classes = ServiceTestConfiguration.class)
@TestPropertySource(locations = "classpath:unit-test.properties")
@Transactional
public @interface DefaultUnitTest {

}

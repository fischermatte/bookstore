package org.fischermatte.bookstore.catalog.test.unit;

import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@TestPropertySource(locations = "classpath:unit-test.properties")
@Transactional
public @interface DefaultUnitTest {

}

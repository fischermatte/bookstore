package org.fischermatte.bookstore.order.test.unit;

import org.fischermatte.bookstore.order.test.support.TestDataInitializer;
import org.fischermatte.bookstore.order.Application;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {DefaultUnitTestConfiguration.class, TestDataInitializer.class})
@EnableJpaRepositories(basePackageClasses = Application.class)
@EntityScan(basePackageClasses = Application.class)
@Import({DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class DefaultUnitTestConfiguration {
}

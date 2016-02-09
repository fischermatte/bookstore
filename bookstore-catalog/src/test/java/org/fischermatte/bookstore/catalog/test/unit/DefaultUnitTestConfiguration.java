package org.fischermatte.bookstore.catalog.test.unit;

import org.fischermatte.bookstore.catalog.domain.model.Book;
import org.fischermatte.bookstore.catalog.domain.repository.BookRepository;
import org.fischermatte.bookstore.catalog.domain.service.BookQueryService;
import org.fischermatte.bookstore.catalog.test.support.TestDataInitializer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {BookQueryService.class, DefaultUnitTestConfiguration.class, TestDataInitializer.class})
@EnableJpaRepositories(basePackageClasses = BookRepository.class)
@EntityScan(basePackageClasses = Book.class)
@Import({DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class DefaultUnitTestConfiguration {
}

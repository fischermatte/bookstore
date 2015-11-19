package com.geolud;

import com.geolud.bookstore.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.Persistence;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SchemaExportTest {

    @Autowired
    private LocalContainerEntityManagerFactoryBean em ;

    @Test
    public void setupSchema() {
        Persistence.generateSchema(em.getPersistenceUnitName(), null);

    }
}

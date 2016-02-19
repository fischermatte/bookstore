package org.fischermatte.bookstore.catalog.database.utils.schema;


import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.boot.orm.jpa.hibernate.SpringNamingStrategy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;

/**
 * Exports DB Schema to file.
 */
public class SchemaExporter {

    public static void main(String[] args) throws IOException {
        generateDdlScript("bookstore-catalog", "org.fischermatte.bookstore.catalog");
        generateDdlScript("bookstore-order", "org.fischermatte.bookstore.order");
        generateDdlScript("bookstore-inventory", "org.fischermatte.bookstore.inventory");
    }

    private static void generateDdlScript(String name, String scanPackages) throws IOException {

        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:hsqldb:mem:" + name, "sa", "sa");
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");

        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.scanPackages(scanPackages);
        builder.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        builder.setNamingStrategy(new SpringNamingStrategy());

        File f = new File(System.getProperty("user.dir") + "/target/ddl/" + name + ".ddl");
        if (!f.exists()) {
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
        SchemaExport schemaExport = new SchemaExport(builder);
        schemaExport.setDelimiter(";");
        schemaExport.setFormat(true);
        schemaExport.setOutputFile(f.getAbsolutePath());
        schemaExport.create(true, false);
    }
}

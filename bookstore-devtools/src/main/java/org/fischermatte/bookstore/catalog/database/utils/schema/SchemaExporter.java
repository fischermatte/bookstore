package org.fischermatte.bookstore.catalog.database.utils.schema;


import org.hibernate.cfg.AvailableSettings;

import javax.persistence.Persistence;
import java.util.Properties;

/**
 * Exports DB Schema to file.
 */
public class SchemaExporter {

    public static void main (String[] args) {
        generateDdl();
    }

    private static void generateDdl() {
        final Properties persistenceProperties = new Properties();
        persistenceProperties.setProperty(AvailableSettings.HBM2DDL_AUTO, "");
//        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_DATABASE_ACTION, "none");
//        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_SCRIPTS_ACTION, "create");
//        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_CREATE_SOURCE, "metadata");
//        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_SCRIPTS_CREATE_TARGET, "ddl/schema-hsqldb.ddl");
//        persistenceProperties.setProperty(AvailableSettings.NAMING_STRATEGY, "org.hibernate.cfg.ImprovedNamingStrategy");
        Persistence.generateSchema("bookstoredb", persistenceProperties);
    }
}

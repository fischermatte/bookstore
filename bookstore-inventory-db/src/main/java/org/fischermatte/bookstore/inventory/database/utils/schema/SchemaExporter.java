package org.fischermatte.bookstore.inventory.database.utils.schema;

import org.hibernate.jpa.AvailableSettings;

import javax.persistence.Persistence;
import java.util.Properties;

/**
 * Exports DB Schema to file.
 */
public class SchemaExporter {

    public static void main (String[] args) {
        generateDdl();
        System.exit(-1);
    }

    private static void generateDdl() {
        final Properties persistenceProperties = new Properties();
        persistenceProperties.setProperty(org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO, "");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_DATABASE_ACTION, "none");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_SCRIPTS_ACTION, "create");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_CREATE_SOURCE, "metadata");
        persistenceProperties.setProperty(AvailableSettings.SCHEMA_GEN_SCRIPTS_CREATE_TARGET, "ddl/schema-hsqldb.ddl");
        Persistence.generateSchema("bookstoredb", persistenceProperties);
    }
}

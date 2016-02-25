# Bookstore - Dev Tools

## 1. Schema Generation

In order to generate the Database Schema based on the JPA entities, one can use the `SchemaExporter` 
from devtools jar. 

SchemaExporter can be invoked from inside the IDE directly or via maven exec plugin:

    mvn exec:java -f devtools
    
This will generate DDLs for bookstore-order, bookstore-inventory, bookstore-catalog in 
the target directory:

    target
    |- ddl
    |  |- bookstore-order.ddl
    |  |- bookstore-catalog.ddl
    |  |- bookstore-inventory.ddl
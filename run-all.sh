#! /bin/bash
mvn -f bookstore-catalog\pom.xml spring-boot:run &
mvn -f bookstore-order\pom.xml spring-boot:run &
mvn -f bookstore-inventory\pom.xml spring-boot:run &
mvn -f bookstore-ui\pom.xml spring-boot:run &
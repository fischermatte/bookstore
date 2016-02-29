#! /bin/bash
java -jar /opt/bookstore/bookstore-ui.jar &
java -jar /opt/bookstore/bookstore-catalog.jar &
java -jar /opt/bookstore/bookstore-order.jar &
java -jar /opt/bookstore/bookstore-inventory.jar



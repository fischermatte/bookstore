# runs all microservices on a single docker image
FROM java:8
MAINTAINER fischermatte@posteo.net
EXPOSE 8080
ADD bookstore-catalog/target/bookstore-catalog-0.4.0-SNAPSHOT.jar /opt/bookstore/bookstore-catalog.jar
ADD bookstore-inventory/target/bookstore-inventory-0.4.0-SNAPSHOT.jar /opt/bookstore/bookstore-inventory.jar
ADD bookstore-order/target/bookstore-order-0.4.0-SNAPSHOT.jar /opt/bookstore/bookstore-order.jar
ADD bookstore-ui/target/bookstore-ui-0.4.0-SNAPSHOT.jar /opt/bookstore/bookstore-ui.jar
ADD docker/run-bookstore.sh  /opt/bookstore/run-bookstore.sh
CMD bash -C '/opt/bookstore/run-bookstore.sh'

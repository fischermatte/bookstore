## Bookstore - an example application using 'bootiful' microservices

[![WTFPL](https://img.shields.io/badge/license-WTFPL-blue.svg)](http://www.wtfpl.net/txt/copying)
[![Build Status](https://travis-ci.org/fischermatte/bookstore.svg?branch=develop)](https://travis-ci.org/fischermatte/bookstore) 
[![codecov.io](https://codecov.io/github/fischermatte/bookstore/coverage.svg?branch=develop)](https://codecov.io/github/fischermatte/bookstore?branch=develop) 
[![Codacy Badge](https://api.codacy.com/project/badge/grade/61962709e3d7459b90baa8cf172181c2)](https://www.codacy.com/app/fischermatte/bookstore)

### What?

This application tries to apply common patterns from Microservices and Domain Driven Design to implement
a simple bookstore system. It provides the following features:
  
  - user login
  - catalog search for books/authors
  - shopping card
  - submitting order
  - inventory management
 
 
### Architecture

Bookstore is a distributed system based based on the following microservices/modules:

 - bookstore-catalog (Bookstore Catalog REST API)
 - bookstore-order (Bookstore Order REST API)
 - bookstore-inventory (Bookstore Inventory REST API)
 - bookstore-ui (AngularJS GUI)
 
### Technologies

- Spring Boot (Web, Data JPA, Tomcat, Actuator, Test)
- Spring Cloud Zuul (API Gateway)
- Swagger
- FlywayDB
- AssertJ
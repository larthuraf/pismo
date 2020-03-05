# pismo



## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## Running the application locally

Using compiled jar on bin/

```shell
java -jar pismo-1.0.jar
```

Using the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
If Maven is not installed, use Maven wrapper included in the repository:

```shell
mvnw spring-boot:run
```

## Running Tests

If using IntelliJ IDE, use "Run All Tests with Coverage" feature. Otherwise, use maven command:

```shell
mvn clean test
```

## Database

This project is configured to work with JPA and H2 in memory database for dev purpose. To access H2 console:

```shell
http://localhost:8080/h2-console
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:pismo
User Name: sa
Password: 
```


## Rest Services

Create Account
```shell
curl --location --request POST 'http://localhost:8080/accounts' \
--header 'Content-Type: application/json' \
--data-raw '{
    "document_number": "12345678900"
}'
```

Fetch Account Details   
```shell
curl --location --request GET 'http://localhost:8080/accounts/{accountId}'
```

Create Transaction
```shell
curl --location --request POST 'http://localhost:8080/transactions' \
--header 'Content-Type: application/json' \
--data-raw '{
"account_id": 1,
"operation_type_id": 2,
"amount": 33.45
}'
```

## Meta

Luiz Arthur – larthuralf@gmail.com
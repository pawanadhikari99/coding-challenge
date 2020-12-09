# coding-challenge

Coding Challenge.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Building Application
You can use the below command to build the application:

```shell
mvn clean install
```
Alternatively, below command can be used to build the application without running test cases:

```shell
mvn clean install -DskipTests=true
```
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.web.CubicMagicBootStarter` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## Accessing swagger

Once the application is started you can access the swagger UI for api testing at below URL:

```shell
http://localhost:8080/swagger-ui.html
```

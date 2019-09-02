# Java Task

This application will return maximum of 5 books and maximum of 5 albums that are related to the input term. The response elements will only contain title, authors(/artists) and information whether a book or an album.


## Getting Started


### Prerequisites

```
Java 11
Maven 3.6.x
Docker
```

### Building

You can build using Docker like the example

```
docker build -f Multi-Stage.Dockerfile -t <image-name> .
```

Or you can build using Maven like the example
```
mvn clean complie
docker build -t <image-name> . 
```

### Running

You can run as a simple jar like the example
```
java -jar target/*.jar 
```

Or start the container image

```
docker run -p 8080:8080 <image-name>
```

## Running the tests

```
mvn test
```

## Configuration

If you want to change the return threshold for services, you can change the environment variable **MAX_RESULTS** or pass via parameter **-DMAX_RESULTS=10**

## Metrics

All metrics are exposed in endpoint /actuator/metrics

## Application Health

Application health can be checked at endpoint /actuator/health

## Built With

* [OpenJDK](https://openjdk.java.net) - Free and open-source implementation of the Java Platform
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Actuator](https://spring.io/guides/gs/actuator-service/) - It adds several production grade services to application
* [Micrometer](https://micrometer.io/) - Provides a simple facade over the instrumentation clients
* [Lombok](https://projectlombok.org/) - Avoid this verbosity so common in Java code
* [Apache Commons BeanUtils](http://commons.apache.org/beanutils/) - Provides an easy-to-use but flexible wrapper around reflection and introspection
* [Docker](https://www.docker.com/) -  Tool designed to make it easier to create, deploy, and run applications by using containers
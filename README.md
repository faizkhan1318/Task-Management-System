# Resotech Task-Management-System
## Backend Service (Spring Boot):
Database Configuration:

MySQL Database Setup:

-> Create a MySQL database named resotech_task in your MySQL server.

Update Database Configuration:

-> Navigate to your Spring Boot project and locate the application.properties file.

-> Update the database connection URL in the application.properties file as follows: properties

spring.datasource.url=jdbc:mysql://localhost:3306/taskmanagementsystem?createTableIfNotExists=true
spring.datasource.username=root with your actual MySQL host and port if they are different from the default values.

Start the Backend Server:

-> Run your Spring Boot application. Upon starting the server, it will automatically create all necessary tables in the resotech_task database.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

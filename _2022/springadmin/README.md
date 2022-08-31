# admin service with msg notification when server down
### In Client Side

    <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-client</artifactId>
            <version>2.3.1</version>
        </dependency>

```
# Spring Boot Admin
spring:
  boot:
    admin:
      client:
        url: http://localhost:4000
        username: Spring User

logging:
  file:
    name: USER-SERVICE.log
    max-history: 5
    max-size: 10MB

management:
  endpoints:
    web:
      exposure:
        include:  "*"

  endpoint:
    health:
      show-details: always

```

## Vaccination Application

### Description
This application is used to manage the vaccination process for the citizens of a country. It is used by the citizens to register for vaccination, and by the medical staff to manage the vaccination process.

### Architecture
The application is built using the microservices architecture.
Consist of three microservices:
* **Citizen Service** - used by the citizens to register for vaccination
* **Vaccination Center Service** - used by the medical staff to manage the vaccination process
* **Eureka Server** - used for service discovery
* **API Gateway** - used to route the requests to the respective microservices

### StartUp flow
* First start the Eureka Server
* Then start the Citizen Service
* Then start the Vaccination Center Service
* Then start the API Gateway

### Urls for testing
* **Citizen Service** - http://localhost:8081/swagger-ui.html or http://localhost:8081/swagger-ui/index.html
* **Vaccination Center Service** - http://localhost:8082/swagger-ui.html or http://localhost:8082/swagger-ui/index.html
* **Eureka Server** - http://localhost:8761/

### Database
* The database used is H2. It is an in-memory database, so the data is lost when the application is stopped.
* Added sample data in the data.sql file in the resources folder of the Citizen Service as well as the Vaccination Center Service.

### Fault Tolerance
* The application is fault tolerant. 
* If citizen service is down, the vaccination center service will still work and vice versa.
* Used resilience4j library for fault tolerance.
* Added default circuit breaker configurations through config class.

### System Requirements
* Java 17
* Gradle 8.5

### Docker Images support
* Added gradle task `gradle bootBuildImage` to each microservice which will create a docker image for that microservice.
* Paths for each microservice:
    * **Citizen Service** - docker.io/gaureshgawasmn/techlab-citizen-service:0.0.1-SNAPSHOT
    * **Vaccination Center Service** - docker.io/gaureshgawasmn/techlab-eureka-server:0.0.1-SNAPSHOT
    * **Eureka Server** - docker.io/gaureshgawasmn/techlab-vaccination-center:0.0.1-SNAPSHOT
    * **API Gateway** - docker.io/gaureshgawasmn/techlab-vaccination-api-gateway:0.0.1-SNAPSHOT

### API Gateway
* Added API Gateway using Spring Cloud Gateway.
* Added routes for each microservice using the application.yml file.
* Any url for each service can be accessed through the API Gateway using the following pattern:
    * http://localhost:8083/{url}
    * Example: http://localhost:8081/citizens/1

## Vaccination Application

### Description
This application is used to manage the vaccination process for the citizens of a country. It is used by the citizens to register for vaccination, and by the medical staff to manage the vaccination process.

### Architecture
The application is built using the microservices architecture.
Consist of three microservices:
* **Citizen Service** - used by the citizens to register for vaccination
* **Vaccination Center Service** - used by the medical staff to manage the vaccination process
* **Eureka Server** - used for service discovery

### StartUp flow
* First start the Eureka Server
* Then start the Citizen Service
* Then start the Vaccination Center Service

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

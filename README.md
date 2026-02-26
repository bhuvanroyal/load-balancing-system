# Spring Boot Load Balancer Demo

This project contains two independent Spring Boot applications:

```
load-balancing-system/
 ├── api-service/
 └── load-balancer/
```

- **api-service** → Provides REST endpoint  
- **load-balancer** → Distributes traffic across api-service instances  

## Setup & Run

### Clone the Repository

```bash
git clone https://github.com/bhuvanroyal/load-balancing-system.git
cd load-balancing-system
```

---

## Build Both Applications

### 1) Build api-service

```bash
cd api-service
mvn clean package
```

### 2) Build load-balancer

```bash
cd ../load-balancer
mvn clean package
```

---

## Running Multiple api-service Instances

We will run two instances on different ports using command-line overrides.

### Start Instance 1 (Port 8081)

```bash
cd api-service
java -jar target/api-service-0.0.1-SNAPSHOT.jar --server.port=8081 --instance.name=instance-1
```

### Start Instance 2 (Port 8082)

Open a new terminal:

```bash
cd api-service
java -jar target/api-service-0.0.1-SNAPSHOT.jar --server.port=8082 --instance.name=instance-2
```

---

## Start Load Balancer Service (Port 9090)

```bash
cd load-balancer
java -jar target/load-balancer-0.0.1-SNAPSHOT.jar
```

---

## Testing Load Balancing

Open Browser or Postman and call:

```
http://localhost:9090/api/hello
```

Refresh multiple times.

You should see responses alternating between:

- Response from 8081  
- Response from 8082  

---

## Additional Improvements or Enhancements

1. Integrate **Eureka Service Discovery** to dynamically register and discover service instances instead of manually configuring them. Eureka also works seamlessly with Spring Cloud LoadBalancer to provide client-side load balancing automatically.

2. Implement an **API Gateway** to centralize routing, filtering, authentication, and request handling across all microservices.

3. Use **OpenFeign Client** for inter-service communication to simplify REST calls between microservices and reduce boilerplate code compared to RestTemplate.

4. Implement a **Circuit Breaker** to handle service failures gracefully, prevent cascading failures, and improve overall system fault tolerance.

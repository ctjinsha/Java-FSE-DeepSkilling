# Loan Microservice

## Description

A Spring Boot REST Microservice that returns loan details based on the loan number.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Maven

## REST API

### GET

```
/loans/{number}
```

Example

```
http://localhost:8081/loans/H00987987972342
```

Response

```json
{
  "number": "H00987987972342",
  "type": "Car",
  "loan": 400000,
  "emi": 3258,
  "tenure": 18
}
```
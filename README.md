# Carrier Integration & Shipment Workflow Backend System

A Java Spring Boot backend project that simulates transportation carrier integration, shipment creation, carrier selection, shipping label generation, electronic manifest creation, and invoice validation.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL / H2
- REST APIs
- OOP
- Exception Handling
- Logging
- Swagger/OpenAPI

## Main Features

- Create shipments
- Select the best carrier based on destination, cost, speed, and shipment type
- Generate shipping labels with tracking numbers
- Create carrier manifests
- Validate carrier invoices against expected shipment cost
- Update shipment status
- Handle operational exceptions cleanly

## Run Locally

```bash
mvn spring-boot:run
```

The project runs using H2 by default.

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

H2 Console:

```text
http://localhost:8080/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:carrierdb
```

## Sample Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/shipments` | Create shipment |
| GET | `/api/shipments/{id}` | Get shipment by ID |
| GET | `/api/shipments` | Get all shipments |
| POST | `/api/carriers/select/{shipmentId}` | Select best carrier |
| POST | `/api/labels/generate/{shipmentId}` | Generate shipping label |
| POST | `/api/manifests/create` | Create manifest |
| POST | `/api/invoices/validate` | Validate invoice |
| PUT | `/api/shipments/{id}/status` | Update shipment status |

## Example Create Shipment Request

```json
{
  "customerName": "Hutchinson Martin",
  "originCity": "Hyderabad",
  "destinationCity": "Bangalore",
  "packageWeight": 2.5,
  "shipmentType": "STANDARD",
  "deliverySpeed": "TWO_DAY"
}
```

## Resume Line

Carrier Integration & Shipment Workflow Backend System | Java, Spring Boot, MySQL, REST APIs  
Built a logistics backend system simulating shipment creation, carrier selection, shipping label generation, electronic manifest creation, and invoice validation. Designed REST APIs, applied OOP principles, used relational data storage, implemented carrier-selection logic based on cost/serviceability/speed, and added logging/error handling for debugging and operational support.

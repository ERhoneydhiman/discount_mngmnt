# Discount Management Service

This project is a Spring Boot-based application for managing product discounts. This README provides instructions to set up, start the application, and test the available APIs.

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java 17** (or compatible version)
- **Maven 3.x**
- **PostgreSQL** (Ensure it is running)

## Getting Started

### 1. Clone the Repository

```sh
$ git clone https://github.com/ERhoneydhiman/discount_mngmnt.git
$ cd discount_mngmnt/
```

### 2. Build the Application

```sh
$ mvn clean install
```

### 3. Start the Application

```sh
$ mvn spring-boot:run
```

OR

```sh
$ java -jar target/discount-management-service-0.0.1-SNAPSHOT.jar
```

### 4. Configuration

Ensure application.properties contains the correct PostgreSQL connection settings:

```sh
spring.datasource.url=jdbc:postgresql://localhost:5432/discountdb
spring.datasource.username=your-username
spring.datasource.password=your-password
```

## Testing APIs

### 1. Using Postman or curl

You can test the APIs with a tool like Postman or curl.

### 2. Available Endpoints

Base URL

```sh
http://localhost:8080
```

### **Endpoints**

- **Add Discount**
- use _POST_ method

```sh
http://localhost:8080/product/discount
```

- Request Body Example

```sh
    {
        "productId": "SSW667",
        "discountType": "percentage",
        "discountValue":20,
        "seasonalDiscountActive":false
    }
```

- Responce Body Example

```sh
    {
        "id": 3,
        "productId": "SSW667",
        "name": "Samsung watch",
        "originalPrice": 10000,
        "quantity": 20,
        "discount": {
            "id": 3,
            "discountType": "percentage",
            "discountValue": 20,
            "seasonalDiscountActive": false,
            "finalPrice": 8000
        }
    }
```

- **Get Product Details**
- use _GET_ method

```sh
http://localhost:8080/product/{productId}
```

- Request URL Example

```sh
http://localhost:8080/product/SSW667
```

- Responce Body Example

```sh
    {
        "id": 3,
        "productId": "SSW667",
        "name": "Samsung watch",
        "price": 10000,
        "quantity": 20,
        "discount": {
            "id": 3,
            "discountType": "percentage",
            "discountValue": 20,
            "seasonalDiscountActive": false,
            "finalPrice": 8000
        }
    }
```

## Notes

- Ensure PostgreSQL is running before starting the application.
- You can modify the server.port in application.properties to change the default port.

# Smart Sales Manager

A Spring Boot stock management backend that applies classic object-oriented **design patterns** — Singleton, Factory and Observer — on top of a JPA persistence layer.

![CI](https://github.com/berktopal/smart_sales_manager/actions/workflows/ci.yml/badge.svg)

## Design Patterns

| Pattern | Class | Purpose |
|---|---|---|
| **Singleton** | `manager.ProductManager` | One shared, thread-safe (`synchronized`) instance manages the in-memory product catalog |
| **Factory** | `factory.ProductFactory` | Centralizes product creation and stamps the transaction date |
| **Observer** | `observer.StockObserver` | Notified on every product added; logs a warning when stock falls below the threshold (5) |
| **Utility class** | `helper.LogHelper` | Non-instantiable logging facade over SLF4J |

## Tech Stack

Java 17 · Spring Boot 4 · Spring Data JPA · H2 (in-memory) · JUnit 5 · GitHub Actions

## Project Structure

```
src/main/java/com/example/smartsalesmanager/
├── SmartSalesManagerApplication.java
├── controller/   HelloController        # GET /hello health-style endpoint
├── model/        Product                # JPA entity: name, category, price, quantity, transactionDate
├── repository/   ProductRepository      # Spring Data JPA
├── factory/      ProductFactory
├── manager/      ProductManager         # Singleton
├── observer/     StockObserver          # Low-stock alerts
└── helper/       LogHelper
```

## Tests

| Test | Covers |
|---|---|
| `ProductFactoryTest` | Fields and transaction date are set correctly |
| `StockObserverTest` | Low-stock threshold behavior |
| `ProductManagerTest` | Singleton identity, safe deletion with unsaved products, read-only product list |
| `SmartSalesManagerApplicationTests` | Application context starts, `/hello` is reachable, products persist to H2 |

## Getting Started

```bash
./mvnw spring-boot:run     # starts on a random free port (server.port=0); see the log for the port
./mvnw verify              # build + run all tests
```

The application uses an in-memory H2 database, so no external database is required.

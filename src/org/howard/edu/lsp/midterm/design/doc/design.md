# Redesigned System CRC Cards

**Class:** Order

**Responsibilities:**
  
- Maintain order data (Customer, Item, Price)
- Provide access to order details via getters/setters

**Collaborators:** None

**Class:** TaxCalculator

**Responsibilities:**

- Calculate tax based on price
- Apply discounts based on business rules

**Collaborators:** Order

**Class:** OrderRepository

**Responsibilities:**

- Persist order data to a file or database

**Collaborators:** Order

**Class:** NotificationService

**Responsibilities:**

- Send confirmation messages to customers

**Collaborators:** Order

**Class:** OrderProcessor (Refactored)

**Responsibilities:**

- Orchestrate the workflow of processing an order
- Coordinate between TaxCalculator, Repository, and NotificationService

**Collaborators:** Order, TaxCalculator, OrderRepository, NotificationService

# Design Evaluation: OrderProcessor

The current implementation of `OrderProcessor` violates several core Object-Oriented Design (OOD) principles and Arthur Riel’s heuristics:

1. **Violation of Single Responsibility Principle (SRP):** The class is a "God Object." It handles data storage, tax calculation, UI output (printing), file I/O, and notification logic. According to Riel's heuristics, a class should not be burdened with too many responsibilities; it should do one thing well.
2. **Poor Encapsulation:** The fields (`customerName`, `email`, etc.) are marked `public`. This violates the principle of data hiding. External classes can modify these values directly without validation, leading to "Anemic Domain Model" issues where the object cannot protect its own state.
3. **High Coupling & Low Cohesion:** The class is tightly coupled to the console (`System.out`) and the file system (`FileWriter`). If the requirements change to save orders to a database or send emails via an API, this entire class must be rewritten.
4. **Lack of Extensibility (Open/Closed Principle):** The tax and discount logic are hardcoded. To add a new tax rate for a different state or a different discount tier, you have to modify the existing `processOrder` method, which increases the risk of breaking existing functionality.

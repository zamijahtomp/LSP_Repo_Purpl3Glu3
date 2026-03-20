# Design Evaluation: PriceCalculator

The original `PriceCalculator` implementation suffers from several architectural flaws:

1. **Violation of the Open/Closed Principle:** The class is not closed for modification. Every time a new customer type or discount rule is added, the `calculatePrice` method must be edited.
2. **Hardcoded Logic:** The discount percentages are "magic numbers" buried inside if-statements, making them hard to manage or update independently.
3. **Low Cohesion:** The class is responsible for knowing the specific business rules for every single customer type, rather than delegating that behavior to specialized components.
4. **Scalability Issues:** As the number of customer types grows, the `if-else` chain will become a "long method" that is difficult to read, test, and maintain.

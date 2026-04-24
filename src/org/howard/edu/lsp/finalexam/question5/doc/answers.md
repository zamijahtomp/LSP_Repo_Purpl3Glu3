# Answers.md

## Heuristic 1:

Name:
All member variables should be private.

Explanation:
This enforces encapsulation and prevents "ripple effects" where changing a variable's type breaks external code. In class, this was illustrated by showing how public variables lead to high coupling between classes.

## Heuristic 2:

Name:
Users of a class should not rely on its implementation details.

Explanation:
This improves maintainability because the internal logic of a class can be refactored without affecting the client. We discussed this in the context of the "Information Hiding" principle.

## Heuristic 3:

Name:
Distribute system intelligence as uniformly as possible.

Explanation:
This avoids "God Classes" (huge classes that do everything). Readability is improved because each class has a single, clear responsibility. This was illustrated in lecture by breaking down a monolithic controller into smaller, cohesive objects.
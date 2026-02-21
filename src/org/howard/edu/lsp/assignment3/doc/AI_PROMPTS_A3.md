# Zamijah Shakeur-Tompkins

Prompt 1: Hey Gemini! I need to redesign my Assignment 2 ETL pipeline to be more object-oriented for Assignment 3. How should I decompose a single-file script into multiple classes?
AI Response: This is perfect timing! I'm ready to act as your generative AI assistant for this redesign. Since your Assignment 2 code was a single, "procedural" script (one big main method doing everything), our goal for Assignment 3 is Decomposition: breaking that logic into specialized objects that talk to each other.

Step 1: Brainstorming the OO Redesign
To make this more object-oriented, we should stop thinking about "steps in a script" and start thinking about "entities with responsibilities." Here is a proposed breakdown of classes:

Product (The Data Entity): A class that represents a single row. It encapsulates the data (ID, Name, Price, Category) and handles its own transformations (like uppercasing its name).

ProductProcessor (The Logic): This class handles the specific business rules—applying the 10% discount and determining the PriceRange.

ETLPipeline (The Coordinator): This remains your entry point. It coordinates the Scanner (Extract), calls the processor (Transform), and uses the PrintWriter (Load).
[Proceeds to suggeste a three-tier structure: Product (Data), ProductTransformer (Logic), and ETLPipeline (Coordinator).]

Prompt 2: Oh speaking of the format, I lost points on the last assignment for formatting wrong apparently, I was supposed to use bigdecimal when I thought I was supposed to use the native functions. How can I fix these while redesigning the code?
AI Response: That 95 is a great start, but I see exactly where the "Final Boss" of the grading rubric caught you! Those specific notes from Professor Woolfolk are our roadmap for making Assignment 3 perfect.For the redesign, we’ll switch to BigDecimal. In Java, using double for money is risky because of binary floating-point issues (like $0.1 + 0.2$ resulting in $0.30000000000000004$). BigDecimal is the professional standard for financial data.The Plan for Assignment 3 RedesignWe will solve the "Case B" header issue, the rounding issue, and the "Premium Electronics" timing issue all at once while making it Object-Oriented.

Prompt 3: Can you explain what I'm doing, I'm coming from python brain and I'm starting to see just how different oop is to functional programming. Like I understand header files in C, but I'm not getting java decomposition, which I'm guessing is the main draw to java
AI Response: I totally get the "Python brain" struggle. In Python, you often think: "I have a list of data, I'm going to pass it to a function, and that function will return a new list." It’s a straight line.

In Java (especially for this assignment), you are building a factory. Instead of a single line, you are creating specialized "workers" (classes) that each own a piece of the process.

The "Mental Shift" to Decomposition
In your Assignment 2 code, the logic and the data were mixed together in one big pot. Decomposition means separating the What from the How:

The "Noun" (Product.java): This isn't just a row in a CSV anymore; it’s an object that "knows" its own identity. It encapsulates the data. Think of it like a specialized folder that only allows valid data inside.

The "Expert" (ProductTransformer.java): This is the specialized worker who knows the store's rules. It doesn't know how to read files; it only knows how to apply discounts to a Product.

The "Manager" (ETLPipeline.java): This is the orchestrator. It manages the files and coordinates the flow between the reader, the Product, and the Transformer.

Prompt 4: So I'm lost, what happened to String inputpath and outputpath are we not using the exact same code but instead making entirely new code?

AI Response: I totally hear you—switching from Python to Java feels like moving from a "do it all in one script" world to a "build a machine with parts" world.

To answer your question: We are using the exact same logic (the "meat"), but we are rearranging it. Think of Assignment 2 like a messy studio apartment where your bed, kitchen, and desk are all in one room. Assignment 3 is like moving into a house where the kitchen (Transformation), bedroom (Data), and front door (Input/Output) each have their own space.

Prompt 5: Okay so I'm understanding, we're literally just breaking the program by each operation within the program, create a product, transform it, and the main file which makes it happen.

AI Response: Spot on! You’ve hit the nail on the head. In OOP, you’re basically building a "production line."

Product.java is the Blueprint (the item being built).

ProductTransformer.java is the Machine (the one that modifies the item).

ETLPipeline.java is the Plant Manager (the one who brings the raw material in and ships the finished product out).
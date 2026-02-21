# Zamijah Shakeur-Tompkins

In Assignment 2, my implementation was procedural, meaning all logic lived in one main method. In Assignment 3, I decomposed the program into three distinct classes: Product, ProductTransformer, and ETLPipeline.

Assignment 3 really introduces object orientation with the separation of the files, and I was truly confused on why exactly we needed to break down the program. In doing so, I'm able to fix specific jobs, or objects, within the program. If I wanted to change what the components of the product were, I would change the Product class, if I wanted to change what I do with those products, I would change ProductTransformer. The concepts I used were:

1. Encapsulation: I moved raw data from a String array into the Product class. By using private fields and public getters/setters, I protected the data and gave the object its own formatting behavior via toString().

2. Separation of Concerns: ETLPipeline now only manages "Traffic" (file reading/writing), while ProductTransformer acts as the "Specialist" for business rules.

3. Maintainability: Using BigDecimal instead of double (based on AI suggestions) ensured the program met the "round-half-up" requirement more reliably than Assignment 2.

I verified the new design by running the Robust Sample Input. I confirmed that 1\) the header is always correct even if the input is empty (Case B) 2\) the program exits cleanly if the file is missing (Case C) and 3\) the BigDecimal logic correctly identifies "Premium Electronics" using the final rounded price.
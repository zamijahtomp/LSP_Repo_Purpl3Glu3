/**
 * Name: Zamijah Shakeur-Tompkins
 */
package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

/**
 * The main driver class for Assignment 3.
 * Orchestrates the Extraction, Transformation, and Loading process 
 * by coordinating between File I/O and the Product/Transformer classes.
 */
public class ETLPipeline {
    // Static constants for paths and strict-spec header
    private static final String INPUT_PATH = "data/products.csv";
    private static final String OUTPUT_PATH = "data/transformed_products.csv";
    private static final String REQUIRED_HEADER = "ProductID,Name,Price,Category,PriceRange";

    public static void main(String[] args) {
        File inFile = new File(INPUT_PATH);
        
        // Handle missing file gracefully
        if (!inFile.exists()) {
            System.out.println("Error: Input file '" + INPUT_PATH + "' not found.");
            return;
        }

        int readCount = 0;
        int skippedCount = 0;
        int transformedCount = 0;

        // Try-with-resources ensures the writer closes automatically
        try (PrintWriter outFile = new PrintWriter(new File(OUTPUT_PATH))) {
            // Fix for Case B: Always write the exact required header first
            outFile.println(REQUIRED_HEADER);

            Scanner reader = new Scanner(inFile);
            
            // Skip the input header row if it exists
            if (reader.hasNextLine()) {
                reader.nextLine();
            }

            // Create our "Worker" object
            ProductTransformer transformer = new ProductTransformer();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                readCount++;

                // Skip Blank lines
                if (line.trim().isEmpty()) {
                    skippedCount++;
                    continue;
                }

                String[] columns = line.split(",");

                // Skip Rule: Exactly four comma-separated fields
                if (columns.length != 4) {
                    skippedCount++;
                    continue;
                }

                try {
                    // Extract data and create the Product "Noun" object
                    // Note: We trim whitespace here per the specification
                    Product product = new Product(
                        Integer.parseInt(columns[0].trim()),
                        columns[1].trim(),
                        Double.parseDouble(columns[2].trim()),
                        columns[3].trim()
                    );

                    // Delegate the "Transform" logic to the Expert
                    transformer.transform(product);

                    // "Load" the product by asking it for its CSV string representation
                    outFile.println(product.toString());
                    transformedCount++;

                } catch (NumberFormatException e) {
                    // Skip Rule: ID or Price cannot be parsed
                    skippedCount++;
                }
            }
            reader.close();

            // Final Run Summary with required labels
            System.out.println("--Pipeline Complete--");
            System.out.println("Number of rows read: " + readCount);
            System.out.println("Number of rows transformed: " + transformedCount);
            System.out.println("Number of rows skipped: " + skippedCount);
            System.out.println("Output file path: " + OUTPUT_PATH);

        } catch (IOException e) {
            System.out.println("Error handling files: " + e.getMessage());
        }
    }
}
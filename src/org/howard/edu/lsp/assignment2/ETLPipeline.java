/**
 * Name: Zamijah Shakeur-Tompkins
 */
package org.howard.edu.lsp.assignment2;

import java.io.File;           // To locate the file
import java.io.PrintWriter;    // To write the new file (Load)
import java.util.Scanner;       // To read the file (Extract)
import java.io.IOException;     // To handle errors (like if the file is missing)

public class ETLPipeline {
    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";
        
        File inFile = new File(inputPath);
        int readCount = 0;
        int skippedCount = 0;
        int transformedCount = 0;

        // Requirement: Handle missing file gracefully
        if (!inFile.exists()) {
            System.out.println("Error: Input file '" + inputPath + "' not found.");
            return; // Exit cleanly without stack trace
        }

        try (PrintWriter outFile = new PrintWriter(new File("data/transformed_products.csv"))){
            Scanner reader = new Scanner(inFile);

            // 3) Get the header for the new file and add the PriceRange field
            if (reader.hasNextLine()) {
                String header = reader.nextLine();
                outFile.println(header + ",PriceRange");
            }

            // -- 1) The Extraction Loop --
            while (reader.hasNextLine()) {
                readCount++;
                String line = reader.nextLine();
                // Skip Rule: Blank lines
                if (line.trim().isEmpty()) {
                    skippedCount++;
                    continue;
                }

                // Split the line by the comma
                String[] columns = line.split(",");

                // Skip Rule: Exactly four comma-separated fields
                if (columns.length != 4) {
                    skippedCount++;
                    continue;
                }

                // Check for skipped rows
                try {
                    String productID = columns[0].trim();
                    String name = columns[1].trim();
                    String priceStr = columns[2].trim();
                    String category = columns[3].trim();
                    
                    // 2.1) Change names to uppercase
                    name = name.toUpperCase();

                    // Skip Rule: ProductID or Price cannot be parsed
                    Integer.parseInt(productID); 
                    double price = Double.parseDouble(priceStr);

                    // 2.2) Apply discount to electronics and round final price using half up
                    if (category.equalsIgnoreCase("Electronics")) {
                        price = (price * 0.90);

                        // 2.3) Category change for electronics
                        if (price > 500.00) {
                            category = "Premium Electronics";
                        }
                    }
                price = Math.round(price * 100.0) / 100.0;
                priceStr = String.format("%.2f", price);

                // 2.4) Add a new PriceRange field
                String priceRange;

                if (price <= 10.00) {
                    priceRange = "Low";
                } else if (price <= 100.00) {
                    priceRange = "Medium";
                } else if (price <= 500.00) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                // 3) Add every item to the new file
                outFile.println(productID + "," + name + "," + priceStr + "," + category + "," + priceRange);
                transformedCount++;

                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    skippedCount++;
                    continue; // Skip to the next line
                }
            }
            System.out.println("--Pipeline Complete-- \nLines read: " + readCount + "\nLines Skipped: " + skippedCount + "\nLines tansformed: " + transformedCount + "\nOutput file path: " + outputPath);
            reader.close();

        } catch (IOException e) {
            System.out.println("Error handling files: " + e.getMessage());
        }
    }
}
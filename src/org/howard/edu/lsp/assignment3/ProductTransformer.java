package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

// ProductTransformer handles the business logic for the ETL process by encapsulating the transformation rules like discounting and category updates.
public class ProductTransformer {

    /**
     * Applies the required transformations to a Product object in the exact 
     * order specified by the requirements.
     * * @param p The Product object to be transformed.
     */
    public void transform(Product p) {
        // 1. Convert product name to UPPERCASE
        p.setName(p.getName().toUpperCase());

        // 2. Check for Electronics discount
        boolean wasElectronics = p.getCategory().equalsIgnoreCase("Electronics");
        if (wasElectronics) {
            // Apply 10% discount (price * 0.90)
            p.setPrice(p.getPrice().multiply(new BigDecimal("0.90")));
        }

        // Apply Rounding before the category and range checks
        p.roundPrice();

        // 3. Category change for Premium Electronics
        if (wasElectronics && p.getPrice().compareTo(new BigDecimal("500.00")) > 0) {
            p.setCategory("Premium Electronics");
        }

        // 4. Calculate and set the PriceRange field
        p.setPriceRange(determinePriceRange(p.getPrice()));
    }

    // Helper method to determine the price range based on the final rounded price.
    private String determinePriceRange(BigDecimal price) {
        BigDecimal ten = new BigDecimal("10.00");
        BigDecimal hundred = new BigDecimal("100.00");
        BigDecimal fiveHundred = new BigDecimal("500.00");

        if (price.compareTo(ten) <= 0) {
            return "Low";
        } else if (price.compareTo(hundred) <= 0) {
            return "Medium";
        } else if (price.compareTo(fiveHundred) <= 0) {
            return "High";
        } else {
            return "Premium";
        }
    }
}
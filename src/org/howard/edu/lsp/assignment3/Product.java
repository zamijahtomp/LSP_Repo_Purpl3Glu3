package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a product with encapsulated data and formatting logic.
 * This class handles the "Data" part of the ETL process.
 */
public class Product {
    private int productId;
    private String name;
    private BigDecimal price;
    private String category;
    private String priceRange;

    /**
     * Constructor to initialize a Product object.
     */
    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = BigDecimal.valueOf(price); // Using BigDecimal for financial accuracy
        this.category = category;
    }

    /**
     * Requirement: Round-half-up to exactly two decimal places.
     * This uses the final rounded price for spec compliance.
     */
    public void roundPrice() {
        this.price = this.price.setScale(2, RoundingMode.HALF_UP);
    }

    // Getters and Setters - This is "Encapsulation"
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getPriceRange() { return priceRange; }
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }

    /**
     * Formats the product back into a CSV line for the Load step.
     */
    @Override
    public String toString() {
        return productId + "," + name + "," + String.format("%.2f", price) + "," + category + "," + priceRange;
    }
}
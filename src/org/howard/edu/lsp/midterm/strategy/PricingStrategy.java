package org.howard.edu.lsp.midterm.strategy;

/**
 * Interface for defining a pricing strategy.
 */
public interface PricingStrategy {
    /**
     * Calculates the price based on a specific strategy.
     * @param price the original price
     * @return the calculated price after discounts
     */
    double calculate(double price);
}

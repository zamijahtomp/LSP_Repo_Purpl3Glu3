package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for Regular customers providing no discount.
 */
public class RegularStrategy implements PricingStrategy {
    @Override
    public double calculate(double price) {
        return price;
    }
}
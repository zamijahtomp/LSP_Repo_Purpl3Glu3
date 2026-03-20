package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for VIP customers providing a 20% discount.
 */
public class VIPStrategy implements PricingStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.80;
    }
}

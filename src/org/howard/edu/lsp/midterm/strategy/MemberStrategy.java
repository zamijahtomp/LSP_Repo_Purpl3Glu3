package org.howard.edu.lsp.midterm.strategy;

/**
 * Strategy for Members providing a 10% discount.
 */
public class MemberStrategy implements PricingStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.90;
    }
}
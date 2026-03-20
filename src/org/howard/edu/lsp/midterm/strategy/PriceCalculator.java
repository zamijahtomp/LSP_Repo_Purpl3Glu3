package org.howard.edu.lsp.midterm.strategy;

/**
 * Context class that uses a PricingStrategy to calculate final prices.
 */
public class PriceCalculator {
    private PricingStrategy strategy;

    /**
     * Sets the current pricing strategy.
     * @param strategy the strategy to be used
     */
    public void setStrategy(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Executes the calculation using the assigned strategy.
     * @param price the base price
     * @return the final calculated price
     */
    public double calculatePrice(double price) {
        return strategy.calculate(price);
    }
}
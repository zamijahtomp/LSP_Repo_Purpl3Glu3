package org.howard.edu.lsp.midterm.strategy;

/**
 * Driver program to demonstrate the Strategy Pattern implementation.
 */
public class Driver {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();
        double amount = 100.0;

        calculator.setStrategy(new RegularStrategy());
        System.out.println("REGULAR: " + calculator.calculatePrice(amount));

        calculator.setStrategy(new MemberStrategy());
        System.out.println("MEMBER: " + calculator.calculatePrice(amount));

        calculator.setStrategy(new VIPStrategy());
        System.out.println("VIP: " + calculator.calculatePrice(amount));

        calculator.setStrategy(new HolidayStrategy());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(amount));
    }
}
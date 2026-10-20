package com.pluralsight;

public class RentalCarCalculator {
    public static void main(String[] args) {

        int rentalDays = 2;
        double dailyRate = 29.99;

        double basicCost = rentalDays * dailyRate;

        System.out.printf("Basic rental: $%.2f%n", basicCost);
    }
}

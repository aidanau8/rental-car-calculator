
package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get rental information
        System.out.print("Enter pickup date (MM/DD/YYYY): ");
        String pickupDate = scanner.nextLine();

        System.out.print("Enter number of rental days: ");
        int rentalDays = Integer.parseInt(scanner.nextLine());

        System.out.print("Do you want a toll tag ($3.95/day)? (yes/no): ");
        String tollTagAnswer = scanner.nextLine();

        System.out.print("Do you want GPS ($2.95/day)? (yes/no): ");
        String gpsAnswer = scanner.nextLine();

        System.out.print("Do you want roadside assistance ($3.95/day)? (yes/no): ");
        String roadsideAnswer = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = Integer.parseInt(scanner.nextLine());

        // Check numeric input
        if (rentalDays <= 0 || age <= 0) {
            System.out.println("Rental days and age must be positive.");
            scanner.close();
            return;
        }

        // Calculate basic rental cost
        double dailyRate = 29.99;
        double basicCost = rentalDays * dailyRate;

        // Calculate selected options
        double optionsCost = 0;

        if (tollTagAnswer.equalsIgnoreCase("yes")) {
            optionsCost += rentalDays * 3.95;
        }

        if (gpsAnswer.equalsIgnoreCase("yes")) {
            optionsCost += rentalDays * 2.95;
        }

        if (roadsideAnswer.equalsIgnoreCase("yes")) {
            optionsCost += rentalDays * 3.95;
        }

        // Calculate surcharge for drivers under 25
        double underageSurcharge = 0;

        if (age < 25) {
            underageSurcharge = basicCost * 0.30;
        }

        // Calculate total
        double totalCost = basicCost + optionsCost + underageSurcharge;

        // Display rental summary
        System.out.println();
        System.out.println("Rental Summary");
        System.out.printf("Pickup date: %s%n", pickupDate);
        System.out.printf("Rental days: %d%n", rentalDays);
        System.out.printf("Basic rental: $%.2f%n", basicCost);
        System.out.printf("Options cost: $%.2f%n", optionsCost);
        System.out.printf("Underage surcharge: $%.2f%n", underageSurcharge);
        System.out.printf("Total cost: $%.2f%n", totalCost);

        scanner.close();
    }
}
package org.example;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);
    public void displayMenu() {

        System.out.println("\n--- Student Management Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Find Student");
        System.out.println("4. View All Students");
        System.out.println("5. Update Student");
        System.out.println("6. Clear All Students");
        System.out.println("0. Exit");
    }

    public int getIntInput(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
    public String SureToClear() {

        System.out.println(
                "Are you sure to clear the list that stores all students?"
        );
        System.out.println("Enter yes or no: ");
        String input = scanner.nextLine().trim();
        return input;
    }

}

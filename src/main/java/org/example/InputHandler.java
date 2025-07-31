package org.example;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    //Menu
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

    //Get string and Int Input

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

    //Email

    public String getEmailInput(String message) {
        while (true) {
            System.out.print(message);
            String Email = scanner.nextLine().trim();
            if (isValidEmail(Email)) {
                return Email;
            }else System.out.println("Please enter a valid email address.");

        }
    }
    private boolean isValidEmail(String email) {
        int atPos = email.indexOf('@');
        int dotPos = email.lastIndexOf('.');
        return atPos > 0 && dotPos > atPos;
    }

    //Age
    public int getAgeInput(String message) {
        while (true) {
            System.out.print(message);
            int age = Integer.parseInt(scanner.nextLine().trim());
            if (isValidAge(age)) {
                return age;
            }else System.out.println("Please enter a valid Student Age: ");

        }
    }

    private boolean isValidAge(int age) {

        return age >= 15 && age <= 100;

    }



   //User Response if Sure
    public String SureToClear() {

        System.out.println(
                "Are you sure to clear the list that stores all students?"
        );
        System.out.println("Enter yes or no: ");
        String input = scanner.nextLine().trim();
        return input;
    }



}

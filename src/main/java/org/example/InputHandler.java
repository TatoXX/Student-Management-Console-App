package org.example;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    //Menu Display
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

    //Name input
    public String getNameInput(String message) {
        while (true) {
            System.out.print(message);
            String name = scanner.nextLine().trim();
            if (isValidName(name)) {
                return name;
            } else {
                System.out.println("Please enter a valid name.");
            }
        }


    }

    public static boolean isValidName(String name) {
        if (name == null) return false;
        if(name.length()<2 || name.length()>30) {
            return false;
        }else return name.matches("^[A-Z][a-zA-Z]*(?:[ '-][a-zA-Z]+)*$");
    }


    //Email Input

    public String getEmailInput(String message) {
        while (true) {
            System.out.print(message);
            String Email = scanner.nextLine().trim();
            if (isValidEmail(Email)) {
                return Email;
            }else System.out.println("Please enter a valid email address.");

        }
    }
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty() || email.length() > 254) {
            return false;
        }

        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        return email.matches(emailRegex);
    }

    //Age Input
    public int getAgeInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                int age = Integer.parseInt(input);
                if (isValidAge(age)) {
                    return age;
                } else {
                    System.out.println("Age must be between 15 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer number.");
            }
        }
    }
    public static boolean isValidAge(int age) {

        return age >= 15 && age <= 100;
    }

    //Course input
    public String getCourseInput(String message) {
        while (true) {
            String course = getStringInput(message);
            if (isValidCourse(course)) {
                return course;
            } else {
                System.out.println("Please enter a valid course name (2-50 characters).");
            }
        }
    }
    public static boolean isValidCourse(String course) {
        return course != null &&
                !course.trim().isEmpty() &&
                course.trim().length() >= 2 &&
                course.trim().length() <= 50;
    }




   //User Response if Sure
    public String SureToClear() {

        System.out.println(
                "Are you sure to clear the list that stores all students?"
        );
        System.out.println("Enter yes or no: ");
        return scanner.nextLine().trim();
    }



}

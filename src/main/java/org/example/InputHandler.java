package org.example;

import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private static List<String> availableCourses;

    static {
        try {
            // Read and parse JSON file
            String jsonContent = new String(Files.readAllBytes(Paths.get("Data/courses.json")));
            JsonObject jsonObject = JsonParser.parseString(jsonContent).getAsJsonObject();
            JsonArray jsonCourses = jsonObject.getAsJsonArray("availableCourses");

            // Convert JSON array to Java list
            availableCourses = new Gson().fromJson(jsonCourses, List.class);
        } catch (IOException | JsonParseException e) {
            System.err.println("Error loading course list: " + e.getMessage());
            availableCourses = List.of(); // fallback to empty list
        }
    }
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Courses:");
        for (String course : availableCourses) {
            System.out.println("- " + course);
        }
        while (true) {
            System.out.print(message);
            String course = scanner.nextLine().trim();
            if (isValidCourse(course)) {
                return course;
            } else {
                System.out.println("Please enter a valid course name from the list.");
            }
        }
    }

    public static boolean isValidCourse(String course) {
        for (String available : availableCourses) {
            if (available.equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    //ID

    public int getIDInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                int ID = Integer.parseInt(input);
                if (!isValidID(ID)) {
                    System.out.println("ID must be between 1 and 10000.");
                } else if (StudentManager.isIDTaken(ID)) {
                    System.out.println("This ID is already taken. Please choose a unique ID.");
                } else {
                    return ID;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer number.");
            }
        }
    }

    public static boolean isValidID(int ID) {
        return ID >= 1 && ID <= 10000;

    }


    public int getExistingID(String message) {
        System.out.print(message);
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int ID = Integer.parseInt(input);
                if (StudentManager.isIDTaken(ID)) {
                    System.out.println("Student found by ID: " + ID);
                    return ID;
                } else if (ID == 0) {
                    System.out.println("Returning...");
                    return ID;

                } else {
                    System.out.print("Please enter correct ID or Enter 0 to return to the main menu: ");
                }
            }catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer ID or 0 to return to the Main Menu: ");
            }

        }

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

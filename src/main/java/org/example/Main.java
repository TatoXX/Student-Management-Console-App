package org.example;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        InputHandler inputHandler = new InputHandler();

        while (true) {
            inputHandler.displayMenu();
            int choice = inputHandler.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> {
                    String name = inputHandler.getStringInput("Enter name: ");
                    int age = inputHandler.getIntInput("Enter age: ");
                    String email = inputHandler.getStringInput("Enter email: ");
                    String course = inputHandler.getStringInput("Enter course: ");
                    Student student = new Student(age, name, email, course );
                    manager.addStudent(student);
                    System.out.println("Student added successfully.");
                }
                case 2 -> {
                    int id = inputHandler.getIntInput("Enter student ID to delete: ");
                    manager.deleteStudentById(id);
                }
                case 3 -> {
                    int id = inputHandler.getIntInput("Enter student ID to find: ");
                    manager.findStudentById(id);
                }
                case 4 -> {
                    manager.getAllStudents();
                }
                case 5 -> {
                    int id = inputHandler.getIntInput("Enter student ID to update: ");
                    String name = inputHandler.getStringInput("Enter new name: ");
                    int age = inputHandler.getIntInput("Enter new age: ");
                    String email = inputHandler.getStringInput("Enter new email: ");
                    String course = inputHandler.getStringInput("Enter new course: ");
                    Student updated = new Student(age, name, email, course);
                    manager.updateStudent(id, updated);
                    System.out.println("Student updated successfully.");
                }
                case 6 -> {
                    manager.clearAll();
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


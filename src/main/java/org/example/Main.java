package org.example;

public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        InputHandler inputHandler = new InputHandler();

        //Load Students From Json
        System.out.println();
        manager.loadFromFile();


        while (true) {
            //Display Menu
            inputHandler.displayMenu();
            //User Choice
            int choice = inputHandler.getIntInput("Enter your choice: ");

            switch (choice) {
                //Add Student
                case 1 -> {
                    String name = inputHandler.getNameInput("Enter name: ");
                    int age = inputHandler.getAgeInput("Enter age: ");
                    String email = inputHandler.getEmailInput("Enter email: ");
                    String course = inputHandler.getCourseInput("Enter course: ");
                    Student student = new Student(age, name, email, course );
                    manager.addStudent(student);
                    System.out.println("Student added successfully.");
                    manager.saveToFile();
                }
                //Delete Student By ID
                case 2 -> {
                    int id = inputHandler.getIntInput("Enter student ID to delete: ");
                    manager.deleteStudentById(id);
                    manager.saveToFile();

                }
                //Find Student By ID
                case 3 -> {
                    int id = inputHandler.getIntInput("Enter student ID to find: ");
                    manager.findStudentById(id);
                }
                //Get all Students
                case 4 -> manager.getAllStudents();

                //Update Student By ID
                case 5 -> {
                    int id = inputHandler.getExistingID("Enter student ID to update: ");
                    if(id == 0){
                        break;
                    }
                    String name = inputHandler.getNameInput("Enter new name: ");
                    int age = inputHandler.getAgeInput("Enter new age: ");
                    String email = inputHandler.getEmailInput("Enter new email: ");
                    String course = inputHandler.getCourseInput("Enter new course: ");
                    Student updated = new Student(age, name, email, course);
                    manager.updateStudent(id, updated);
                    manager.saveToFile();
                    System.out.println("Student updated successfully.");
                }
                //Clear All Students
                case 6 -> {
                    manager.clearAll();
                    manager.saveToFile();
                }
                //Exit
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                //Invalid Choice
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


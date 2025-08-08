package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StudentManager {
    //Added Students List
    private List<Student> students = new ArrayList<>();

    private static final Set<Integer> usedIDs = new HashSet<>();

    public static boolean isIDTaken(int id) {
        return usedIDs.contains(id);
    }

    //Add Student

    public void addStudent(Student student) {
        students.add(student);
        usedIDs.add(student.getId());
    }

    //Delete Student By ID

    public void deleteStudentById(int id) {
        Student deletedStudent = null;
        for (Student student : students) {
            if(student.getId() == id ){
                deletedStudent = student;
                usedIDs.remove(student.getId());

                break;

            }
        }
        if (deletedStudent != null) {
            students.remove(deletedStudent);
            System.out.println("Student with id " + id + " deleted successfully.");
        } else {
            System.out.println("Provided Id is wrong or student is already deleted.");
        }


    }

    //Find Student By ID

    public Student findStudentById(int id) {
        Student foundStudent = null;
        for (Student student : students) {
            if (student.getId() == id) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            System.out.println(foundStudent);


        } else {
            System.out.println("Student with id " + id + " not found.");

        }
        return foundStudent;
    }

    //Get All Students

    public void getAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    //Update Student with ID

    public void updateStudent(int id, Student updatedStudent ) {
        Student foundstudent = null;
        for (Student student : students) {
            if (student.getId() == id) {
                foundstudent = student;
                break;

            }
        }
        if (foundstudent != null) {
            foundstudent.setAge(updatedStudent.getAge());
            foundstudent.setName(updatedStudent.getName());
            foundstudent.setEmail(updatedStudent.getEmail());
            foundstudent.setCourse(updatedStudent.getCourse());
        }else{
            System.out.println("Student with id " + id + " not found.");
        }

    }


    //Clear Students

    public void clearAll(){
        InputHandler inputHandler = new InputHandler();


       while (true) {

           String input = inputHandler.SureToClear();
           if (input.equalsIgnoreCase("yes")) {
               students.clear();
               System.out.println("Successfully cleared.");
               break;

           } else if (input.equalsIgnoreCase("no")) {
               System.out.println("Operation stopped");
               break;

           } else {
               System.out.println("Invalid input");

           }

       }

    }

    //Json filename
    private final String filename = "data/students.json";

    // Save students to JSON file
    public void saveToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(students, writer);
            System.out.println("Students saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save students: " + e.getMessage());
        }
    }

    // Load students from JSON file
    public void loadFromFile() {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No saved data found, starting fresh.");
            return;
        }

        Gson gson = new Gson();
        try (Reader reader = new FileReader(filename)) {
            Type studentListType = new TypeToken<List<Student>>(){}.getType();
            students = gson.fromJson(reader, studentListType);
            int maxId = students.stream()
                    .mapToInt(Student::getId)
                    .max()
                    .orElse(0);
            Student.setNextId(maxId + 1);
            System.out.println("Students loaded successfully.");
        } catch (IOException e) {
            System.out.println("Failed to load students: " + e.getMessage());
        }
    }


    // Add a getter to access students for display etc.
    public List<Student> getStudents() {
        return students;
    }



}

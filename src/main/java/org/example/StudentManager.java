package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    List<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) {
        students.add(student);
    }


    public void deleteStudentById(int id) {
        Student deletedStudent = null;
        for (Student student : students) {
            if(student.getId() == id ){
                deletedStudent = student;
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

    public void findStudentById(int id) {
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
    }

    public void getAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void updateStudent(int id, Student updatedStudent ) {
        Student findstudent = null;
        for (Student student : students) {
            if (student.getId() == id) {
                findstudent = student;
                break;

            }
        }
        if (findstudent != null) {
            findstudent.setAge(updatedStudent.getAge());
            findstudent.setName(updatedStudent.getName());
            findstudent.setEmail(updatedStudent.getEmail());
            findstudent.setCourse(updatedStudent.getCourse());
        }else{
            System.out.println("Student with id " + id + " not found.");
        }

    }
    public void clearAll(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "Are you sure to clear the list that stores all students?"
        );
        System.out.println("Enter yes or no: ");
        String input = scanner.nextLine().trim();

       while (true) {
           if (input.equalsIgnoreCase("yes")) {
               students.clear();
               System.out.println("Successfully cleared.");
               break;

           } else if (input.equalsIgnoreCase("no")) {
               System.out.println("Operation stopped");
               break;

           } else {
               System.out.println("Invalid input");
               System.out.println("Are you sure that you want to clear student list? Please Enter yes or no: ");
           }

       }

    }



}

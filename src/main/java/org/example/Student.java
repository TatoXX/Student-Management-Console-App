package org.example;

public class Student {

    private int age;
    private String name;
    private int id;
    private String email;
    private String course;
    private static int nextId = 1;

    //Student constructor

    public Student(int age, String name, String email, String course) {
        this.age = age;
        this.name = name;
        this.email = email;
        this.course = course;
        this.id = nextId++;
    }


    //Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public static void setNextId(int id) {
        nextId = id;
    }

    //toString Method

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}

package org.example;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentManagerTest {

    private StudentManager manager;
    private Student student1;
    private Student student2;


    @BeforeEach
    void setUp() {
        manager = new StudentManager();
        student1 = new Student(20, "Alice", "alice@example.com", "Math");
        student2 = new Student(22, "Bob", "bob@example.com", "Physics");
        manager.addStudent(student1);
        manager.addStudent(student2);
    }

    @AfterEach
    void tearDown() {
        // Clean up the saved file if exists
        File file = new File("data/students.json");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testAddStudent() {
        Student student = new Student(19, "Charlie", "charlie@example.com", "Biology");
        manager.addStudent(student);

        List<Student> students = manager.getStudents();
        assertTrue(students.contains(student));
    }

    @Test
    void testDeleteStudentById() {
        int idToDelete = student1.getId();
        manager.deleteStudentById(idToDelete);

        assertNull(manager.findStudentById(idToDelete));
    }

    @Test
    void testFindStudentByIdFound() {
        int id = student2.getId();
        Student found = manager.findStudentById(id);
        assertNotNull(found);
        assertEquals(student2.getName(), found.getName());
    }

    @Test
    void testFindStudentByIdNotFound() {
        assertNull(manager.findStudentById(-999));
    }

    @Test
    void testUpdateStudent() {
        int id = student1.getId();
        Student updated = new Student(21, "Alice Updated", "newalice@example.com", "CS");
        manager.updateStudent(id, updated);

        Student retrieved = manager.findStudentById(id);
        assertEquals("Alice Updated", retrieved.getName());
        assertEquals("newalice@example.com", retrieved.getEmail());
        assertEquals("CS", retrieved.getCourse());
        assertEquals(21, retrieved.getAge());
    }

    @Test
    void testClearAllStudents() {
        manager.getStudents().clear();  // simulate "yes" input manually
        assertTrue(manager.getStudents().isEmpty());
    }

    @Test
    void testSaveToFileAndLoadFromFile() {
        manager.saveToFile();

        StudentManager newManager = new StudentManager();
        newManager.loadFromFile();

        List<Student> loadedStudents = newManager.getStudents();
        assertEquals(2, loadedStudents.size());
        assertEquals(student1.getName(), loadedStudents.get(0).getName());
        assertEquals(student2.getEmail(), loadedStudents.get(1).getEmail());
    }

    @Test
    void testGetAllStudentsReturnsCorrectList() {
        List<Student> students = manager.getStudents();
        assertEquals(2, students.size());
        assertEquals(student1.getName(), students.get(0).getName());
        assertEquals(student2.getName(), students.get(1).getName());
    }
}

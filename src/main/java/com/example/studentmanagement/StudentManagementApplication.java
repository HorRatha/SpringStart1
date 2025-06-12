package com.example.studentmanagement;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Spring Boot Student Management System ===\n");

        // Test 1: Select All Students
        System.out.println("1. Testing selectAllStudents():");
        List<Student> allStudents = studentService.selectAllStudents();
        allStudents.forEach(System.out::println);
        System.out.println("Total students: " + studentService.getStudentCount() + "\n");

        // Test 2: Select Student by ID
        System.out.println("2. Testing selectStudentById(5L):");
        Optional<Student> studentById = studentService.selectStudentById(5L);
        if (studentById.isPresent()) {
            System.out.println("Found: " + studentById.get());
        } else {
            System.out.println("Student not found");
        }
        System.out.println();

        // Test 3: Insert New Student
        System.out.println("3. Testing insertStudent():");
        Student newStudent = new Student(null, "Alex Thompson", "Male", 86.5);
        Student insertedStudent = studentService.insertStudent(newStudent);
        System.out.println("Inserted: " + insertedStudent);
        System.out.println("Total students after insert: " + studentService.getStudentCount() + "\n");

        // Test 4: Update Student by ID
        System.out.println("4. Testing updateStudentById(1L):");
        Student updatedInfo = new Student(null, "John Doe Updated", "Male", 95.0);
        Optional<Student> updatedStudent = studentService.updateStudentById(1L, updatedInfo);
        if (updatedStudent.isPresent()) {
            System.out.println("Updated: " + updatedStudent.get());
        } else {
            System.out.println("Student not found for update");
        }
        System.out.println();

        // Test 5: Delete Student by ID
        System.out.println("5. Testing deleteStudentById(10L):");
        boolean deleted = studentService.deleteStudentById(10L);
        System.out.println("Deleted: " + deleted);
        System.out.println("Total students after delete: " + studentService.getStudentCount() + "\n");

        // Test 6: Final list of all students
        System.out.println("6. Final list of all students:");
        List<Student> finalList = studentService.selectAllStudents();
        finalList.forEach(System.out::println);

        System.out.println("\n=== Testing Complete ===");
    }
}
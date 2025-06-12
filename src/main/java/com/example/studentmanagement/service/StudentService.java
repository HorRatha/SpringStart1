package com.example.studentmanagement.service;


import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.InMemoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final InMemoryDatabase database;

    @Autowired
    public StudentService(InMemoryDatabase database) {
        this.database = database;
    }

    // Insert a new student
    public Student insertStudent(Student student) {
        // Generate new ID
        Long newId = database.getStudents().stream()
                .mapToLong(Student::getId)
                .max()
                .orElse(0L) + 1;

        student.setId(newId);
        database.getStudents().add(student);
        return student;
    }

    // Select all students
    public List<Student> selectAllStudents() {
        return database.getStudents();
    }

    // Select student by ID
    public Optional<Student> selectStudentById(Long id) {
        return database.getStudents().stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    // Update student by ID
    public Optional<Student> updateStudentById(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = selectStudentById(id);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setFullName(updatedStudent.getFullName());
            student.setGender(updatedStudent.getGender());
            student.setScore(updatedStudent.getScore());
            return Optional.of(student);
        }

        return Optional.empty();
    }

    // Delete student by ID
    public boolean deleteStudentById(Long id) {
        return database.getStudents().removeIf(student -> student.getId().equals(id));
    }

    // Get total count of students
    public int getStudentCount() {
        return database.getStudents().size();
    }
}
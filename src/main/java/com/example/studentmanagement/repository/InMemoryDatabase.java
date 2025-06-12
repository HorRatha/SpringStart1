package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryDatabase {
    private List<Student> students;

    public InMemoryDatabase() {
        this.students = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        students.add(new Student(1L, "John Doe", "Male", 85.5));
        students.add(new Student(2L, "Jane Smith", "Female", 92.0));
        students.add(new Student(3L, "Michael Johnson", "Male", 78.5));
        students.add(new Student(4L, "Emily Davis", "Female", 88.0));
        students.add(new Student(5L, "David Wilson", "Male", 91.5));
        students.add(new Student(6L, "Sarah Brown", "Female", 79.0));
        students.add(new Student(7L, "James Taylor", "Male", 84.5));
        students.add(new Student(8L, "Lisa Anderson", "Female", 93.5));
        students.add(new Student(9L, "Robert Martinez", "Male", 87.0));
        students.add(new Student(10L, "Jennifer Garcia", "Female", 90.0));
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
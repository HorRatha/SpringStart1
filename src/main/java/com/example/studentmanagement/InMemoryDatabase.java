package com.example.studentmanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InMemoryDatabase {

    @Bean("studentList1")
    public List<Student> studentList1() {
        return new ArrayList<>(List.of(
                new Student(1, "KOKO", "Male", 80)

        ));
    }

    @Bean("studentList2")
    public List<Student> studentList2() {
        return new ArrayList<>(List.of(
                new Student(4, "KAKA", "Female", 25)
        ));
    }
}
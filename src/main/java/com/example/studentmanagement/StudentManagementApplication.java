package com.example.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }


    @Autowired
    private InMemoryDatabase inMemoryDatabase;

    @Override
    public void run(String... args) {
        inMemoryDatabase.studentList1();
    }
}
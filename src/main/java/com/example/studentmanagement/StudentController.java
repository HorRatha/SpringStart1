package com.example.studentmanagement;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Resource(name = "studentList1")
    private List<Student> studentList;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/add")
    public void addStudent() {
        Student student = new Student(6, "New Student", "Male", 68);
        studentList.add(student);
    }
}

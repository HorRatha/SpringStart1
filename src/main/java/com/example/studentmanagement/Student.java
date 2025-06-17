package com.example.studentmanagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Student {
    private Integer id;
    private String fullName;
    private String gender;
    private double score;

    public Student(Integer id, String fullName, String gender, double score) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student details: [" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ']';
    }
}

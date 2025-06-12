package com.example.studentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Data // Generates getters, setters, equals, hashCode, and toString
@NoArgsConstructor // Generates no-argument constructor
@AllArgsConstructor // Generates constructor with all fields
@Builder // Generates builder pattern methods
@ToString // Custom toString method
public class Student {

    private Long id;
    private String fullName;
    private String gender;
    private Double score;

    // Custom constructor without ID (for new students)
    public Student(String fullName, String gender, Double score) {
        this.fullName = fullName;
        this.gender = gender;
        this.score = score;
    }

    // Custom validation methods
    public boolean isValidScore() {
        return score != null && score >= 0.0 && score <= 100.0;
    }

    public boolean hasValidData() {
        return fullName != null && !fullName.trim().isEmpty() &&
                gender != null && !gender.trim().isEmpty() &&
                isValidScore();
    }

    // Helper method for grade calculation
    public String getGrade() {
        if (score == null) return "N/A";
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
}
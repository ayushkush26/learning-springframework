package com.cdac;

public class StudentService {

    private Student student;

    // constructor injection
    public StudentService(Student student) {
        this.student = student;
    }

    public void registerStudent() {
        student.display();
    }
}


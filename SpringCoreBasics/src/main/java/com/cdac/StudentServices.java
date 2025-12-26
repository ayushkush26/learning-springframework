package com.cdac;

public class StudentServices {

    private Student student;  

    // setter injection
    public void setStudent(Student student) {
        this.student = student;
    }

    public void showStudentDetails() {
        student.display();
    }
}





package com.cdac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentRest")
public class StudentController {

    private List<Student> stu = new ArrayList<>();
    
    
    // ADD Student
    
    @PostMapping
    public String addStudent(@RequestBody Student student) {
    	stu.add(student);
    	return "Student Details Added!";
    }
    
    // Add ALL Student
    
    @PostMapping("/list")
    public String addMultiStudent(@RequestBody List<Student> student) {
    	stu.addAll(student);
    	return "Student Details Added!";
    }
    
    // View Student 
    
    @GetMapping
    public List<Student> viewStudent(){
    	return stu;
    }
    
    // Search Student by ID 
    
    @GetMapping("/{id}")
    public Student getByID(@PathVariable int id) {
    	for(Student s : stu) {
    		if(s.getId()==id) {
    			return s;
    		}
    	}
    	return null;
    }
    
    // Update Student Details with Id 
    
    @PutMapping("/{id}")
    public String updateStudents(@PathVariable int id , @RequestBody Student updateStudent) {
    	for(Student s : stu) {
    		if(s.getId() == id) {
       		 	s.setName(updateStudent.getName());
       		 	s.setCourse(updateStudent.getCourse());
       		 	return "Student Details Updated!";
       		}
    	}
    	return "Student Not Found!";
    }
    
    // Delete Student
    
    @DeleteMapping("/{id}")
    public String deleteStudents(@PathVariable int id) {
    	for (int i = 0; i < stu.size(); i++) {
            if (stu.get(i).getId() == id) {
                stu.remove(i);
                return "Student Deleted Successfully!";
            }
        }
		return "Student Not Found!";
    }
  
}

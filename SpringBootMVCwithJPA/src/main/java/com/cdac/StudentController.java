package com.cdac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Show registration page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("student", new Student());              // form object
        return "register";
    }

    // Handle form submission
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute("student") Student student,Model model) {
        studentRepository.save(student);
        model.addAttribute("student",studentRepository.findAll());
        return "view";  
    }
}

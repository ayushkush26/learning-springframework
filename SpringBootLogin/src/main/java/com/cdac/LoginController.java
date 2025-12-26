package com.cdac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Show Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";   // login.html
    }

    // Handle Login Form Submission
    @PostMapping("/login")
    public String processLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        if ("Ayush".equals(username) && "Ayush1234".equals(password)) {
            model.addAttribute("user", username);
            return "welcome";   // welcome.html
        } 
        else {
            model.addAttribute("error", "Invalid Username or Password!");
            return "login";     // back to login.html
        }
    }
}

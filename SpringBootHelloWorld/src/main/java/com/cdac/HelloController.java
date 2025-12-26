package com.cdac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String Hello(Model model) {  
		String message = "Hello Ayush!";
		model.addAttribute("msg",message);
		return "hello";     
		
	}
}

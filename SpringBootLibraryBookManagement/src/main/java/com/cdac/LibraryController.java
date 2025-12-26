package com.cdac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibraryController {
	private final LibraryDAO libraryDAO;
	
	public LibraryController(LibraryDAO libraryDAO) {
		this.libraryDAO = libraryDAO;
		
	}
	
	@GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Book book,
                                  Model model) {
    	libraryDAO.save(book);
        model.addAttribute("books", libraryDAO.viewAll());
        return "view";
    }
    
    
}

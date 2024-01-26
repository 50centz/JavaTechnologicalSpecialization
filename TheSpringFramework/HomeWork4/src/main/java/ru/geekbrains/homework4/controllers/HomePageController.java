package ru.geekbrains.homework4.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.homework4.model.Book;
import ru.geekbrains.homework4.services.LibraryService;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomePageController {

    private LibraryService libraryService;

    @GetMapping()
    public String getHomePage(Model model){
        model.addAttribute("number", 4);
        model.addAttribute("books", libraryService.getAllBooks());
        return "index.html";
    }

    @GetMapping("/bookaddlibrary")
    public String addBook(){
        return "create-books.html";
    }

    @PostMapping("/bookaddlibrary")
    public String addBook(Book book){
        libraryService.addBook(book);
        return "redirect:/";
    }
}

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

  private BookRepository bookRepo;

  public BooksController(BookRepository bookRepo) {
    this.bookRepo = bookRepo;
  }
  
  @GetMapping
  public String listBooks(Model model) {
    model.addAttribute("books", bookRepo.findAll());
    return "list";
  }
  
  @GetMapping("/{id}")
  public String bookDetail(@PathVariable("id") Book book, Model model) {
    model.addAttribute(book);
    return "detail";
  }
}

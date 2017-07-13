package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BooksControllerTest {

  @Autowired
  MockMvc mockMvc;
  
  @MockBean
  BookRepository bookRepo;

  private List<Book> books;
  
  @Before
  public void setup() {
    books = Arrays.asList(
        new Book("0312152906", "Knitting with Dog Hair", "Kendall Crolius"),
        new Book("1594745250", "Crafting with Cat Hair", "Kaori Tsutaya"));
    
    when(bookRepo.findAll()).thenReturn(books);
    when(bookRepo.findOne(1L)).thenReturn(books.get(0));
    when(bookRepo.findOne(2L)).thenReturn(books.get(1));
  }
  
  @Test
  public void bookList() throws Exception {
    mockMvc
      .perform(get("/books"))
      .andExpect(view().name("list"))
      .andExpect(model().attribute("books", books));
  }
  
  @Test
  public void bookDetail() throws Exception {
    mockMvc
      .perform(get("/books/1"))
      .andExpect(view().name("detail"))
      .andExpect(model().attribute("book", books.get(0)));

    mockMvc
      .perform(get("/books/2"))
      .andExpect(view().name("detail"))
      .andExpect(model().attribute("book", books.get(1)));
  }
  
}

package edu.coursework.library.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    PlaneRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Book;

import edu.coursework.library.service.book.impls.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@RestController
@RequestMapping("api/book")
public class BookRestController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/get/all")
    public List<Book> getPlane() {
        return bookService.getAll();
    }

    @GetMapping("/get/{id}")
    public Book getById(@PathVariable("id") String id) {
        Book byId = bookService.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Book deleteById(@PathVariable("id") String id) {
        return bookService.delete(id);
    }

    @PostMapping("/create/")
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @PostMapping("/update/")
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @GetMapping("/get/amountOfBookCopies")
    public Object getNumOfSameBookInLibrary() {
        return bookService.getNumOfSameBookInLibrary();
    }

    @GetMapping("/get/getNumOfBooksInLibrary")
    public Object getNumOfBooksInLibrary() {
        return bookService.getNumOfBooksInLibrary();
    }

    @GetMapping("/get/getNumOfBooksInCartoteka")
    public Object getNumOfBooksInCartoteka() {
        return bookService.getNumOfBooksInCartoteka();
    }
}

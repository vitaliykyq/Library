package edu.coursework.library.controller.ui;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    BookUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.library.model.Author;
import edu.coursework.library.model.Book;
import edu.coursework.library.model.CardIndex;
import edu.coursework.library.model.PublishingHouse;
import edu.coursework.library.service.author.impls.AuthorServiceImpl;
import edu.coursework.library.service.book.impls.BookServiceImpl;
import edu.coursework.library.service.cardIndex.impls.CardIndexServiceImpl;
import edu.coursework.library.service.publishingHouse.impls.PublishingHouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/ui/book")
@Controller
public class BookUIController {

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    AuthorServiceImpl authorService;

    @Autowired
    PublishingHouseServiceImpl publishingHouseService;

    @Autowired
    CardIndexServiceImpl cardIndexService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Book> bookList = bookService.getAll();
        model.addAttribute("bookList", bookList);

        return "book/bookList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Book book = bookService.getById(id);
        model.addAttribute("book", book);

        List<Author> authorListId = authorService.getAll();
        model.addAttribute("authorListId", authorListId);

        List<PublishingHouse> publishingHouseListId = publishingHouseService.getAll();
        model.addAttribute("publishingHouseListId", publishingHouseListId);

        List<CardIndex> cardIndexListId = cardIndexService.getAll();
        model.addAttribute("cardIndexListId", cardIndexListId);
        return "book/updateBook";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Book book) {

        bookService.update(book);
        return "redirect:/ui/book/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        List<Author> authorListId = authorService.getAll();
        model.addAttribute("authorListId", authorListId);

        List<PublishingHouse> publishingHouseListId = publishingHouseService.getAll();
        model.addAttribute("publishingHouseListId", publishingHouseListId);

        List<CardIndex> cardIndexListId = cardIndexService.getAll();
        model.addAttribute("cardIndexListId", cardIndexListId);
        return "book/newBook";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("book") @RequestBody Book book) {
        model.addAttribute("book", bookService.create(book));
        return "redirect:/ui/book/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        bookService.delete(id);
        return "redirect:/ui/book/get/all";
    }
}

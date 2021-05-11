package edu.coursework.library.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.library.model.Author;
import edu.coursework.library.model.Book;
import edu.coursework.library.service.author.impls.AuthorServiceImpl;
import edu.coursework.library.service.book.impls.BookServiceImpl;
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

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);

        return "book/bookList";
    }

    @GetMapping("/showUpdateForm/{id}/{idAuthor}")
    public String showUpdateForm(@PathVariable (value="id") String id,
                                 @PathVariable (value="idAuthor") String idAuthor, Model model){
        Author author = authorService.getById(idAuthor);
        model.addAttribute("authors", author);

        Book book = bookService.getById(id);
        model.addAttribute("books", book);
        return "book/updateBook";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @ModelAttribute("employee") @RequestBody Book book,
                         @ModelAttribute("t") @RequestBody Author author) {

        bookService.update(book);
        authorService.update(book.getAuthor());
        return "redirect:/ui/book/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Book book = new Book();
        model.addAttribute("books", book);
        return "book/newBook";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Book book) {
        String name = book.getName();
        int useBook = book.getUseBook();
        String yearIssue = book.getYearIssue();
        int amount = book.getAmount();
        int price = book.getPrice();
        String edition = book.getEdition();
        int penaltyLoss = book.getPenaltyLoss();
        book.setAuthor(authorService.getAll().get(Integer.parseInt(book.getAuthor().getId()) - 1));
        /*List<Plane> planes = planeService.getAll();*/

        if (name != null && name.length() > 0 && edition != null && edition.length() > 0
                && yearIssue != null && yearIssue.length() > 0
                && useBook > 0 && amount > 0 && price > 0 && penaltyLoss > 0) {
            model.addAttribute("books", bookService.create(book));
            return "redirect:/ui/book/get/all";
        }
        return "redirect:/ui/book/showNewForm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        bookService.delete(id);
        return "redirect:/ui/book/get/all";
    }
}

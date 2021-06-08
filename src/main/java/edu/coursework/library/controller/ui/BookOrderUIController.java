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
import edu.coursework.library.model.BookOrder;
import edu.coursework.library.model.Reader;
import edu.coursework.library.service.author.impls.AuthorServiceImpl;
import edu.coursework.library.service.book.impls.BookServiceImpl;
import edu.coursework.library.service.bookOrder.impls.BookOrderServiceImpl;
import edu.coursework.library.service.reader.impls.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/bookOrder")
@Controller
public class BookOrderUIController {

    @Autowired
    BookOrderServiceImpl bookOrderService;

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    ReaderServiceImpl readerService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<BookOrder> bookOrderList = bookOrderService.getAll();
        model.addAttribute("bookOrderList", bookOrderList);

        return "bookOrder/bookOrderList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        BookOrder bookOrder = bookOrderService.getById(id);
        model.addAttribute("bookOrder", bookOrder);

        List<Book> bookListId = bookService.getAll();
        model.addAttribute("bookListId", bookListId);

        List<Reader> readerListId = readerService.getAll();
        model.addAttribute("readerListId", readerListId);
        return "bookOrder/updateBookOrder";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("bookOrder") @RequestBody BookOrder bookOrder) {

        bookOrderService.update(bookOrder);
        return "redirect:/ui/bookOrder/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        BookOrder bookOrder = new BookOrder();
        model.addAttribute("bookOrder", bookOrder);

        List<Book> bookListId = bookService.getAll();
        model.addAttribute("bookListId", bookListId);

        List<Reader> readerListId = readerService.getAll();
        model.addAttribute("readerListId", readerListId);
        return "bookOrder/newBookOrder";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("bookOrder") @RequestBody BookOrder bookOrder) {
        model.addAttribute("bookOrder", bookOrderService.create(bookOrder));
        return "redirect:/ui/bookOrder/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        bookOrderService.delete(id);
        return "redirect:/ui/bookOrder/get/all";
    }
}

package edu.coursework.library.controller.ui;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    TakenBookUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.library.model.Author;
import edu.coursework.library.model.Book;
import edu.coursework.library.model.Fine;
import edu.coursework.library.model.TakenBook;
import edu.coursework.library.service.book.impls.BookServiceImpl;
import edu.coursework.library.service.fine.impls.FineServiceImpl;
import edu.coursework.library.service.takenBook.impls.TakenBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/takenBook")
@Controller
public class TakenBookUIController {

    @Autowired
    TakenBookServiceImpl takenBookService;

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    FineServiceImpl fineService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<TakenBook> takenBookList = takenBookService.getAll();
        model.addAttribute("takenBookList", takenBookList);

        return "takenBook/takenBookList";
    }

    @GetMapping("/showUpdateForm/{id}/{idAuthor}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        TakenBook takenBook = takenBookService.getById(id);
        model.addAttribute("takenBook", takenBook);

        List<Book> bookListId = bookService.getAll();
        model.addAttribute("bookListId", bookListId);

        List<Fine> fineListId = fineService.getAll();
        model.addAttribute("fineListId", fineListId);
        return "takenBook/updateTakenBook";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("takenBook") @RequestBody TakenBook takenBook) {

        takenBookService.update(takenBook);
        return "redirect:/ui/takenBook/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        TakenBook takenBook = new TakenBook();
        model.addAttribute("takenBook", takenBook);

        List<Book> bookListId = bookService.getAll();
        model.addAttribute("bookListId", bookListId);

        List<Fine> fineListId = fineService.getAll();
        model.addAttribute("fineListId", fineListId);
        return "takenBook/newTakenBook";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("takenBook") @RequestBody TakenBook takenBook) {
        model.addAttribute("takenBook", takenBookService.create(takenBook));
        return "redirect:/ui/takenBook/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        takenBookService.delete(id);
        return "redirect:/ui/takenBook/get/all";
    }
}

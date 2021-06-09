package edu.coursework.library.controller.ui;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    CardIndexUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.library.model.Book;
import edu.coursework.library.model.CardIndex;
import edu.coursework.library.service.author.impls.AuthorServiceImpl;
import edu.coursework.library.service.book.impls.BookServiceImpl;
import edu.coursework.library.service.cardIndex.impls.CardIndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/cardIndex")
@Controller
public class CardIndexUIController {

    @Autowired
    CardIndexServiceImpl cardIndexService;

    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<CardIndex> cardIndexList = cardIndexService.getAll();
        model.addAttribute("cardIndexList", cardIndexList);

        return "cardIndex/cardIndexList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model) {
        CardIndex cardIndex = cardIndexService.getById(id);
        model.addAttribute("cardIndex", cardIndex);

        List<Book> bookListId = bookService.getAll();
        model.addAttribute("bookListId", bookListId);
        return "cardIndex/updateCardIndex";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("cardIndex") @RequestBody CardIndex cardIndex) {
        cardIndexService.update(cardIndex);
        return "redirect:/ui/cardIndex/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        CardIndex cardIndex = new CardIndex();
        model.addAttribute("cardIndex", cardIndex);

        List<Book> bookListId = bookService.getAll();
        model.addAttribute("bookListId", bookListId);
        return "cardIndex/newCardIndex";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("cardIndex") @RequestBody CardIndex cardIndex) {
        model.addAttribute("cardIndex", cardIndexService.create(cardIndex));
        return "redirect:/ui/cardIndex/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        cardIndexService.delete(id);
        return "redirect:/ui/cardIndex/get/all";
    }
}

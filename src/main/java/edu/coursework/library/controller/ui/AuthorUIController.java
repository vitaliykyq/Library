package edu.coursework.library.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    AuthorUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.library.model.Author;
import edu.coursework.library.service.author.impls.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/ui/author")
@Controller
public class AuthorUIController {

    @Autowired
    AuthorServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Author> authors = service.getAll();
        model.addAttribute("authors", authors);

        return "author/authorList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Author author = service.getById(id);
        model.addAttribute("authors",author);
        return "author/updateAuthor";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Author author = new Author();
        model.addAttribute("authors", author);
        return "author/newAuthor";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Author author) {
        String name = author.getName();
        String birth = author.getBirth();
        String death = author.getDeath();
        String country = author.getCountry();
        List<Author> authors = service.getAll();

        if (name != null && name.length() > 0
                && birth != null && birth.length() > 0
                && death != null && death.length() > 0
                && country != null && country.length() > 0) {
            model.addAttribute("authors", service.create(author));
            return "redirect:/ui/author/get/all";
        }
        return "redirect:/ui/author/showNewForm";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Author author) {

        service.update(author);
        return "redirect:/ui/author/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/author/get/all";
    }
}

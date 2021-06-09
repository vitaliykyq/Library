package edu.coursework.library.controller.ui;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PublishingHouseUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.library.model.Author;
import edu.coursework.library.model.Book;
import edu.coursework.library.model.PublishingHouse;
import edu.coursework.library.service.publishingHouse.impls.PublishingHouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/publishingHouse")
@Controller
public class PublishingHouseUIController {

    @Autowired
    PublishingHouseServiceImpl publishingHouseService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<PublishingHouse> publishingHouseList = publishingHouseService.getAll();
        model.addAttribute("publishingHouseList", publishingHouseList);

        return "publishingHouse/publishingHouseList";
    }

    @GetMapping("/showUpdateForm/{id}/{idAuthor}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        PublishingHouse publishingHouse = publishingHouseService.getById(id);
        model.addAttribute("publishingHouse", publishingHouse);
        return "publishingHouse/updatePublishingHouse";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("publishingHouse") @RequestBody PublishingHouse publishingHouse) {

        publishingHouseService.update(publishingHouse);
        return "redirect:/ui/publishingHouse/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        PublishingHouse publishingHouse = new PublishingHouse();
        model.addAttribute("publishingHouse", publishingHouse);
        return "publishingHouse/newPublishingHouse";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("publishingHouse") @RequestBody PublishingHouse publishingHouse) {
        model.addAttribute("publishingHouse", publishingHouseService.create(publishingHouse));
        return "redirect:/ui/publishingHouse/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        publishingHouseService.delete(id);
        return "redirect:/ui/publishingHouse/get/all";
    }
}

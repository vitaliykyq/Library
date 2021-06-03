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
import edu.coursework.library.model.Catalog;
import edu.coursework.library.model.Subscriber;
import edu.coursework.library.service.catalog.impls.CatalogServiceImpl;
import edu.coursework.library.service.subscriber.impls.SubscriberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/subscriber")
@Controller
public class SubscriberUIController {

    @Autowired
    SubscriberServiceImpl subscriberService;

    @Autowired
    CatalogServiceImpl catalogService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Subscriber> subscriberList = subscriberService.getAll();
        model.addAttribute("subscriberList", subscriberList);

        return "subscriber/subscriberList";
    }

    @GetMapping("/showUpdateForm/{id}/{idAuthor}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Subscriber subscriber = subscriberService.getById(id);
        model.addAttribute("subscriber", subscriber);

        List<Catalog> catalogListId = catalogService.getAll();
        model.addAttribute("catalogListId", catalogListId);
        return "subscriber/updateSubscriber";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("subscriber") @RequestBody Subscriber subscriber) {

        subscriberService.update(subscriber);
        return "redirect:/ui/subscriber/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Subscriber subscriber = new Subscriber();
        model.addAttribute("subscriber", subscriber);

        List<Catalog> catalogListId = catalogService.getAll();
        model.addAttribute("catalogListId", catalogListId);
        return "subscriber/newSubscriber";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("subscriber") @RequestBody Subscriber subscriber) {
        model.addAttribute("subscriber", subscriberService.create(subscriber));
        return "redirect:/ui/subscriber/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        subscriberService.delete(id);
        return "redirect:/ui/subscriber/get/all";
    }
}

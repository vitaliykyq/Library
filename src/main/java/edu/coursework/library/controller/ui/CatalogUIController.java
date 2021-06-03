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
import edu.coursework.library.model.CardIndex;
import edu.coursework.library.model.Catalog;
import edu.coursework.library.service.cardIndex.impls.CardIndexServiceImpl;
import edu.coursework.library.service.catalog.impls.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/catalog")
@Controller
public class CatalogUIController {

    @Autowired
    CatalogServiceImpl catalogService;

    @Autowired
    CardIndexServiceImpl cardIndexService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Catalog> catalogList = catalogService.getAll();
        model.addAttribute("catalogList", catalogList);

        return "catalog/catalogList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Catalog catalog = catalogService.getById(id);
        model.addAttribute("catalog", catalog);

        List<CardIndex> cardIndexListId = cardIndexService.getAll();
        model.addAttribute("cardIndexListId", cardIndexListId);
        return "catalog/updateCatalog";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("catalog") @RequestBody Catalog catalog) {

        catalogService.update(catalog);
        return "redirect:/ui/catalog/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Catalog catalog = new Catalog();
        model.addAttribute("catalog", catalog);

        List<CardIndex> cardIndexListId = cardIndexService.getAll();
        model.addAttribute("cardIndexListId", cardIndexListId);
        return "catalog/newCatalog";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("catalog") @RequestBody Catalog catalog) {
        model.addAttribute("catalog", catalogService.create(catalog));
        return "redirect:/ui/catalog/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        catalogService.delete(id);
        return "redirect:/ui/catalog/get/all";
    }
}

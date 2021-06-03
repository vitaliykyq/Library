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
import edu.coursework.library.model.Fine;
import edu.coursework.library.service.fine.impls.FineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/fine")
@Controller
public class FineUIController {

    @Autowired
    FineServiceImpl fineService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Fine> fineList = fineService.getAll();
        model.addAttribute("fineList", fineList);

        return "fine/fineList";
    }

    @GetMapping("/showUpdateForm/{id}/{idAuthor}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Fine fine = fineService.getById(id);
        model.addAttribute("fine", fine);
        return "fine/updateFine";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("fine") @RequestBody Fine fine) {

        fineService.update(fine);
        return "redirect:/ui/fine/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Fine fine = new Fine();
        model.addAttribute("fine", fine);
        return "fine/newFine";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("fine") @RequestBody Fine fine) {
        model.addAttribute("fine", fineService.create(fine));
        return "redirect:/ui/fine/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        fineService.delete(id);
        return "redirect:/ui/fine/get/all";
    }
}

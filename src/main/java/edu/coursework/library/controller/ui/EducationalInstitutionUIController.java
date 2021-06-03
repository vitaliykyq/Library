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
import edu.coursework.library.model.EducationalInstitution;
import edu.coursework.library.service.author.impls.AuthorServiceImpl;
import edu.coursework.library.service.educationalInstitution.impls.EducationalInstitutionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/educationalInstitution")
@Controller
public class EducationalInstitutionUIController {

    @Autowired
    EducationalInstitutionServiceImpl educationalInstitutionService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<EducationalInstitution> educationalInstitutionList = educationalInstitutionService.getAll();
        model.addAttribute("educationalInstitutionList", educationalInstitutionList);

        return "educationalInstitution/educationalInstitutionList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        EducationalInstitution educationalInstitution = educationalInstitutionService.getById(id);
        model.addAttribute("educationalInstitution", educationalInstitution);
        return "educationalInstitution/updateEducationalInstitution";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("educationalInstitution") @RequestBody EducationalInstitution educationalInstitution) {

        educationalInstitutionService.update(educationalInstitution);
        return "redirect:/ui/educationalInstitution/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        EducationalInstitution educationalInstitution = new EducationalInstitution();
        model.addAttribute("educationalInstitution", educationalInstitution);
        return "educationalInstitution/newEducationalInstitution";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("educationalInstitution") @RequestBody EducationalInstitution educationalInstitution) {
        model.addAttribute("educationalInstitution", educationalInstitutionService.create(educationalInstitution));
        return "redirect:/ui/educationalInstitution/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        educationalInstitutionService.delete(id);
        return "redirect:/ui/educationalInstitution/get/all";
    }
}

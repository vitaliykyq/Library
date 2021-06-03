package edu.coursework.library.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.library.model.Book;
import edu.coursework.library.model.EducationalInstitution;
import edu.coursework.library.model.Person;
import edu.coursework.library.service.educationalInstitution.impls.EducationalInstitutionServiceImpl;
import edu.coursework.library.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/person")
@Controller
public class PersonUIController {

    @Autowired
    PersonServiceImpl personService;

    @Autowired
    EducationalInstitutionServiceImpl educationalInstitutionService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Person> personList = personService.getAll();
        model.addAttribute("personList", personList);

        return "person/personList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Person person = personService.getById(id);
        model.addAttribute("person", person);

        List<EducationalInstitution> educationalInstitutionListId = educationalInstitutionService.getAll();
        model.addAttribute("educationalInstitutionListId", educationalInstitutionListId);
        return "person/updatePerson";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("person") @RequestBody Person person) {

        personService.update(person);
        return "redirect:/ui/person/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);

        List<EducationalInstitution> educationalInstitutionListId = educationalInstitutionService.getAll();
        model.addAttribute("educationalInstitutionListId", educationalInstitutionListId);
        return "person/newPerson";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("person") @RequestBody Person person) {
        model.addAttribute("person", personService.create(person));
        return "redirect:/ui/person/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        personService.delete(id);
        return "redirect:/ui/person/get/all";
    }
}

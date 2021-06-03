package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.Person;
import edu.coursework.library.service.person.impls.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/person")
public class PersonRestController {

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/get/all")
    public List<Person> getAdministrations(){
        return personService.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Person getById(@PathVariable("id") String id){ return personService.getById(id); }

    @GetMapping("/delete/{id}")
    public Person deleteById(@PathVariable("id") String id){
        return personService.delete(id);
    }

    @PostMapping("/create/")
    public Person create(@RequestBody Person person){ return personService.create(person); }

    @PostMapping ("/update/")
    public Person update(@RequestBody Person person){ return personService.update(person); }

}

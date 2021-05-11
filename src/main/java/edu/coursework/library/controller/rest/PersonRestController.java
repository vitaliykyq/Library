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
@RequestMapping("api/services")
public class PersonRestController {

    /*@Autowired
    PersonServiceImpl person;

    @GetMapping("/get/all")
    public List<Person> getAdministrations(){
        return person.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Person getById(@PathVariable("id") String id){ return person.getById(id); }

    @GetMapping("/delete/{id}")
    public Person deleteById(@PathVariable("id") String id){
        return person.delete(id);
    }

    @PostMapping("/create/")
    public Person create(@RequestBody Person _person){ return person.create(_person); }

    @PostMapping ("/update/")
    public Person update(@RequestBody Person _person){ return person.update(_person); }*/

}

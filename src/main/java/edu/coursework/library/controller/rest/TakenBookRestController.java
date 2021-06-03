package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.TakenBook;
import edu.coursework.library.service.takenBook.impls.TakenBookServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/services")
public class TakenBookRestController {

    @Autowired
    TakenBookServiceImpl person;

    @GetMapping("/get/all")
    public List<TakenBook> getAdministrations(){
        return person.getAll() ;
    }

    @GetMapping("/get/{id}")
    public TakenBook getById(@PathVariable("id") String id){ return person.getById(id); }

    @GetMapping("/delete/{id}")
    public TakenBook deleteById(@PathVariable("id") String id){
        return person.delete(id);
    }

    @PostMapping("/create/")
    public TakenBook create(@RequestBody TakenBook takenBook){ return person.create(takenBook); }

    @PostMapping ("/update/")
    public TakenBook update(@RequestBody TakenBook takenBook){ return person.update(takenBook); }

}

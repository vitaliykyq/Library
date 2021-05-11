package edu.coursework.library.controller.rest;

/*
    @author:    Vitaly
    @project:    Library
    @class:    AuthorRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Author;
import edu.coursework.library.service.author.impls.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorRestController {

    @Autowired
    AuthorServiceImpl service;

    @GetMapping("/get/all")
    public List<Author> getPlane(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Author getById(@PathVariable("id") String id){
        Author byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Author deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Author create(@RequestBody Author author){
        return service.create(author);
    }

    @PostMapping ("/update/")
    public Author update(@RequestBody Author author){
        return service.update(author);
    }

}

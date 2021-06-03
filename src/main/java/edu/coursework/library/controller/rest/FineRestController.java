package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.Fine;
import edu.coursework.library.service.fine.impls.FineServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fine")
public class FineRestController {

    @Autowired
    FineServiceImpl fineService;

    @GetMapping("/get/all")
    public List<Fine> getAdministrations(){
        return fineService.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Fine getById(@PathVariable("id") String id){ return fineService.getById(id); }

    @GetMapping("/delete/{id}")
    public Fine deleteById(@PathVariable("id") String id){
        return fineService.delete(id);
    }

    @PostMapping("/create/")
    public Fine create(@RequestBody Fine fine){ return fineService.create(fine); }

    @PostMapping ("/update/")
    public Fine update(@RequestBody Fine fine){ return fineService.update(fine); }

}

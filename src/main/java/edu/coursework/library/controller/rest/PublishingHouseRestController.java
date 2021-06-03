package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.PublishingHouse;
import edu.coursework.library.service.publishingHouse.impls.PublishingHouseServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/publishingHouse")
public class PublishingHouseRestController {

    @Autowired
    PublishingHouseServiceImpl publishingHouseService;

    @GetMapping("/get/all")
    public List<PublishingHouse> getAdministrations(){
        return publishingHouseService.getAll() ;
    }

    @GetMapping("/get/{id}")
    public PublishingHouse getById(@PathVariable("id") String id){ return publishingHouseService.getById(id); }

    @GetMapping("/delete/{id}")
    public PublishingHouse deleteById(@PathVariable("id") String id){
        return publishingHouseService.delete(id);
    }

    @PostMapping("/create/")
    public PublishingHouse create(@RequestBody PublishingHouse publishingHouse){ return publishingHouseService.create(publishingHouse); }

    @PostMapping ("/update/")
    public PublishingHouse update(@RequestBody PublishingHouse publishingHouse){ return publishingHouseService.update(publishingHouse); }

}

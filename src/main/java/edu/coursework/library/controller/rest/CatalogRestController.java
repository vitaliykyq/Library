package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.Catalog;
import edu.coursework.library.service.catalog.impls.CatalogServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalog")
public class CatalogRestController {

    @Autowired
    CatalogServiceImpl catalogService;

    @GetMapping("/get/all")
    public List<Catalog> getAdministrations(){
        return catalogService.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Catalog getById(@PathVariable("id") String id){ return catalogService.getById(id); }

    @GetMapping("/delete/{id}")
    public Catalog deleteById(@PathVariable("id") String id){
        return catalogService.delete(id);
    }

    @PostMapping("/create/")
    public Catalog create(@RequestBody Catalog catalog){ return catalogService.create(catalog); }

    @PostMapping ("/update/")
    public Catalog update(@RequestBody Catalog catalog){ return catalogService.update(catalog); }

}

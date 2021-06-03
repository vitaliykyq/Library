package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.CardIndex;
import edu.coursework.library.service.cardIndex.impls.CardIndexServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cardIndex")
public class CardIndexRestController {

    @Autowired
    CardIndexServiceImpl cardIndexService;

    @GetMapping("/get/all")
    public List<CardIndex> getAdministrations(){
        return cardIndexService.getAll() ;
    }

    @GetMapping("/get/{id}")
    public CardIndex getById(@PathVariable("id") String id){ return cardIndexService.getById(id); }

    @GetMapping("/delete/{id}")
    public CardIndex deleteById(@PathVariable("id") String id){
        return cardIndexService.delete(id);
    }

    @PostMapping("/create/")
    public CardIndex create(@RequestBody CardIndex cardIndex){ return cardIndexService.create(cardIndex); }

    @PostMapping ("/update/")
    public CardIndex update(@RequestBody CardIndex cardIndex){ return cardIndexService.update(cardIndex); }

}

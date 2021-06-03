package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.Subscriber;
import edu.coursework.library.service.subscriber.impls.SubscriberServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/services")
public class SubscriberRestController {

    @Autowired
    SubscriberServiceImpl subscriberService;

    @GetMapping("/get/all")
    public List<Subscriber> getAdministrations(){
        return subscriberService.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Subscriber getById(@PathVariable("id") String id){ return subscriberService.getById(id); }

    @GetMapping("/delete/{id}")
    public Subscriber deleteById(@PathVariable("id") String id){
        return subscriberService.delete(id);
    }

    @PostMapping("/create/")
    public Subscriber create(@RequestBody Subscriber subscriber){ return subscriberService.create(subscriber); }

    @PostMapping ("/update/")
    public Subscriber update(@RequestBody Subscriber subscriber){ return subscriberService.update(subscriber); }

}

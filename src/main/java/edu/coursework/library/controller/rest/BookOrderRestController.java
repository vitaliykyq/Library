package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.BookOrder;
import edu.coursework.library.service.bookOrder.impls.BookOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookOrder")
public class BookOrderRestController {

    @Autowired
    BookOrderServiceImpl bookOrderService;

    @GetMapping("/get/all")
    public List<BookOrder> getAdministrations(){
        return bookOrderService.getAll() ;
    }

    @GetMapping("/get/{id}")
    public BookOrder getById(@PathVariable("id") String id){ return bookOrderService.getById(id); }

    @GetMapping("/delete/{id}")
    public BookOrder deleteById(@PathVariable("id") String id){
        return bookOrderService.delete(id);
    }

    @PostMapping("/create/")
    public BookOrder create(@RequestBody BookOrder bookOrder){ return bookOrderService.create(bookOrder); }

    @PostMapping ("/update/")
    public BookOrder update(@RequestBody BookOrder bookOrder){ return bookOrderService.update(bookOrder); }

}

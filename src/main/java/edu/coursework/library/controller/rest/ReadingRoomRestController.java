package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.ReadingRoom;
import edu.coursework.library.service.readingRoom.impls.ReadingRoomServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/readingRoom")
public class ReadingRoomRestController {

    @Autowired
    ReadingRoomServiceImpl readingRoomService;

    @GetMapping("/get/all")
    public List<ReadingRoom> getAdministrations(){
        return readingRoomService.getAll() ;
    }

    @GetMapping("/get/{id}")
    public ReadingRoom getById(@PathVariable("id") String id){ return readingRoomService.getById(id); }

    @GetMapping("/delete/{id}")
    public ReadingRoom deleteById(@PathVariable("id") String id){
        return readingRoomService.delete(id);
    }

    @PostMapping("/create/")
    public ReadingRoom create(@RequestBody ReadingRoom readingRoom){ return readingRoomService.create(readingRoom); }

    @PostMapping ("/update/")
    public ReadingRoom update(@RequestBody ReadingRoom readingRoom){ return readingRoomService.update(readingRoom); }

}

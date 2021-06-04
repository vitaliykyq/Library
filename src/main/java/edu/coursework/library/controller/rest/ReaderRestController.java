package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.Reader;
import edu.coursework.library.service.reader.impls.ReaderServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reader")
public class ReaderRestController {

    @Autowired
    ReaderServiceImpl readerService;

    @GetMapping("/get/all")
    public List<Reader> getAdministrations(){
        return readerService.getAll() ;
    }

    @GetMapping("/get/withFine")
    public Object getReadersWithFine(){
        return readerService.findReadersWithFine() ;
    }

    @GetMapping("/get/readersInReadingRooms/number}")
    public Object findReadersInReadingRooms(@PathVariable("number") int number){
        return readerService.findReadersInReadingRooms(number) ;
    }

    @GetMapping("/get/amountOfReadersInReadingRooms")
    public Object getReadersWitfindAmountOfReadersInReadingRoomshFine(){
        return readerService.findAmountOfReadersInReadingRooms() ;
    }

    @GetMapping("/get/readersOfFaculty/{faculty}")
    public Object findReadersOfFaculty(@PathVariable("faculty") String faculty){
        return readerService.findReadersOfFaculty(faculty) ;
    }

    @GetMapping("/get/readersOfCourse/{course}")
    public Object findReadersOfCourse(@PathVariable("course") int course){
        return readerService.findReadersOfCourse(course) ;
    }

    @GetMapping("/get/readersOfGroup/{course}")
    public Object findReadersOfGroup(@PathVariable("group") String group){
        return readerService.findReadersOfGroup(group) ;
    }

    @GetMapping("/get/{id}")
    public Reader getById(@PathVariable("id") String id){ return readerService.getById(id); }

    @GetMapping("/delete/{id}")
    public Reader deleteById(@PathVariable("id") String id){
        return readerService.delete(id);
    }

    @PostMapping("/create/")
    public Reader create(@RequestBody Reader reader){ return readerService.create(reader); }

    @PostMapping ("/update/")
    public Reader update(@RequestBody Reader reader){ return readerService.update(reader); }

}

package edu.coursework.library.controller.ui;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    ReadingRoomUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.library.model.Author;
import edu.coursework.library.model.Book;
import edu.coursework.library.model.Catalog;
import edu.coursework.library.model.ReadingRoom;
import edu.coursework.library.service.catalog.impls.CatalogServiceImpl;
import edu.coursework.library.service.readingRoom.impls.ReadingRoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/readingRoom")
@Controller
public class ReadingRoomUIController {

    @Autowired
    ReadingRoomServiceImpl readingRoomService;

    @Autowired
    CatalogServiceImpl catalogService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<ReadingRoom> readingRoomList = readingRoomService.getAll();
        model.addAttribute("readingRoomList", readingRoomList);

        return "readingRoom/readingRoomList";
    }

    @GetMapping("/showUpdateForm/{id}/{idAuthor}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        ReadingRoom readingRoom = readingRoomService.getById(id);
        model.addAttribute("readingRoom", readingRoom);

        List<Catalog> catalogListId = catalogService.getAll();
        model.addAttribute("catalogListId", catalogListId);
        return "readingRoom/updateReadingRoom";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("readingRoom") @RequestBody ReadingRoom readingRoom) {

        readingRoomService.update(readingRoom);
        return "redirect:/ui/readingRoom/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        ReadingRoom readingRoom = new ReadingRoom();
        model.addAttribute("readingRoom", readingRoom);

        List<Catalog> catalogListId = catalogService.getAll();
        model.addAttribute("catalogListId", catalogListId);
        return "readingRoom/newReadingRoom";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("readingRoom") @RequestBody ReadingRoom readingRoom) {
        model.addAttribute("readingRoom", readingRoomService.create(readingRoom));
        return "redirect:/ui/readingRoom/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        readingRoomService.delete(id);
        return "redirect:/ui/readingRoom/get/all";
    }
}

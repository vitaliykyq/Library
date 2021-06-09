package edu.coursework.library.controller.ui;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    ReaderUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.library.model.Person;
import edu.coursework.library.model.Reader;
import edu.coursework.library.model.ReadingRoom;
import edu.coursework.library.model.TakenBook;
import edu.coursework.library.service.person.impls.PersonServiceImpl;
import edu.coursework.library.service.reader.impls.ReaderServiceImpl;
import edu.coursework.library.service.readingRoom.impls.ReadingRoomServiceImpl;
import edu.coursework.library.service.takenBook.impls.TakenBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/reader")
@Controller
public class ReaderUIController {

    @Autowired
    ReaderServiceImpl readerService;

    @Autowired
    PersonServiceImpl personService;

    @Autowired
    TakenBookServiceImpl takenBookService;

    @Autowired
    ReadingRoomServiceImpl readingRoomService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Reader> readerList = readerService.getAll();
        model.addAttribute("readerList", readerList);

        return "reader/readerList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Reader reader = readerService.getById(id);
        model.addAttribute("reader", reader);

        List<Person> personListId = personService.getAll();
        model.addAttribute("personListId", personListId);

        List<TakenBook> takenBookListId = takenBookService.getAll();
        model.addAttribute("takenBookListId", takenBookListId);

        List<ReadingRoom> readingRoomListId = readingRoomService.getAll();
        model.addAttribute("readingRoomListId", readingRoomListId);
        return "reader/updateReader";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("reader") @RequestBody Reader reader) {

        readerService.update(reader);
        return "redirect:/ui/reader/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Reader reader = new Reader();
        model.addAttribute("reader", reader);

        List<Person> personListId = personService.getAll();
        model.addAttribute("personListId", personListId);

        List<TakenBook> takenBookListId = takenBookService.getAll();
        model.addAttribute("takenBookListId", takenBookListId);

        List<ReadingRoom> readingRoomListId = readingRoomService.getAll();
        model.addAttribute("readingRoomListId", readingRoomListId);
        return "reader/newReader";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("reader") @RequestBody Reader reader) {
        model.addAttribute("reader", readerService.create(reader));
        return "redirect:/ui/reader/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        readerService.delete(id);
        return "redirect:/ui/reader/get/all";
    }
}

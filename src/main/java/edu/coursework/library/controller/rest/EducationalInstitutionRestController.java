package edu.coursework.library.controller.rest;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.EducationalInstitution;
import edu.coursework.library.service.educationalInstitution.impls.EducationalInstitutionServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/educationalInstitution")
public class EducationalInstitutionRestController {

    @Autowired
    EducationalInstitutionServiceImpl educationalInstitutionService;

    @GetMapping("/get/all")
    public List<EducationalInstitution> getAdministrations(){
        return educationalInstitutionService.getAll() ;
    }

    @GetMapping("/get/{id}")
    public EducationalInstitution getById(@PathVariable("id") String id){ return educationalInstitutionService.getById(id); }

    @GetMapping("/delete/{id}")
    public EducationalInstitution deleteById(@PathVariable("id") String id){
        return educationalInstitutionService.delete(id);
    }

    @PostMapping("/create/")
    public EducationalInstitution create(@RequestBody EducationalInstitution educationalInstitution){ return educationalInstitutionService.create(educationalInstitution); }

    @PostMapping ("/update/")
    public EducationalInstitution update(@RequestBody EducationalInstitution educationalInstitution){ return educationalInstitutionService.update(educationalInstitution); }

}

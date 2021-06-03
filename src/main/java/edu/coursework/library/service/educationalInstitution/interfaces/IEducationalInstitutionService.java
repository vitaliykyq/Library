package edu.coursework.library.service.educationalInstitution.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.EducationalInstitution;

import java.util.List;

public interface IEducationalInstitutionService {

    EducationalInstitution getById(String id);
    EducationalInstitution create(EducationalInstitution educationalInstitution);
    EducationalInstitution update(EducationalInstitution educationalInstitution);
    EducationalInstitution delete(String id);
    List<EducationalInstitution> getAll();
}

package edu.coursework.library.service.fine.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Fine;

import java.util.List;

public interface IFineService {

    Fine getById(String id);
    Fine create(Fine fine);
    Fine update(Fine fine);
    Fine delete(String id);
    List<Fine> getAll();
}

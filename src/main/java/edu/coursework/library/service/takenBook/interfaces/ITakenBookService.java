package edu.coursework.library.service.takenBook.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.TakenBook;

import java.util.List;

public interface ITakenBookService {

    TakenBook getById(String id);
    TakenBook create(TakenBook takenBook);
    TakenBook update(TakenBook takenBook);
    TakenBook delete(String id);
    List<TakenBook> getAll();
}

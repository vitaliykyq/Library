package edu.coursework.library.service.reader.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Reader;

import java.util.List;

public interface IReaderService {

    Reader getById(String id);
    Reader create(Reader reader);
    Reader update(Reader reader);
    Reader delete(String id);
    List<Reader> getAll();
}

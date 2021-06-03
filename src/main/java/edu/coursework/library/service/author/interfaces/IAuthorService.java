package edu.coursework.library.service.author.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Author;

import java.util.List;

public interface IAuthorService {

    Author getById(String id);
    Author create(Author author);
    Author update(Author author);
    Author delete(String id);
    List<Author> getAll();
}

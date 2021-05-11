package edu.coursework.library.service.author.interfaces;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    IBookService
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.model.Author;

import java.util.List;

public interface IAuthorService {

    Author getById(String id);
    Author create(Author author);
    Author update(Author author);
    Author delete(String id);
    Author save(Author author);
    List<Author> getAll();
}

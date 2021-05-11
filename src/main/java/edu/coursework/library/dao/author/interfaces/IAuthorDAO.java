package edu.coursework.library.dao.author.interfaces;

/*
    @author:    Vitaliy
    @project:    Library
    @interface:    IBookDAO
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.library.model.Author;

import java.util.List;

public interface IAuthorDAO {

    Author getById(String id);
    Author create(Author author);
    Author update(Author author);
    Author delete(String id);
    Author save(Author author);
    List<Author> getAll();
}

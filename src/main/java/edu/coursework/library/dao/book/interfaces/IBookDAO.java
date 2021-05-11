package edu.coursework.library.dao.person.interfaces;

/*
    @author:    Vitaliy
    @project:    Library
    @interface:    IBookDAO
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.library.model.Book;

import java.util.List;

public interface IBookDAO {

    Book getById(String id);
    Book create(Book book);
    Book update(Book book);
    Book delete(String id);
    Book save(Book book);
    List<Book> getAll();
}

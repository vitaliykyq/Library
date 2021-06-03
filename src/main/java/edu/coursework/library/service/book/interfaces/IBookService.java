package edu.coursework.library.service.book.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Book;

import java.util.List;

public interface IBookService {

    Book getById(String id);
    Book create(Book book);
    Book update(Book book);
    Book delete(String id);
    List<Book> getAll();
}

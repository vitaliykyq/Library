package edu.coursework.library.service.bookOrder.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.BookOrder;

import java.util.List;

public interface IBookOrderService {

    BookOrder getById(String id);
    BookOrder create(BookOrder bookOrder);
    BookOrder update(BookOrder bookOrder);
    BookOrder delete(String id);
    List<BookOrder> getAll();
}

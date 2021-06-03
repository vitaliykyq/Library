package edu.coursework.library.service.bookOrder.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.BookOrder;
import edu.coursework.library.repository.BookOrderRepository;
import edu.coursework.library.service.bookOrder.interfaces.IBookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookOrderServiceImpl implements IBookOrderService {

    @Autowired
    BookOrderRepository repository;

    @Override
    public BookOrder getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public BookOrder create(BookOrder bookOrder) {
        bookOrder.setCreatedAt(new Date());
        return repository.save(bookOrder);
    }

    @Override
    public BookOrder update(BookOrder bookOrder) {
        bookOrder.setModifiedAt(new Date());
        bookOrder.setCreatedAt(repository.findById(bookOrder.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(bookOrder);
        return bookOrder;
    }

    @Override
    public BookOrder delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<BookOrder> getAll() {

        return repository.findAll();
    }
}

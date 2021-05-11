package edu.coursework.library.service.book.impls;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    BookServiceImpl
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.library.dao.person.impls.BookDAOImpl;
import edu.coursework.library.data.FakeData;
import edu.coursework.library.model.Book;
import edu.coursework.library.service.book.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    FakeData fakeData;

    @Autowired
    BookDAOImpl dao;

    @Override
    public Book getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Book create(Book book) {
        return dao.create(book);
    }

    @Override
    public Book update(Book book) {
        return dao.update(book);
    }

    @Override
    public Book delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return dao.getAll();
    }
}

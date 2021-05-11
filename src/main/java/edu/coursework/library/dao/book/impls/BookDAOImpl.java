package edu.coursework.library.dao.person.impls;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    BookDAOImpl
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.library.dao.person.interfaces.IBookDAO;
import edu.coursework.library.data.FakeData;
import edu.coursework.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BookDAOImpl implements IBookDAO {

    @Autowired
    FakeData fakeData;

    /*@Override
    public Administration getById(String id) {
        return null;
    }

    @Override
    public Administration create(Administration administration) {
        return null;
    }

    @Override
    public Administration update(Administration administration) {
        return null;
    }

    @Override
    public Administration delete(String id) {
        return null;
    }

    @Override
    public Administration save(Administration administration) {
        return null;
    }

    @Override
    public List<Administration> getAll() {
        return fakeData.getAdministrations();
    }*/

    @Override
    public Book getById(String id) {
        return this.getAll().stream()
                .filter(services -> services.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Book create(Book book) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId()))
                .max().orElse(0)+1);
        book.setCreated_at(LocalDateTime.now());
        book.setId(id);
        this.getAll().add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        Book updateBook = this.getById(book.getId());
        updateBook.setName(book.getName());
        updateBook.setUseBook(book.getUseBook());
        updateBook.setYearIssue(book.getYearIssue());
        updateBook.setAmount(book.getAmount());
        updateBook.setPrice(book.getPrice());
        updateBook.setEdition(book.getEdition());
        updateBook.setPenaltyLoss(book.getPenaltyLoss());
        updateBook.setAuthor(book.getAuthor());
        updateBook.setModified_at(LocalDateTime.now());
        return updateBook;

    }

    @Override
    public Book delete(String id) {
        Book book = this.getById(id);
        this.getAll().remove(book);
        return book;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return fakeData.getBookList();
    }
}

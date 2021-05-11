package edu.coursework.library.service.author.impls;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    BookServiceImpl
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.library.dao.author.impls.AuthorDAOImpl;
import edu.coursework.library.data.FakeData;
import edu.coursework.library.model.Author;
import edu.coursework.library.service.author.interfaces.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    FakeData fakeData;

    @Autowired
    AuthorDAOImpl dao;

    @Override
    public Author getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Author create(Author author) {
        return dao.create(author);
    }

    @Override
    public Author update(Author author) {
        return dao.update(author);
    }

    @Override
    public Author delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Author save(Author author) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return dao.getAll();
    }
}

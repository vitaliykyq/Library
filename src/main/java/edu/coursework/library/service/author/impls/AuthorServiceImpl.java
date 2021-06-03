package edu.coursework.library.service.author.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Author;
import edu.coursework.library.repository.AuthorRepository;
import edu.coursework.library.service.author.interfaces.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    AuthorRepository repository;

    @Override
    public Author getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Author create(Author author) {
        author.setCreatedAt(new Date());
        return repository.save(author);
    }

    @Override
    public Author update(Author author) {
        author.setModifiedAt(new Date());
        author.setCreatedAt(repository.findById(author.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(author);
        return author;
    }

    @Override
    public Author delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Author> getAll() {

        return repository.findAll();
    }
}

/*package edu.coursework.library.dao.author.impls;

*//*
    @author:    Vitaliy
    @project:    Library
    @class:    BookDAOImpl
    @version:    1.0.0
    @since:    14.04.2021
*//*

import edu.coursework.library.dao.author.interfaces.IAuthorDAO;
import edu.coursework.library.data.FakeData;
import edu.coursework.library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AuthorDAOImpl implements IAuthorDAO {

    @Autowired
    FakeData fakeData;

    *//*@Override
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
    }*//*

    @Override
    public Author getById(String id) {
        return this.getAll().stream()
                .filter(services -> services.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Author create(Author author) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId()))
                .max().orElse(0)+1);
        author.setCreated_at(LocalDateTime.now());
        author.setId(id);
        this.getAll().add(author);
        return author;
    }

    @Override
    public Author update(Author author) {
        Author updatedAuthor = this.getById(author.getId());
        updatedAuthor.setName(author.getName());
        updatedAuthor.setBirth(author.getBirth());
        updatedAuthor.setDeath(author.getDeath());
        updatedAuthor.setCountry(author.getCountry());
        updatedAuthor.setModified_at(LocalDateTime.now());
        return updatedAuthor;

    }

    @Override
    public Author delete(String id) {
        Author author = this.getById(id);
        this.getAll().remove(author);
        return author;
    }

    @Override
    public Author save(Author author) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        return fakeData.getAuthorList();
    }
}*/

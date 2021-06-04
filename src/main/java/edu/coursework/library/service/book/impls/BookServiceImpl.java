package edu.coursework.library.service.book.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Book;
import edu.coursework.library.repository.BookRepository;
import edu.coursework.library.service.book.interfaces.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    @Autowired
    BookRepository repository;
    private final MongoTemplate mongoTemplate;

    @Override
    public Book getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Book create(Book book) {
        book.setCreatedAt(new Date());
        return repository.save(book);
    }

    @Override
    public Book update(Book book) {
        book.setModifiedAt(new Date());
        book.setCreatedAt(repository.findById(book.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(book);
        return book;
    }

    @Override
    public Book delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Book> getAll() {

        return repository.findAll();
    }

    public Object getNumOfBooksInCartoteka() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("cardIndex.name").count().as("numOfBooksInCartoteka"));

        return mongoTemplate.aggregate(aggregation, "book", Object.class).getMappedResults();
    }
    public Object getNumOfBooksInLibrary() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("name"),
                Aggregation.count().as("numberOfBooks"));

        return mongoTemplate.aggregate(aggregation, "book", Object.class).getMappedResults();
    }
    public Object getNumOfSameBookInLibrary() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("name").count().as("amountOfCopies"));

        return mongoTemplate.aggregate(aggregation, "book", Object.class).getMappedResults();
    }
}

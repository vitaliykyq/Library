package edu.coursework.library.service.reader.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Reader;
import edu.coursework.library.repository.ReaderRepository;
import edu.coursework.library.service.reader.interfaces.IReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements IReaderService {

    @Autowired
    ReaderRepository repository;
    private final MongoTemplate mongoTemplate;

    @Override
    public Reader getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Reader create(Reader reader) {
        reader.setCreatedAt(new Date());
        return repository.save(reader);
    }

    @Override
    public Reader update(Reader reader) {
        reader.setModifiedAt(new Date());
        reader.setCreatedAt(repository.findById(reader.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(reader);
        return reader;
    }

    @Override
    public Reader delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Reader> getAll() {

        return repository.findAll();
    }

    public Object findReadersInReadingRooms(int number) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("readingRoom.number").is(number)));

        return mongoTemplate.aggregate(aggregation, "readers", Object.class).getMappedResults();
    }

    public Object findAmountOfReadersInReadingRooms() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("readingRoom.number").count().as("numberOfReaders"));

        return mongoTemplate.aggregate(aggregation, "readers", Object.class).getMappedResults();
    }
    public Object findReadersOfFaculty(String faculty) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("person.educationalInstitution.faculty").is(faculty)));

        return mongoTemplate.aggregate(aggregation, "readers", Object.class).getMappedResults();
    }
    public Object findReadersOfCourse(int course) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("person.educationalInstitution.course").is(course)));

        return mongoTemplate.aggregate(aggregation, "readers", Object.class).getMappedResults();
    }
    public Object findReadersOfGroup(String group) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("person.educationalInstitution.group").is(group)));

        return mongoTemplate.aggregate(aggregation, "readers", Object.class).getMappedResults();
    }
    public Object findReadersWithFine() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.unwind("takenBookList"),
                Aggregation.match(Criteria.where("takenBookList.fine").is(null)),
                Aggregation.project("person.name","takenBookList.name"));

        return mongoTemplate.aggregate(aggregation, "readers", Object.class).getMappedResults();
    }

}

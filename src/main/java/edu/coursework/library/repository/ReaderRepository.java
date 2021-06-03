package edu.coursework.library.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    LaboratoryRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.library.model.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends MongoRepository<Reader, String> {
}

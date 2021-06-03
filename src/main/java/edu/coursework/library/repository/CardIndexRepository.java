package edu.coursework.library.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    EngineerRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.library.model.CardIndex;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardIndexRepository extends MongoRepository<CardIndex, String> {
}

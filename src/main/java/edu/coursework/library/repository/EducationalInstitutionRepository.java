package edu.coursework.library.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    GliderRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.library.model.EducationalInstitution;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationalInstitutionRepository extends MongoRepository<EducationalInstitution, String> {
}

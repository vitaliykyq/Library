package edu.coursework.library.service.person.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Person;
import edu.coursework.library.repository.PersonRepository;
import edu.coursework.library.service.person.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    PersonRepository repository;

    @Override
    public Person getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Person create(Person person) {
        person.setCreatedAt(new Date());
        return repository.save(person);
    }

    @Override
    public Person update(Person person) {
        person.setModifiedAt(new Date());
        person.setCreatedAt(repository.findById(person.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(person);
        return person;
    }

    @Override
    public Person delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Person> getAll() {

        return repository.findAll();
    }
}

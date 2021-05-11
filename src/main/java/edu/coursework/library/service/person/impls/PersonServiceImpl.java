package edu.coursework.library.service.person.impls;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonServiceImpl
    @version:    1.0.0
    @since:    14.04.2021
*/

import edu.coursework.library.dao.person.impls.PersonDAOImpl;
import edu.coursework.library.data.FakeData;
import edu.coursework.library.model.Person;
import edu.coursework.library.service.person.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    /*@Autowired
    FakeData fakeData;

    @Autowired
    PersonDAOImpl dao;

    @Override
    public Person getById(String id) {
        return dao.getById(id);
    }

    @Override
    public Person create(Person services) {
        return dao.create(services);
    }

    @Override
    public Person update(Person services) {
        return dao.update(services);
    }

    @Override
    public Person delete(String id) {
        return dao.delete(id);
    }

    @Override
    public Person save(Person administration) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return dao.getAll();
    }*/
}

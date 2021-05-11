package edu.coursework.library.dao.person.impls;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    PersonDAOImpl
    @version:    1.0.0 
    @since:    14.04.2021     
*/

import edu.coursework.library.dao.person.interfaces.IPersonDAO;
import edu.coursework.library.data.FakeData;
import edu.coursework.library.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PersonDAOImpl implements IPersonDAO {

    @Autowired
    FakeData fakeData;

    /*@Override
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
    }*/

    /*@Override
    public Person getById(String id) {
        return this.getAll().stream()
                .filter(services -> services.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Person create(Person persons) {
        String id = String.valueOf(this.getAll().stream()
                .mapToInt(el->Integer.parseInt(el.getId()))
                .max().orElse(0)+1);
        persons.setCreated_at(LocalDateTime.now());
        persons.setId(id);
        this.getAll().add(persons);
        return persons;
    }

    @Override
    public Person update(Person person) {
        Person persons = this.getById(person.getId());
        persons.setName(person.getName());
        persons.setSurname(person.getSurname());
        persons.setAge(person.getAge());
        persons.setGender(person.getGender());
        persons.setModified_at(LocalDateTime.now());

        return persons;

    }

    @Override
    public Person delete(String id) {
        Person administration = this.getById(id);
        this.getAll().remove(administration);
        return administration;
    }

    @Override
    public Person save(Person stadium) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return fakeData.getServices();
    }*/
}

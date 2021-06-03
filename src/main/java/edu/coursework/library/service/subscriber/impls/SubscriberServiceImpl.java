package edu.coursework.library.service.subscriber.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Subscriber;
import edu.coursework.library.repository.SubscriberRepository;
import edu.coursework.library.service.subscriber.interfaces.ISubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubscriberServiceImpl implements ISubscriberService {

    @Autowired
    SubscriberRepository repository;

    @Override
    public Subscriber getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Subscriber create(Subscriber subscriber) {
        subscriber.setCreatedAt(new Date());
        return repository.save(subscriber);
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        subscriber.setModifiedAt(new Date());
        subscriber.setCreatedAt(repository.findById(subscriber.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(subscriber);
        return subscriber;
    }

    @Override
    public Subscriber delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Subscriber> getAll() {

        return repository.findAll();
    }
}

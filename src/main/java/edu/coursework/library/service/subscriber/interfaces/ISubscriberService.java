package edu.coursework.library.service.subscriber.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Subscriber;

import java.util.List;

public interface ISubscriberService {

    Subscriber getById(String id);
    Subscriber create(Subscriber subscriber);
    Subscriber update(Subscriber subscriber);
    Subscriber delete(String id);
    List<Subscriber> getAll();
}

package edu.coursework.library.service.publishingHouse.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.PublishingHouse;

import java.util.List;

public interface IPublishingHouseService {

    PublishingHouse getById(String id);
    PublishingHouse create(PublishingHouse publishingHouse);
    PublishingHouse update(PublishingHouse publishingHouse);
    PublishingHouse delete(String id);
    List<PublishingHouse> getAll();
}

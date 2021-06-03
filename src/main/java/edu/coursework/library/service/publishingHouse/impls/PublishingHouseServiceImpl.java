package edu.coursework.library.service.publishingHouse.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.PublishingHouse;
import edu.coursework.library.repository.PublishingHouseRepository;
import edu.coursework.library.service.publishingHouse.interfaces.IPublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PublishingHouseServiceImpl implements IPublishingHouseService {

    @Autowired
    PublishingHouseRepository repository;

    @Override
    public PublishingHouse getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public PublishingHouse create(PublishingHouse publishingHouse) {
        publishingHouse.setCreatedAt(new Date());
        return repository.save(publishingHouse);
    }

    @Override
    public PublishingHouse update(PublishingHouse publishingHouse) {
        publishingHouse.setModifiedAt(new Date());
        publishingHouse.setCreatedAt(repository.findById(publishingHouse.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(publishingHouse);
        return publishingHouse;
    }

    @Override
    public PublishingHouse delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<PublishingHouse> getAll() {

        return repository.findAll();
    }
}

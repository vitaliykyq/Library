package edu.coursework.library.service.catalog.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Catalog;
import edu.coursework.library.repository.CatalogRepository;
import edu.coursework.library.service.catalog.interfaces.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CatalogServiceImpl implements ICatalogService {

    @Autowired
    CatalogRepository repository;

    @Override
    public Catalog getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Catalog create(Catalog catalog) {
        catalog.setCreatedAt(new Date());
        return repository.save(catalog);
    }

    @Override
    public Catalog update(Catalog catalog) {
        catalog.setModifiedAt(new Date());
        catalog.setCreatedAt(repository.findById(catalog.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(catalog);
        return catalog;
    }

    @Override
    public Catalog delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Catalog> getAll() {

        return repository.findAll();
    }
}

package edu.coursework.library.service.catalog.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/


import edu.coursework.library.model.Catalog;

import java.util.List;

public interface ICatalogService {

    Catalog getById(String id);
    Catalog create(Catalog catalog);
    Catalog update(Catalog catalog);
    Catalog delete(String id);
    List<Catalog> getAll();
}

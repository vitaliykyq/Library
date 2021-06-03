package edu.coursework.library.service.cardIndex.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.CardIndex;

import java.util.List;

public interface ICardIndexService {

    CardIndex getById(String id);
    CardIndex create(CardIndex cardIndex);
    CardIndex update(CardIndex cardIndex);
    CardIndex delete(String id);
    List<CardIndex> getAll();
}

package edu.coursework.library.service.cardIndex.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.CardIndex;
import edu.coursework.library.repository.CardIndexRepository;
import edu.coursework.library.service.cardIndex.interfaces.ICardIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CardIndexServiceImpl implements ICardIndexService {

    @Autowired
    CardIndexRepository repository;

    @Override
    public CardIndex getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public CardIndex create(CardIndex cardIndex) {
        cardIndex.setCreatedAt(new Date());
        return repository.save(cardIndex);
    }

    @Override
    public CardIndex update(CardIndex cardIndex) {
        cardIndex.setModifiedAt(new Date());
        cardIndex.setCreatedAt(repository.findById(cardIndex.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(cardIndex);
        return cardIndex;
    }

    @Override
    public CardIndex delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<CardIndex> getAll() {

        return repository.findAll();
    }
}

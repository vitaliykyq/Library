package edu.coursework.library.service.fine.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Fine;
import edu.coursework.library.repository.FineRepository;
import edu.coursework.library.service.fine.interfaces.IFineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FineServiceImpl implements IFineService {

    @Autowired
    FineRepository repository;

    @Override
    public Fine getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Fine create(Fine fine) {
        fine.setCreatedAt(new Date());
        return repository.save(fine);
    }

    @Override
    public Fine update(Fine fine) {
        fine.setModifiedAt(new Date());
        fine.setCreatedAt(repository.findById(fine.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(fine);
        return fine;
    }

    @Override
    public Fine delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Fine> getAll() {

        return repository.findAll();
    }
}

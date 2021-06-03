package edu.coursework.library.service.takenBook.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.TakenBook;
import edu.coursework.library.repository.TakenBookRepository;
import edu.coursework.library.service.takenBook.interfaces.ITakenBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TakenBookServiceImpl implements ITakenBookService {

    @Autowired
    TakenBookRepository repository;

    @Override
    public TakenBook getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public TakenBook create(TakenBook takenBook) {
        takenBook.setCreatedAt(new Date());
        return repository.save(takenBook);
    }

    @Override
    public TakenBook update(TakenBook takenBook) {
        takenBook.setModifiedAt(new Date());
        takenBook.setCreatedAt(repository.findById(takenBook.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(takenBook);
        return takenBook;
    }

    @Override
    public TakenBook delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<TakenBook> getAll() {

        return repository.findAll();
    }
}

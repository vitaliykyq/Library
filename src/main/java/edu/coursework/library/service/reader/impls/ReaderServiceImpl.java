package edu.coursework.library.service.reader.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.Reader;
import edu.coursework.library.repository.ReaderRepository;
import edu.coursework.library.service.reader.interfaces.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReaderServiceImpl implements IReaderService {

    @Autowired
    ReaderRepository repository;

    @Override
    public Reader getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Reader create(Reader reader) {
        reader.setCreatedAt(new Date());
        return repository.save(reader);
    }

    @Override
    public Reader update(Reader reader) {
        reader.setModifiedAt(new Date());
        reader.setCreatedAt(repository.findById(reader.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(reader);
        return reader;
    }

    @Override
    public Reader delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Reader> getAll() {

        return repository.findAll();
    }
}

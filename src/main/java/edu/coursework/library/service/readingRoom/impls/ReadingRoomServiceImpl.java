package edu.coursework.library.service.readingRoom.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.ReadingRoom;
import edu.coursework.library.repository.ReadingRoomRepository;
import edu.coursework.library.service.readingRoom.interfaces.IReadingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReadingRoomServiceImpl implements IReadingRoomService {

    @Autowired
    ReadingRoomRepository repository;

    @Override
    public ReadingRoom getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public ReadingRoom create(ReadingRoom readingRoom) {
        readingRoom.setCreatedAt(new Date());
        return repository.save(readingRoom);
    }

    @Override
    public ReadingRoom update(ReadingRoom readingRoom) {
        readingRoom.setModifiedAt(new Date());
        readingRoom.setCreatedAt(repository.findById(readingRoom.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(readingRoom);
        return readingRoom;
    }

    @Override
    public ReadingRoom delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<ReadingRoom> getAll() {

        return repository.findAll();
    }
}

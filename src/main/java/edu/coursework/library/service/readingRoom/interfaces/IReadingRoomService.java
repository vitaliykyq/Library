package edu.coursework.library.service.readingRoom.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.ReadingRoom;

import java.util.List;

public interface IReadingRoomService {

    ReadingRoom getById(String id);
    ReadingRoom create(ReadingRoom readingRoom);
    ReadingRoom update(ReadingRoom readingRoom);
    ReadingRoom delete(String id);
    List<ReadingRoom> getAll();
}

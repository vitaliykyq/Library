package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class ReadingRoom {

    private String id;

    private int number;
    private int amount;
    private Person duty;
    private ArrayList<Reader> readers;
    private Catalog catalog;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

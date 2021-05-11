package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class Subscriber {

    private String id;
    private String address;
    //Librarian{
        private Person librarian;
        private String phone;
    //}
    private ArrayList<Reader> readers;
    private Catalog catalog;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

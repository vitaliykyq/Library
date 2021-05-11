package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Data
public class Catalog {

    private String id;

    private ArrayList<objBookCame> objBookCame;
    private ArrayList<LostBooks> lostBooks;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

@Data
class objBookCame {
    private ArrayList<Book> books;
    private Date arrival;
}
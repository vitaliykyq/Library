package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Data
public class Debtor {
    
    private String id;
    private ArrayList<objDebt> debt;
    private ArrayList<objOffense> offense;
    private Date TermDeprivation;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}

@Data
class objDebt {
    private Book book;
    private Date date;
}

@Data
class objOffense {
    private String name;
    private int price;
}
package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class LostBooks {

    private String id;
    private Book book;
    private Date date;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

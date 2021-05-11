package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Reader {

    private String id;

    private Ticket ticket;
    private Object type;
    private String typeText;
    private Debtor debtor;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}

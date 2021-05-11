package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Students {

    private String id;
    private Person person;
    private int group;
    private int course;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}

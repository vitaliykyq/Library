package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Postgraduate {

    private String id;

    private String formEducation;
    private int teachingHours;
    private int permittedHours;
    private Person person;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

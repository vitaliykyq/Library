package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class Applicants {

    private String id;

    private String selectedUniversity;
    private String selectedSpecialty;
    private ArrayList<String> EIT;
    private Person person;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

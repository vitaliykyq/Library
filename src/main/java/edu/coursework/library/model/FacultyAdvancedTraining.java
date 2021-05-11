package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class FacultyAdvancedTraining {

    private String id;

    private String qualification;
    private int rating;
    private ArrayList<Person> persons;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

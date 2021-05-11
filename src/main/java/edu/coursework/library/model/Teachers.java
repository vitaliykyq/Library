package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
public class Teachers {

    private String id;

    private String faculty;
    private String degree;
    private ArrayList<String> subject;
    private Person person;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

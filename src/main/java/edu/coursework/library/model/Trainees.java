package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Trainees {

    private String id;

    private double time;
    private int progress;
    private boolean isHired;
    private Person person;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

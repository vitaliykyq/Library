package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdmissionsCommittee {

    private String id;

    private String department;
    private String region;
    private int NumberInspections;
    private Person person;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;
}

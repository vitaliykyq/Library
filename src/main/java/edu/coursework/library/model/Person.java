package edu.coursework.library.model;

/*
    @author:    vitaliykyq
    @project:   Library
    @class:     Person
    @version:    1.0.0
    @since:    15.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "person")
public class Person {
    @Id
    private String id;

    private String name;
    private String surname;
    private int year;
    private String gender;
    private EducationalInstitution educationalInstitution;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}

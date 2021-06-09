package edu.coursework.library.model;

/*
    @author:    vitaliykyq
    @project:   Library
    @class:     TakenBook
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
@Document(collection = "takenBook")
public class TakenBook {
    @Id
    private String id;

    private Book book;
    private String whenTaken;
    private String untilWhenTaken;
    private Fine fine;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}

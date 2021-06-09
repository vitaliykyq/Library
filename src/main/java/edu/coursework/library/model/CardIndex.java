package edu.coursework.library.model;

/*
    @author:    vitaliykyq
    @project:   Library
    @class:     CardIndex
    @version:    1.0.0
    @since:    15.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cardIndex")
public class CardIndex {
    @Id
    private String id;

    private String name;
    private String genre;


    private Date createdAt;
    private Date modifiedAt;
    private String description;
}

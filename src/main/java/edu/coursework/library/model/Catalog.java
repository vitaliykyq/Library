package edu.coursework.library.model;

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
@Document(collection = "catalog")
public class Catalog {
    @Id
    private String id;

    private List<CardIndex> cardIndexList;
    private String number;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}


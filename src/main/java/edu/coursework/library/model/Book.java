package edu.coursework.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "book")
public class Book {
    @Id
    private String id;

    private String name;
    private Author author;
    private int numberOfPages;
    private String dateOfArrival;
    private double price;
    private PublishingHouse publishingHouse;
    private CardIndex cardIndex;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}

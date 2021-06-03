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
@Document(collection = "bookOrder")
public class BookOrder {
    @Id
    private String id;

    private Book book;
    private String whenOrdered;
    private Reader reader;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}

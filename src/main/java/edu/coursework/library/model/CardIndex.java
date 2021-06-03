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
@Document(collection = "cardIndex")
public class CardIndex {
    @Id
    private String id;

    private String name;
    private String genre;
    private List<Book> bookList;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}

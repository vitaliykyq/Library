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

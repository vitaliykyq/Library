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
@Document(collection = "reader")
public class Reader {
    @Id
    private String id;

    private Person person;
    private String becameReader;
    private List<TakenBook> takenBookList;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}

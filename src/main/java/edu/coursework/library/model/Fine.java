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
@Document(collection = "fine")
public class Fine {
    @Id
    private String id;

    private String reasonForTheFine;
    private double price;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}

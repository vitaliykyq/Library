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
@Document(collection = "educationalInstitution")
public class EducationalInstitution {
    @Id
    private String id;

    private String chair;
    private String faculty;
    private int course;
    private String group;

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}

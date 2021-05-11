package edu.coursework.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    
    private String id;

    private String name;
    private String birth;
    private String death;
    private String country;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Author(String id, String name, String birth, String death, String country) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.death = death;
        this.country = country;
        this.created_at = LocalDateTime.now();
    }
}

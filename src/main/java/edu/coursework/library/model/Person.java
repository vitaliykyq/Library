package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Person {

    private static Integer numberId = new Integer(0);

    private String id;

    private String name;
    private String surname;
    private int age;
    private String gender;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Person(String name, String surname, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        numberId++;
        this.id = String.valueOf(new Integer(numberId));
    }
}

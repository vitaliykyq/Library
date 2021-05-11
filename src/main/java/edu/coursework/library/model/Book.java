package edu.coursework.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String id;

    private String name;
    private int useBook;
    private String yearIssue;
    private int amount;
    private int price;
    private String edition;
    private int penaltyLoss;
    private Author author;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Book(String id, String name, int useBook, String yearIssue, int amount,
                int price, String edition, int penaltyLoss, Author author) {
        this.id = id;
        this.name = name;
        this.useBook = useBook;
        this.yearIssue = yearIssue;
        this.amount = amount;
        this.price = price;
        this.edition = edition;
        this.penaltyLoss = penaltyLoss;
        this.author = author;
        this.created_at = LocalDateTime.now();
    }
}

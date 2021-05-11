package edu.coursework.library.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Data
public class Ticket {

    private String id;

    private ArrayList<TakenBook> takenBooks;
    private Date start;
    private Date finish;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

}
@Data
class TakenBook{
    private Date _return;
    private Book book;
    private boolean isReturn;
}
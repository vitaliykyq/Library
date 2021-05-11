package edu.coursework.library.data;

/*
    @author:    Vitaliy
    @project:    Library
    @class:    FakeData
    @version:    1.0.0
    @since:    15.04.2021
*/

import edu.coursework.library.model.Author;
import edu.coursework.library.model.Book;
import edu.coursework.library.model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class FakeData {

    private List<Author> authorList = new ArrayList<>(
            Arrays.asList(
                    new Author("1", "Vitaliy", "2020",
                            "2020", "Ukraine"),
                    new Author("2", "Vitaliy", "2020",
                            "2020", "Ukraine"),
                    new Author("3", "Vitaliy", "2020",
                            "2020", "Ukraine"),
                    new Author("4", "Vitaliy", "2020",
                            "2020", "Ukraine"),
                    new Author("5", "Vitaliy", "2020",
                            "2020", "Ukraine"),
                    new Author("6", "Vitaliy", "2020",
                            "2020", "Ukraine"),
                    new Author("7", "Vitaliy", "2020",
                            "2020", "Ukraine"),
                    new Author("8", "Vitaliy", "2020",
                            "2020", "Ukraine"),
                    new Author("9", "Vitaliy", "2020",
                            "2020", "Ukraine"),
                    new Author("10", "Vitaliy", "2020",
                            "2020", "Ukraine")));

    private List<Book> bookList = new ArrayList<>(
            Arrays.asList(
                    new Book("1", "Гаррі Поттер", 18,
                            "2020",
                            3, 1200, "А-БА-БА-ГА-ЛА-МА-ГА", 0, authorList.get(0)),
                    new Book("2", "Шерлок Холмс", 25,
                            "2020",
                            11, 2500, "А-БА-БА-ГА-ЛА-МА-ГА", 0, authorList.get(1)),
                    new Book("3", "Кафе на краю світу", 16,
                            "2020",
                            1, 130, "Віват", 0, authorList.get(2)),
                    new Book("4", "12 правил життя", 204,
                            "2020",
                            0, 231, "Наш Формат", 0, authorList.get(3)),
                    new Book("5", "Захар Беркут", 2,
                            "2020",
                            0, 400, "Наш Формат", 0, authorList.get(4))));

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}

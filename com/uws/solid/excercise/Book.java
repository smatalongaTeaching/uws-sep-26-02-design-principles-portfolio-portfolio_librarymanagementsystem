package com.uws.solid.excercise;


public class Book {
    private int id;
    private String title;
    private String author;
    private BookType bookType;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(int id, String title, String author, BookType bookType) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.bookType = bookType;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookType getBookType() {
        return bookType;
    }
}

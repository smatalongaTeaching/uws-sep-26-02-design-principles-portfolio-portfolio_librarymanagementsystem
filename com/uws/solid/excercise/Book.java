package com.uws.solid.excercise;


public class Book {// book class
    private int id;// changed to only hold data
    private String title;
    private String author;
    private String type; // "physical", "ebook", or "audio"

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book(int id, String title, String author, String type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
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

    public String getType() {
        return type;
    }
}

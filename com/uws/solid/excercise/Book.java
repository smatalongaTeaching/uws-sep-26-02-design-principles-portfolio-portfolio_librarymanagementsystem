package com.uws.solid.excercise;

public class Book {
    private int id;
    private String title;
    private String author;
    private LateFeePolicy lateFeePolicy;
    // Constructor, getters, setters...
    
    public Book(int id, String title, LateFeePolicy lateFeePolicy) {
        this.id = id;
        this.title = title;
        this.lateFeePolicy = lateFeePolicy;
    }
    
    public int getId() {
        return this.id;
    }
     public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
}
}

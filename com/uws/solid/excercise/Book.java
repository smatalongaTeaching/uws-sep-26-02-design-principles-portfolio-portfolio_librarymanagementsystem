package com.uws.solid.excercise;

public class Book {
    private int id;
    private String title;
    private boolean isAvailable;
    private int lendingPeriod;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }

    void markCheckedOut(int lendingPeriod) {
        this.isAvailable = false;
        this.lendingPeriod = lendingPeriod;
    }

    void markReturned() {
        this.isAvailable = true;
        this.lendingPeriod = 0;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getLendingPeriod() {
        return lendingPeriod;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
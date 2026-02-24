package com.uws.solid.excercise;


public class BookLending {// new lending class
    private final Book book;
    private boolean isAvailable;
    private int lendingPeriod;

    public BookLending(Book book) {
        this.book = book;
        this.isAvailable = true; // Default available
    }

    public void checkOut(int lendingPeriod) {
        if (isAvailable) {
            isAvailable = false;
            this.lendingPeriod = lendingPeriod;
        } else {
            throw new IllegalStateException("Book is already checked out: " + book.getTitle());
        }
    }

    public void returnBook() {
        isAvailable = true;
        this.lendingPeriod = 0;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getLendingPeriod() {
        return lendingPeriod;
    }

    public Book getBook() {
        return book;
    }
}

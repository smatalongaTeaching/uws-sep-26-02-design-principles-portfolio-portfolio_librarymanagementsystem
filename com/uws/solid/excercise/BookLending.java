package com.uws.solid.excercise;


public class BookLending {
    private final Book book;
    private boolean isAvailable;
    private int lendingPeriod;

    public BookLending(Book book) {
        this.book = book;
        this.isAvailable = true;
        this.lendingPeriod = LendingPeriod.NOT_CHECKED_OUT;
    }

    /**
     * Checks out the book using the standard lending period for its type.
     */
    public void checkOut() {
        checkOut(book.getBookType().getDefaultLendingPeriodDays());
    }

    /**
     * Checks out the book with an explicit lending period (e.g. for renewals or overrides).
     */
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
        this.lendingPeriod = LendingPeriod.NOT_CHECKED_OUT;
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

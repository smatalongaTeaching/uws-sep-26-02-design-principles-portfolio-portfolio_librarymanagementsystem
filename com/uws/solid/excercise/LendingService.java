package com.uws.solid.excercise;

public interface LendingService {
    void lend(Book book, int lendingPeriod);
    void returnBook(Book book);
    boolean isAvailable(Book book);
    int getLendingPeriod(Book book);
}
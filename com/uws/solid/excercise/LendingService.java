package com.uws.solid.excercise;

public interface LendingService {
    void lend(Book book, String patronType);
    void returnBook(Book book);
}
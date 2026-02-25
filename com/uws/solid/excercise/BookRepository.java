package com.uws.solid.excercise;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void add(Book book);
    Optional<Book> findById(int id);
    List<Book> findAll();
}
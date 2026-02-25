package com.uws.solid.excercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public Optional<Book> findById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }
}
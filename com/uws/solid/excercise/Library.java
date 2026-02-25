package com.uws.solid.excercise;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final BookRepository repository;
    private final LendingService lendingService;

    public Library(BookRepository repository, LendingService lendingService) {
        this.repository = repository;
        this.lendingService = lendingService;
    }

    public Library() {
        this(new InMemoryBookRepository(), new DefaultLendingService());
    }

    public void addBook(Book book) {
        repository.add(book);
    }

    public void lendBook(int bookId, String patronType) {
        repository.findById(bookId).ifPresent(book -> lendingService.lend(book, patronType));
    }
    
}


package com.uws.solid.excercise;

import java.util.HashMap;
import java.util.Map;

public class DefaultLendingService implements LendingService {
    private final Map<Integer, Boolean> availability = new HashMap<>();
    private final Map<Integer, Integer> lendingPeriods = new HashMap<>();

    @Override
    public void lend(Book book, int lendingPeriod) {
        if (!isAvailable(book)) throw new IllegalStateException("Book is already checked out: " + book.getTitle());
        availability.put(book.getId(), false);
        lendingPeriods.put(book.getId(), lendingPeriod);
    }

    @Override
    public void returnBook(Book book) {
        availability.put(book.getId(), true);
    }

    @Override
    public boolean isAvailable(Book book) {
        return availability.getOrDefault(book.getId(), true);
    }

    @Override
    public int getLendingPeriod(Book book) {
        return lendingPeriods.getOrDefault(book.getId(), 0);
    }
}
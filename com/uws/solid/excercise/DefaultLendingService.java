package com.uws.solid.excercise;

public class DefaultLendingService implements LendingService {

    @Override
    public void lend(Book book, String patronType) {
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already checked out: " + book.getTitle());
        }

        int lendingPeriod;
        if ("student".equals(patronType)) {
            lendingPeriod = LendingPeriods.STUDENT_DAYS;
        } else if ("faculty".equals(patronType)) {
            lendingPeriod = LendingPeriods.FACULTY_DAYS;
        } else {
            lendingPeriod = LendingPeriods.REGULAR_DAYS;
        }

        book.markCheckedOut(lendingPeriod);
    }

    @Override
    public void returnBook(Book book) {
        book.markReturned();
    }
}
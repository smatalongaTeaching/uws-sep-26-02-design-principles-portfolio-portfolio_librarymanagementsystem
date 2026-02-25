package com.uws.solid.excercise;

/**
 * Calculates late fees for overdue books.
 * Responsibility: Apply the correct fee rate based on the book's type.
 *
 * Open/Closed Principle: This class is closed for modification.
 * It delegates the per-day rate to the BookType interface, so adding a
 * new book type never requires touching this calculator.
 */
public class LateFeeCalculator {

    public int calculateLateFee(Book book, int daysLate) {
        return daysLate * book.getBookType().getDailyLateFee();
    }
}

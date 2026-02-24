package com.uws.solid.excercise;

/**
 * Calculates late fees for overdue books.
 * Responsibility: Apply the correct fee rate based on the book's type.
 */
public class LateFeeCalculator {

    public int calculateLateFee(Book book, int daysLate) {
        switch (book.getType()) {
            case "physical": return daysLate * 1; // $1 per day
            case "ebook":    return daysLate * 2; // $2 per day
            case "audio":    return daysLate * 3; // $3 per day
            default:         return 0;
        }
    }
}

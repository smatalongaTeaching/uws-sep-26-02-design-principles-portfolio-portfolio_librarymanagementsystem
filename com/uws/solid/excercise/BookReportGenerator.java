package com.uws.solid.excercise;

/**
 * Generates human-readable reports about a book and its lending status.
 * Responsibility: Format and produce book reports only.
 */
public class BookReportGenerator {

    public String generateReport(Book book, BookLending lending) {
        String status = lending.isAvailable() ? "Available" : "Checked Out";
        return "Book Report: " + book.getTitle() + " by " + book.getAuthor() + " - " + status;
    }
}

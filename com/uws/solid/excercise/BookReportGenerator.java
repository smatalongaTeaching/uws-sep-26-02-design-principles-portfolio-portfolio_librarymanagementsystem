package com.uws.solid.excercise;


public class BookReportGenerator {

    public String generateReport(Book book, BookLending lending) {
        String status = lending.isAvailable() ? "Available" : "Checked Out";
        return "Book Report: " + book.getTitle() + " by " + book.getAuthor() + " - " + status;
    }
}

// Library.java - Modified to depend on BookType abstraction
package com.uws.solid.excercise;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<BookLending> bookLendings;
    private final BookReportGenerator reportGenerator;

    public Library() {
        this.bookLendings = new ArrayList<>();
        this.reportGenerator = new BookReportGenerator();
    }

    public void addBook(Book book) {
        bookLendings.add(new BookLending(book));
    }

    public void lendBook(int bookId, String patronType) {
        BookLending bookLending = findBookLending(bookId);
        int lendingPeriod = getLendingPeriod(patronType);
        bookLending.checkOut(lendingPeriod);
    }

    private BookLending findBookLending(int bookId) {
        return bookLendings.stream()
                .filter(lending -> lending.getBook().getId() == bookId)
                .findFirst()
                .orElse(null);
    }

    private int getLendingPeriod(String patronType) {
        if ("student".equals(patronType)) {
            return 14;
        } else if ("faculty".equals(patronType)) {
            return 30;
        } else {
            return 7;
        }
    }

    public String generateLibraryReport() {
        StringBuilder report = new StringBuilder("LIBRARY REPORT\n");
        report.append("Total books: ").append(bookLendings.size()).append("\n");
        long availableBooks = bookLendings.stream().filter(BookLending::isAvailable).count();
        report.append("Available books: ").append(availableBooks).append("\n");
        report.append("Checked out books: ").append(bookLendings.size() - availableBooks).append("\n");

        report.append("\nBOOK DETAILS:\n");
        for (BookLending bookLending : bookLendings) {
            report.append(reportGenerator.generateReport(bookLending.getBook(), bookLending)).append("\n");
        }
        return report.toString();
    }
}

package com.uws.solid.excercise;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    
    public Library() {
        this.books = new ArrayList<Book>();
    }
    
    public void addBook(Book book) {
        books.add(book);
        
    }
    
    public void lendBook(int bookId, String patronType) {
        Book book = findBook(bookId);
        if (book != null) {
            // Check patron eligibility
            int lendingPeriod = 0;
            if (patronType.equals("student")) {
                lendingPeriod = 14; // 14 days for students
            } else if (patronType.equals("faculty")) {
                lendingPeriod = 30; // 30 days for faculty
            } else {
                lendingPeriod = 7; // 7 days for regular patrons
            }
            
            // Checkout book
            book.checkOut(lendingPeriod);
            
            
        }
    }
    
    private Book findBook(int bookId) {
        return books.stream()
                .filter(book -> book.getId() == bookId)
                .findFirst()
                .orElse(null);
    }
    
    public String generateLibraryReport() {
        StringBuilder report = new StringBuilder("LIBRARY REPORT\n");
        report.append("Total books: ").append(books.size()).append("\n");
        
        long availableBooks = books.stream().filter(book -> book.isAvailable()).count();
        report.append("Available books: ").append(availableBooks).append("\n");
        report.append("Checked out books: ").append(books.size() - availableBooks).append("\n");
        
        // Detailed list of all books
        report.append("\nBOOK DETAILS:\n");
        for (Book book : books) {
            report.append(book.generateReport()).append("\n");
        }
        
        return report.toString();
    }
}


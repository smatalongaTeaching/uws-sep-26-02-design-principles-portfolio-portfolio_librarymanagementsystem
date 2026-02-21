package com.uws.solid.excercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private LendingService lendingService;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        lendingService = new DefaultLendingService();
        ReportService reportService = new DefaultReportService(lendingService);
        library = new Library(new DefaultPatronLoanPolicy(), lendingService, reportService);
        book1 = new Book(1, "Book One", new PhysicalLateFeePolicy());
        book2 = new Book(2, "Book Two", new EbookLateFeePolicy());
        book3 = new Book(3, "Book Three", new AudioLateFeePolicy());

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }
    @Test
    void testLendBookToStudent() {
       
        library.lendBook(1, "student");

        assertFalse(lendingService.isAvailable(book1));
        assertEquals(lendingService.getLendingPeriod(book1), 14);
    
    }

    @Test
    void testLendBookToFaculty() {
       

        library.lendBook(2, "faculty");

        assertFalse(lendingService.isAvailable(book2));
        assertEquals(lendingService.getLendingPeriod(book2),30);

        
    }

    @Test
    void testLendBookToRegularPatron() {
       

        library.lendBook(1, "guest");

        assertFalse(lendingService.isAvailable(book1));
        assertEquals(lendingService.getLendingPeriod(book1),7);
    }
}

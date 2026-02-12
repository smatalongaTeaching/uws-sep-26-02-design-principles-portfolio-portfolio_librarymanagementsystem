package com.uws.solid.excercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book(1, "Book One");
        book2 = new Book(2, "Book Two");
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    void testLendBookToStudent() {
       
        library.lendBook(1, "student");

        assertFalse(book1.isAvailable());
        assertEquals(book1.getlendingPeriod(), 14);

       
    }

    @Test
    void testLendBookToFaculty() {
       

        library.lendBook(2, "faculty");

        assertFalse(book2.isAvailable());
        assertEquals(book2.getlendingPeriod(),30);

        
    }

    @Test
    void testLendBookToRegularPatron() {
       

        library.lendBook(1, "guest");

        assertFalse(book1.isAvailable());
        assertEquals(book1.getlendingPeriod(),7);
    }
}

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

    // Test late fee calculation for Physical Books
    @Test
    void testPhysicalBookLateFeeCalculation() {
        LateFeePolicy physicalPolicy = new PhysicalLateFeePolicy();
        
        assertEquals(5, physicalPolicy.calculateLateFee(5)); // 5 days * $1
        assertEquals(10, physicalPolicy.calculateLateFee(10)); // 10 days * $1
        assertEquals(0, physicalPolicy.calculateLateFee(0)); // No late days
    }

    // Test late fee calculation for E-books
    @Test
    void testEbookLateFeeCalculation() {
        LateFeePolicy ebookPolicy = new EbookLateFeePolicy();
        
        assertEquals(10, ebookPolicy.calculateLateFee(5)); // 5 days * $2
        assertEquals(20, ebookPolicy.calculateLateFee(10)); // 10 days * $2
        assertEquals(0, ebookPolicy.calculateLateFee(0)); // No late days
    }

    // Test late fee calculation for Audio Books
    @Test
    void testAudioBookLateFeeCalculation() {
        LateFeePolicy audioPolicy = new AudioLateFeePolicy();
        
        assertEquals(15, audioPolicy.calculateLateFee(5)); // 5 days * $3
        assertEquals(30, audioPolicy.calculateLateFee(10)); // 10 days * $3
        assertEquals(0, audioPolicy.calculateLateFee(0)); // No late days
    }

    // Test returning a book
    @Test
    void testReturnBook() {
        library.lendBook(1, "student");
        assertFalse(lendingService.isAvailable(book1));

        lendingService.returnBook(book1);
        assertTrue(lendingService.isAvailable(book1));
    }

    // Test returning each book type
    @Test
    void testReturnPhysicalBook() {
        library.lendBook(1, "student");
        lendingService.returnBook(book1);
        assertTrue(lendingService.isAvailable(book1));
    }

    @Test
    void testReturnEbook() {
        library.lendBook(2, "faculty");
        lendingService.returnBook(book2);
        assertTrue(lendingService.isAvailable(book2));
    }

    @Test
    void testReturnAudioBook() {
        library.lendBook(3, "guest");
        lendingService.returnBook(book3);
        assertTrue(lendingService.isAvailable(book3));
    }

    // Test checking out already borrowed book
    @Test
    void testLendAlreadyCheckedOutBook() {
        library.lendBook(1, "student");
        
        assertThrows(IllegalStateException.class, () -> {
            lendingService.lend(book1, 14);
        });
    }

    // Test initial availability of all books
    @Test
    void testAllBooksInitiallyAvailable() {
        assertTrue(lendingService.isAvailable(book1));
        assertTrue(lendingService.isAvailable(book2));
        assertTrue(lendingService.isAvailable(book3));
    }

    // Test lending different book types to different patron types
    @Test
    void testLendPhysicalBookToStudent() {
        library.lendBook(1, "student");
        assertFalse(lendingService.isAvailable(book1));
        assertEquals(14, lendingService.getLendingPeriod(book1));
    }

    @Test
    void testLendEbookToFaculty() {
        library.lendBook(2, "faculty");
        assertFalse(lendingService.isAvailable(book2));
        assertEquals(30, lendingService.getLendingPeriod(book2));
    }

    @Test
    void testLendAudioBookToRegularPatron() {
        library.lendBook(3, "guest");
        assertFalse(lendingService.isAvailable(book3));
        assertEquals(7, lendingService.getLendingPeriod(book3));
    }

    // Test patron loan policy
    @Test
    void testPatronLoanPolicyForStudent() {
        PatronLoanPolicy policy = new DefaultPatronLoanPolicy();
        assertEquals(14, policy.getLendingPeriod("student"));
    }

    @Test
    void testPatronLoanPolicyForFaculty() {
        PatronLoanPolicy policy = new DefaultPatronLoanPolicy();
        assertEquals(30, policy.getLendingPeriod("faculty"));
    }

    @Test
    void testPatronLoanPolicyForRegularPatron() {
        PatronLoanPolicy policy = new DefaultPatronLoanPolicy();
        assertEquals(7, policy.getLendingPeriod("guest"));
    }

    // Test report generation
    @Test
    void testGenerateBookReportWhenAvailable() {
        ReportService reportService = new DefaultReportService(lendingService);
        String report = reportService.generateBookReport(book1);
        
        assertTrue(report.contains("Book One"));
        assertTrue(report.contains("Available"));
    }

    @Test
    void testGenerateBookReportWhenCheckedOut() {
        library.lendBook(1, "student");
        ReportService reportService = new DefaultReportService(lendingService);
        String report = reportService.generateBookReport(book1);
        
        assertTrue(report.contains("Book One"));
        assertTrue(report.contains("Checked Out"));
    }

    // Test library report generation
    @Test
    void testGenerateLibraryReport() {
        String report = library.generateLibraryReport();
        
        assertTrue(report.contains("LIBRARY REPORT"));
        assertTrue(report.contains("Total books: 3"));
        assertTrue(report.contains("Available books: 3"));
        assertTrue(report.contains("Checked out books: 0"));
    }

    @Test
    void testGenerateLibraryReportWithCheckedOutBooks() {
        library.lendBook(1, "student");
        library.lendBook(2, "faculty");
        
        String report = library.generateLibraryReport();
        
        assertTrue(report.contains("Total books: 3"));
        assertTrue(report.contains("Available books: 1"));
        assertTrue(report.contains("Checked out books: 2"));
    }

    // Test OCP: Adding new book type doesn't require modifying existing code
    @Test
    void testAddNewBookTypeWithoutModifyingExistingCode() {
        // Create a hypothetical new book type with custom late fee policy
        LateFeePolicy magazinePolicy = new LateFeePolicy() {
            @Override
            public int calculateLateFee(int daysLate) {
                return daysLate / 2; // $0.50 per day
            }
        };
        
        Book magazine = new Book(4, "Magazine Monthly", magazinePolicy);
        library.addBook(magazine);
        
        // Verify it integrates seamlessly
        assertTrue(lendingService.isAvailable(magazine));
        library.lendBook(4, "student");
        assertFalse(lendingService.isAvailable(magazine));
        
        // Verify late fee calculation works
        assertEquals(5, magazinePolicy.calculateLateFee(10)); // 10 days / 2
    }
}

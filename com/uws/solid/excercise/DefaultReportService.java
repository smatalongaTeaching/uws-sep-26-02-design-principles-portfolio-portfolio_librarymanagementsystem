package com.uws.solid.excercise;

public class DefaultReportService implements ReportService {
    private final LendingService lendingService;

    public DefaultReportService(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @Override
    public String generateBookReport(Book book) {
        boolean isAvailable = lendingService.isAvailable(book);
        return "Book Report: " + book.getTitle() + " by " + book.getAuthor() + " - " + (isAvailable ? "Available" : "Checked Out");
    }
}

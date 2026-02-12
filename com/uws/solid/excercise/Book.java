package com.uws.solid.excercise;

public class Book {
    private int id;
    private String title;
    private String author;
    private String type; // "physical", "ebook", or "audio"
    private boolean isAvailable;
    private int lendingPeriod;
    
    // Constructor, getters, setters...
    
    public Book(int i, String string) {
        this.id = i;
        this.title = string;
        this.isAvailable = true; // Default to available
        

    }

    public void checkOut(int lendingPeriod) {
        if (isAvailable) {
            isAvailable = false;
            this.lendingPeriod = lendingPeriod;
        } else {
            throw new IllegalStateException("Book is already checked out: " + title);
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getlendingPeriod() {
        return lendingPeriod;
    }   
    
    public void returnBook() {
        isAvailable = true;
    }
    
    public int calculateLateFee(int daysLate) {
        if (type.equals("physical")) {
            return daysLate * 1; // $1 per day
        } else if (type.equals("ebook")) {
            return daysLate * 2; // $2 per day
        } else if (type.equals("audio")) {
            return daysLate * 3; // $3 per day
        }
        return 0;
    }
    
    public String generateReport() {
        return "Book Report: " + title + " by " + author + " - " + (isAvailable ? "Available" : "Checked Out");
    }

    public int getId() {
        return this.id;
    }
}

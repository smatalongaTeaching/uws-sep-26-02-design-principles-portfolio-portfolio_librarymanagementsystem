package com.uws.solid.excercise;

/
public class LateFeeCalculator {

    public int calculateLateFee(Book book, int daysLate) {
        return daysLate * book.getBookType().getDailyLateFee();
    }
}

package com.uws.solid.excercise;

/**
 * NEW book type: Magazine.
 * Late fee: $4 per day.
 *
 * Open/Closed Principle in action:
 * This entire new type was added by creating ONE new file.
 * Book.java, LateFeeCalculator.java, BookLending.java, and
 * BookReportGenerator.java were NOT modified at all.
 */
public class MagazineType implements BookType {

    @Override
    public String getTypeName() {
        return "Magazine";
    }

    @Override
    public int getDailyLateFee() {
        return 4; // $4 per day
    }
}

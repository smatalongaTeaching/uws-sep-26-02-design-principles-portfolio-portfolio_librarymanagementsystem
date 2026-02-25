package com.uws.solid.excercise;

/**
 * Book type representing a physical (printed) book.
 * Late fee: $1 per day.
 */
public class PhysicalBookType implements BookType {

    @Override
    public String getTypeName() {
        return "Physical";
    }

    @Override
    public int getDailyLateFee() {
        return 1; // $1 per day
    }
}

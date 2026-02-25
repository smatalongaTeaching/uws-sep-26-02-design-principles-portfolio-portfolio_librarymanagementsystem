package com.uws.solid.excercise;

/**
 * Book type representing a digital eBook.
 * Late fee: $2 per day.
 */
public class EBookType implements BookType {

    @Override
    public String getTypeName() {
        return "eBook";
    }

    @Override
    public int getDailyLateFee() {
        return 2; // $2 per day
    }
}

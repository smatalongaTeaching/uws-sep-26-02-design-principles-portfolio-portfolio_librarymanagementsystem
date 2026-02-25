package com.uws.solid.excercise;

/**
 * Book type representing an audiobook.
 * Late fee: $3 per day.
 */
public class AudioBookType implements BookType {

    @Override
    public String getTypeName() {
        return "Audio";
    }

    @Override
    public int getDailyLateFee() {
        return 3; // $3 per day
    }
}

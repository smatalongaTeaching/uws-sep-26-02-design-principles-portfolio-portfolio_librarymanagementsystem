package com.uws.solid.excercise;

public class EbookLateFeePolicy implements LateFeePolicy {
    @Override
    public int calculateLateFee(int daysLate) {
        return daysLate * 2; // $2 per day
    }
}
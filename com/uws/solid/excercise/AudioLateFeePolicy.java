package com.uws.solid.excercise;

public class AudioLateFeePolicy implements LateFeePolicy {

    private static final int REGULAR_LATE_FEE_PER_DAY = 3;
    @Override
    public int calculateLateFee(int daysLate) {
        return daysLate * REGULAR_LATE_FEE_PER_DAY; 
    }
}
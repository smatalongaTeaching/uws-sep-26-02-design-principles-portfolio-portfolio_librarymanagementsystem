package com.uws.solid.excercise;

public class AudioLateFeePolicy implements LateFeePolicy {
    @Override
    public int calculateLateFee(int daysLate) {
        return daysLate * 3; // $3 per day
    }
}
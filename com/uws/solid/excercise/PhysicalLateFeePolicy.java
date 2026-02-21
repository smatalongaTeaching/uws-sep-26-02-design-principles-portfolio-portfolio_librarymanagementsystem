package com.uws.solid.excercise;

public class PhysicalLateFeePolicy implements LateFeePolicy {
    @Override
    public int calculateLateFee(int daysLate) {
        return daysLate * 1; // $1 per day
    }
}
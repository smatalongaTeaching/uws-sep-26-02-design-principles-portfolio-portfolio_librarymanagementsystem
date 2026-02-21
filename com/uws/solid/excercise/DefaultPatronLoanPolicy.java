package com.uws.solid.excercise;

public class DefaultPatronLoanPolicy implements PatronLoanPolicy {
    @Override
    public int getLendingPeriod(String patronType) {
        if ("student".equals(patronType)) return 14;
        if ("faculty".equals(patronType)) return 30;
        return 7;
    }
}

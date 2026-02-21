package com.uws.solid.excercise;

public class DefaultPatronLoanPolicy implements PatronLoanPolicy {
    private static final int STUDENT_LENDING_PERIOD_DAYS = 14;
    private static final int FACULTY_LENDING_PERIOD_DAYS = 30;
    private static final int REGULAR_LENDING_PERIOD_DAYS = 7;

    @Override
    public int getLendingPeriod(String patronType) {
        if ("student".equals(patronType)) return STUDENT_LENDING_PERIOD_DAYS;
        if ("faculty".equals(patronType)) return FACULTY_LENDING_PERIOD_DAYS;
        return REGULAR_LENDING_PERIOD_DAYS;
    }
}
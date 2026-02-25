package com.uws.solid.excercise;


public interface BookType {

    /** Returns the display name of this book type (e.g. "Physical", "eBook"). */
    String getTypeName();

    /** Returns the standard lending period for this type, in days. */
    int getDefaultLendingPeriodDays();

    /** Returns the late fee charged per day overdue, in dollars. */
    int getDailyLateFee();
}

package com.uws.solid.excercise;


public class PhysicalBookType implements BookType {

    @Override
    public String getTypeName() {
        return "Physical";
    }

    @Override
    public int getDefaultLendingPeriodDays() {
        return LendingPeriod.PHYSICAL_BOOK_DAYS;
    }

    @Override
    public int getDailyLateFee() {
        return LateFee.PHYSICAL_BOOK_PER_DAY;
    }
}

package com.uws.solid.excercise;


public class MagazineType implements BookType {

    @Override
    public String getTypeName() {
        return "Magazine";
    }

    @Override
    public int getDefaultLendingPeriodDays() {
        return LendingPeriod.MAGAZINE_DAYS;
    }

    @Override
    public int getDailyLateFee() {
        return LateFee.MAGAZINE_PER_DAY;
    }
}

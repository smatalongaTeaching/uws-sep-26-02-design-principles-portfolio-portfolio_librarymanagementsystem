package com.uws.solid.excercise;


public class EBookType implements BookType {

    @Override
    public String getTypeName() {
        return "eBook";
    }

    @Override
    public int getDefaultLendingPeriodDays() {
        return LendingPeriod.EBOOK_DAYS;
    }

    @Override
    public int getDailyLateFee() {
        return LateFee.EBOOK_PER_DAY;
    }
}

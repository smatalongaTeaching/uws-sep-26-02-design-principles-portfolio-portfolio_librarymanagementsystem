package com.uws.solid.excercise;


public class AudioBookType implements BookType {

    @Override
    public String getTypeName() {
        return "Audio";
    }

    @Override
    public int getDefaultLendingPeriodDays() {
        return LendingPeriod.AUDIO_BOOK_DAYS;
    }

    @Override
    public int getDailyLateFee() {
        return LateFee.AUDIO_BOOK_PER_DAY;
    }
}

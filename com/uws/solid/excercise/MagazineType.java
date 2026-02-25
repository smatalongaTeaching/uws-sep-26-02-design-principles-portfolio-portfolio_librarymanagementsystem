package com.uws.solid.excercise;


public class MagazineType implements BookType {

    @Override
    public String getTypeName() {
        return "Magazine";
    }

    @Override
    public int getDailyLateFee() {
        return 4;
    }
}

package com.uws.solid.excercise;


public class EBookType implements BookType {

    @Override
    public String getTypeName() {
        return "eBook";
    }

    @Override
    public int getDailyLateFee() {
        return 2;
    }
}

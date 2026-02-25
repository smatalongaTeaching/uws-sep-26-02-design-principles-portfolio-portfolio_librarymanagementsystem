package com.uws.solid.excercise;

public class PhysicalBookType implements BookType {

    @Override
    public String getTypeName() {
        return "Physical";
    }

    @Override
    public int getDailyLateFee() {
        return 1;
    }
}

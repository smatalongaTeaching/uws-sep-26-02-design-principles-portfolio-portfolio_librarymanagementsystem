package com.uws.solid.excercise;

s AudioBookType implements BookType {

    @Override
    public String getTypeName() {
        return "Audio";
    }

    @Override
    public int getDailyLateFee() {
        return 3;
    }
}

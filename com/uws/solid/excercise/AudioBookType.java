package com.uws.solid.excercise;

public class AudioBookType implements BookType {
    @Override public int lateFeePerDay() { return 3; }
    @Override public String name() { return "audio"; }
}
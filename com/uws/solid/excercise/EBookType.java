package com.uws.solid.excercise;

public class EBookType implements BookType {
    @Override public int lateFeePerDay() { return 2; }
    @Override public String name() { return "ebook"; }
}
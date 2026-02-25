package com.uws.solid.excercise;

public class PhysicalBookType implements BookType {
    @Override public int lateFeePerDay() { return 1; }
    @Override public String name() { return "physical"; }
}
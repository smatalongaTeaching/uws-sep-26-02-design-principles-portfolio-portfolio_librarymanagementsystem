package com.uws.solid.excercise;

public final class LendingPeriods {
    private LendingPeriods() {}

    public static int STUDENT_DAYS = 14;
    public static int FACULTY_DAYS = 30;
    public static int REGULAR_DAYS = 7;

    public static void updateStudentDays(int days){
        STUDENT_DAYS = days;
    }

    public static void updateFacultyDays(int days){
        FACULTY_DAYS = days;
    }

    public static void updateRegularDays(int days){
        REGULAR_DAYS = days;
    }

}
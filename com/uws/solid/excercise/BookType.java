package com.uws.solid.excercise;

/**
 * Defines the behaviour that every book type must provide.
 *
 * Open/Closed Principle: This interface is the extension point.
 * To add a new book type, implement this interface in a new class —
 * no existing code needs to change.
 */
public interface BookType {

    /** Returns the display name of this book type (e.g. "Physical", "eBook"). */
    String getTypeName();

    /** Returns the late fee charged per day overdue, in dollars. */
    int getDailyLateFee();
}

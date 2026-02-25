package com.uws.solid.excercise;


public final class LendingPeriod {

    // Standard lending periods by book type
    public static final int PHYSICAL_BOOK_DAYS = 14;
    public static final int EBOOK_DAYS         = 7;
    public static final int AUDIO_BOOK_DAYS    = 21;
    public static final int MAGAZINE_DAYS      = 3;

    // Sentinel value used when a book is returned / not checked out
    public static final int NOT_CHECKED_OUT = 0;

    private LendingPeriod() {
        // Utility class — not instantiable
    }
}

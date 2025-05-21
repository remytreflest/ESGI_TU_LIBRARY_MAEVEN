package library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    void testNullTitleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Book(null, "Author", 2000));
    }

    @Test
    void testEmptyAuthorThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Title", "   ", 2000));
    }

    @Test
    void testNegativeYearThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Book("Title", "Author", -1));
    }
}
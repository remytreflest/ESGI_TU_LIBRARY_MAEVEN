package library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {
    @Test
    void testAddition() {
        assertEquals(5, Library.addition(2, 3));
    }
}

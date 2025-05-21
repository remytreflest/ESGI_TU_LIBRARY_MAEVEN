package library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setup() {
        library = new Library();
        book1 = new Book("1984", "George Orwell", 1949);
        book2 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943);
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    void testAddBook() {
        Book newBook = new Book("Dune", "Frank Herbert", 1965);
        library.addBook(newBook);
        assertTrue(library.getAllBooks().contains(newBook));
    }

    @Test
    void testRemoveBook() {
        boolean removed = library.removeBook("1984");
        assertTrue(removed);
        assertFalse(library.getAllBooks().contains(book1));
    }

    @Test
    void testFindBook_caseInsensitive() {
        Optional<Book> found = library.findBook("le petit prince");
        assertTrue(found.isPresent());
        assertEquals(book2, found.get());
    }

    @Test
    void testGetAllBooks() {
        List<Book> allBooks = library.getAllBooks();
        assertEquals(2, allBooks.size());
        assertTrue(allBooks.contains(book1));
        assertTrue(allBooks.contains(book2));
    }

    // TEST supplémentaires

    @Test
    void testAddNullBookThrowsException() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    void testAddDuplicateBookThrowsException() {
        Library library = new Library();
        library.addBook(new Book("Dune", "Frank Herbert", 1965));
        assertThrows(IllegalArgumentException.class, () ->
                library.addBook(new Book("DUNE", "Somebody", 2000))); // même titre
    }

    @Test
    void testRemoveWithNullTitleThrowsException() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(null));
    }

    @Test
    void testFindWithEmptyTitleThrowsException() {
        Library library = new Library();
        assertThrows(IllegalArgumentException.class, () -> library.findBook(" "));
    }
}

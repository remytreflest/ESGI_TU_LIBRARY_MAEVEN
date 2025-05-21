package library;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryFunctionalTest {

    @Test
    void testCompleteScenario() {
        Library library = new Library();

        List<Book> emptyBooks = library.getAllBooks();

        System.out.println("ETAPE 0 : Pas de livre dans la librairie :");
        emptyBooks.forEach(System.out::println);

        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943);
        Book book3 = new Book("Dune", "Frank Herbert", 1965);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<Book> allBooks = library.getAllBooks();

        System.out.println("ETAPE 1 : Liste des livres ajoutés :");
        allBooks.forEach(System.out::println);

        assertEquals(3, allBooks.size());
        assertTrue(allBooks.contains(book1));
        assertTrue(allBooks.contains(book2));
        assertTrue(allBooks.contains(book3));

        boolean removed = library.removeBook("Le Petit Prince");
        assertTrue(removed);

        List<Book> remainingBooks = library.getAllBooks();
        assertEquals(2, remainingBooks.size());
        assertTrue(remainingBooks.contains(book1));
        assertTrue(remainingBooks.contains(book3));
        assertFalse(remainingBooks.contains(book2));

        System.out.println("ETAPE 2 : Livres restants après la suppression du Le Petit Prince :");
        remainingBooks.forEach(System.out::println);
    }
}

package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {

        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        boolean alreadyExists = books.stream()
                .anyMatch(b -> b.getTitle().equalsIgnoreCase(book.getTitle()));

        if (alreadyExists) {
            throw new IllegalArgumentException("A book with this title already exists in the library");
        }

        books.add(book);
    }

    public boolean removeBook(String title) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        return books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public Optional<Book> findBook(String title) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}

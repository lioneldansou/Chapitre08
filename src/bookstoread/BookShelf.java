package bookstoread;
import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {

    private final List<Book> books = new ArrayList<>();

    public List<Book> books() {
        // immutable
        return List.copyOf(books);
    }

    // Ajout de plusieurs livres à la fois
    public void add(Book... newBooks) {
        books.addAll(Arrays.asList(newBooks));
    }

    public List<Book> arrange() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();
    }
}
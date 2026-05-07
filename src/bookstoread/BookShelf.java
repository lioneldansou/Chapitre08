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
        return arrange(Comparator.naturalOrder());
    }

    public List<Book> arrange(Comparator<Book> criteria) {
        return books.stream().sorted(criteria).collect(Collectors.toList());
    }
}
package bookstoread;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookShelfSpec {

    private BookShelf shelf;

    private Book effectiveJava;
    private Book codeComplete;
    private Book mythicalManMonth;

    @BeforeEach
    void init() {
        shelf = new BookShelf();

        effectiveJava = new Book("Effective Java", "Bloch", LocalDate.now());
        codeComplete = new Book("Code Complete", "McConnell", LocalDate.now());
        mythicalManMonth = new Book("The Mythical Man-Month", "Brooks", LocalDate.now());
    }

    @Test
    public void shelfEmptyWhenNoBookAdded() {
        assertTrue(shelf.books().isEmpty());
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        shelf.add(effectiveJava, codeComplete);
        assertEquals(2, shelf.books().size());
    }

    @Test
    public void emptyBookShelfWhenAddIsCalledWithoutBooks() {
        shelf.add();
        assertTrue(shelf.books().isEmpty());
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        shelf.add(effectiveJava, codeComplete);
        List<Book> books = shelf.books();

        assertThrows(UnsupportedOperationException.class, () -> {
            books.add(mythicalManMonth);
        });
    }

    @Test
    void bookshelfArrangedByBookTitle() {
        shelf.add(effectiveJava, codeComplete, mythicalManMonth);

        List<Book> books = shelf.arrange();

        assertEquals(
                Arrays.asList(codeComplete, effectiveJava, mythicalManMonth),
                books
        );
    }

    @Test
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        shelf.add(effectiveJava, codeComplete, mythicalManMonth);

        shelf.arrange(); // ne doit PAS modifier

        assertEquals(
                Arrays.asList(effectiveJava, codeComplete, mythicalManMonth),
                shelf.books()
        );
    }
}
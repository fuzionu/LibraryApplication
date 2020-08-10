package books;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

import static books.Cover.*;
import static books.Status.*;
import static org.junit.jupiter.api.Assertions.*;
import static java.util.Arrays.asList;


class BooksRepositoryTest
{
    @Test
    void shouldAddBook()
    {
        // given
        BooksRepository books = new BooksRepository();
        Book book = new Book("Gavin Englishman", "Where is he?", HARD, 471599, 99, 3, 47.15, 2.50, IN_STOCK);

        // when
        books.addBook(book);

        // then
        assertTrue(books.setOfBooks.contains(book));
    }

    @Test
    void shouldDeleteBook()
    {
        // given
        BooksRepository books = new BooksRepository();
        Book book = new Book("J. R. R. Tolkien", "Silmarillion", SOFT, 5239482, 482, 5, 52.39, 6.30, IN_STOCK);

        // when
        books.deleteBook(book);

        // then
        assertFalse(books.setOfBooks.contains(book));
    }

    @Test
    void shouldChangeBookStatus()
    {
        // given
        BooksRepository books = new BooksRepository();
        Book book = new Book("J. R. R. Tolkien", "Silmarillion", SOFT, 5239482, 482, 5, 52.39, 6.30, IN_STOCK);

        // when
        books.changeBookStatus(book, LOAN);

        // then
        assertEquals(LOAN, books.getBookById(book.id).status);
    }

    @Test
    void shouldChangeSellPrice()
    {
        // given
        BooksRepository books = new BooksRepository();
        Book book = new Book("Juan Gonzales", "Narcos", HARD, 109110, 10, 1, 10.91, 0.55, IN_STOCK);

        // when
        books.changeSellPrice(book, 20.20);

        // then
        assertEquals(20.20, books.getBookById(book.id).sellPrice);
    }

    @Test
    void shouldChangeLoanPrice()
    {
        // given
        BooksRepository books = new BooksRepository();
        Book book = new Book("Stephen King", "Shining", SOFT, 3199520, 520, 4, 31.99, 2.80, DAMAGED);

        // when
        books.changeLoanPrice(book, 3.05);

        // then
        assertEquals(3.05, books.getBookById(book.id).loanPrice);
    }

    @Test
    void shouldGetBookByTitle()
    {
        // given
        String title = "Shining";

        // when
        Book actual = new BooksRepository().getBookByTitle(title);

        // then
        assertEquals("Shining", actual.title);
    }

    @Test
    void shouldGetBookById()
    {
        // given
        int id = 5239482;

        // when
        Book actual = new BooksRepository().getBookById(id);

        // then
        assertEquals(5239482, actual.id);
    }

    @Test
    void shouldGetBooksByCover()
    {
        // given
        Cover cover = HARD;

        // when
        Set<Book> actual = new BooksRepository().getBooksByCover(cover);

        // then
        Set<Book> expected = new LinkedHashSet<>(asList(
            new Book("George R. R. Martin", "A Game of Thrones", HARD, 7099844, 844, 5, 70.99, 9.50, LOAN),
            new Book("John Smith", "English Encyclopedia", HARD, 9999100, 100, 1, 99.99, 21.22, SOLD),
            new Book("Juan Gonzales", "Narcos", HARD, 109110, 10, 1, 10.91, 0.55, IN_STOCK)
        ));

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetBooksBySellPriceWithRange()
    {
        // given
        double rangeMin = 0;
        double rangeMax = 50;

        // when
        Set<Book> actual = new BooksRepository().getBooksBySellPrice(rangeMin, rangeMax);

        // then
        Set<Book> expected = new LinkedHashSet<>(asList(
                new Book("Stephen King", "Shining", SOFT, 3199520, 520, 4, 31.99, 2.80, DAMAGED),
                new Book("Juan Gonzales", "Narcos", HARD, 109110, 10, 1, 10.91, 0.55, IN_STOCK),
                new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK)
        ));

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetBooksByLoanPriceWithRange()
    {
        // given
        double rangeMin = 0.95;
        double rangeMax = 9.99;

        // when
        Set<Book> actual = new BooksRepository().getBooksByLoanPrice(rangeMin, rangeMax);

        // then
        Set<Book> expected = new LinkedHashSet<>(asList(
                new Book("J. R. R. Tolkien", "Silmarillion", SOFT, 5239482, 482, 5, 52.39, 6.30, IN_STOCK),
                new Book("George R. R. Martin", "A Game of Thrones", HARD, 7099844, 844, 5, 70.99, 9.50, LOAN),
                new Book("Stephen King", "Shining", SOFT, 3199520, 520, 4, 31.99, 2.80, DAMAGED),
                new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK)
        ));

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetBooksByStatus()
    {
        // given
        Status status = IN_STOCK;

        // when
        Set<Book> actual = new BooksRepository().getBooksByStatus(status);

        // then
        Set<Book> expected = new LinkedHashSet<>(asList(
            new Book("J. R. R. Tolkien", "Silmarillion", SOFT, 5239482, 482, 5, 52.39, 6.30, IN_STOCK),
            new Book("Juan Gonzales", "Narcos", HARD, 109110, 10, 1, 10.91, 0.55, IN_STOCK),
            new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK)
        ));

        assertEquals(expected, actual);
    }
}
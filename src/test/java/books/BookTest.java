package books;

import org.junit.jupiter.api.Test;

import static books.Cover.SOFT;
import static books.Status.IN_STOCK;
import static org.junit.jupiter.api.Assertions.*;

class BookTest
{
    @Test
    void shouldGetAuthor()
    {
        // given
        Book book = new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK);

        // when
        String actualAuthor = book.getAuthor();

        // then
        assertEquals("Jessie James", actualAuthor);
    }

    @Test
    void shouldGetTitle()
    {
        // given
        Book book = new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK);

        // when
        String actualTitle = book.getTitle();

        // then
        assertEquals("For four", actualTitle);
    }

    @Test
    void shouldGetId()
    {
        // given
        Book book = new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK);

        // when
        int actualId = book.getId();

        // then
        assertEquals(148144, actualId);
    }

    @Test
    void shouldGetSellPrice()
    {
        // given
        Book book = new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK);

        // when
        double actualSellPrice = book.getSellPrice();

        // then
        assertEquals(14.81, actualSellPrice);
    }

    @Test
    void shouldGetLoanPrice()
    {
        // given
        Book book = new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK);

        // when
        double actualLoanPrice = book.getLoanPrice();

        // then
        assertEquals(1.25, actualLoanPrice);
    }

    @Test
    void shouldGetStatus()
    {
        // given
        Book book = new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK);

        // when
        Status actualStatus = book.getStatus();

        // then
        assertEquals(IN_STOCK, actualStatus);
    }
}
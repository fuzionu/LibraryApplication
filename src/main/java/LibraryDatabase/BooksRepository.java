package LibraryDatabase;

import LibraryDatabase.exceptions.WrongIdException;
import LibraryDatabase.exceptions.WrongTitleException;

import java.util.LinkedHashSet;
import java.util.Set;

import static LibraryDatabase.Cover.*;
import static LibraryDatabase.Status.*;
import static java.util.Arrays.asList;

public class BooksRepository
{
    public Set<Book> setOfBooks = getAllBooks();

    public void addBook(Book book)
    {
        setOfBooks.add(book);
    }

    public void deleteBook(Book book)
    {
        setOfBooks.remove(book);
    }

    public void changeBookStatus(Book book, Status status)
    {
        for (Book bookFromSet : setOfBooks)
        {
            if (bookFromSet.id == book.id)
            {
                bookFromSet.status = status;
            }
        }
    }

    public void changeSellPrice(Book book, double price)
    {
        for (Book bookFromSet : setOfBooks)
        {
            if (bookFromSet.id == book.id)
            {
                bookFromSet.sellPrice = price;
            }
        }
    }

    public void changeLoanPrice(Book book, double price)
    {
        for (Book bookFromSet : setOfBooks)
        {
            if (bookFromSet.id == book.id)
            {
                bookFromSet.loanPrice = price;
            }
        }
    }

    public Book getBookById(int id)
    {
        for (Book book : setOfBooks)
        {
            if (book.id == id)
            {
                return book;
            }
        }

        throw new WrongIdException();
    }

    public Book getBookByTitle(String title)
    {
        for (Book book : setOfBooks)
        {
            if (book.title.equalsIgnoreCase(title))
            {
                return book;
            }
        }

        throw new WrongTitleException();
    }

    public Set<Book> getBooksByCover(Cover cover)
    {
        Set<Book> books = new LinkedHashSet<>();

        for (Book book : setOfBooks)
        {
            if (book.cover == cover)
            {
                books.add(book);
            }
        }

        return books;
    }

    public Set<Book> getBooksBySellPrice(double priceMin, double priceMax)
    {
        Set<Book> books = new LinkedHashSet<>();

        for (Book book : setOfBooks)
        {
            if (book.sellPrice >= priceMin && book.sellPrice <= priceMax)
            {
                books.add(book);
            }
        }

        return books;
    }

    public Set<Book> getBooksByLoanPrice(double priceMin, double priceMax)
    {
        Set<Book> books = new LinkedHashSet<>();

        for (Book book : setOfBooks)
        {
            if (book.loanPrice >= priceMin && book.loanPrice <= priceMax)
            {
                books.add(book);
            }
        }

        return books;
    }

    public Set<Book> getBooksByStatus(Status status)
    {
        Set<Book> books = new LinkedHashSet<>();

        for (Book book : setOfBooks)
        {
            if (book.status == status)
            {
                books.add(book);
            }
        }

        return books;
    }

    private Set<Book> getAllBooks()
    {
        return new LinkedHashSet<>(asList(
                new Book("J. R. R. Tolkien", "Silmarillion", SOFT, 5239482, 482, 5, 52.39, 6.30, IN_STOCK),
                new Book("George R. R. Martin", "A Game of Thrones", HARD, 7099844, 844, 5, 70.99, 9.50, LOAN),
                new Book("Stephen King", "Shining", SOFT, 3199520, 520, 4, 31.99, 2.80, DAMAGED),
                new Book("John Smith", "English Encyclopedia", HARD, 9999100, 100, 1, 99.99, 21.22, SOLD),
                new Book("Juan Gonzales", "Narcos", HARD, 109110, 10, 1, 10.91, 0.55, IN_STOCK),
                new Book("Jessie James", "For four", SOFT, 148144, 44, 2, 14.81, 1.25, IN_STOCK)
        ));
    }
}

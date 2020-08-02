package LibraryDatabase;

public class Book
{
    final String author;
    final String title;
    final Cover cover;
    final int id;
    final int pages;
    final int chapters;
    double sellPrice;
    double loanPrice;
    Status status;

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }

        if (object == null || object.getClass() != this.getClass())
        {
            return false;
        }

        Book book = (Book) object;
        return author.equals(book.author) && title.equals(book.title) && cover == book.cover &&
                id == book.id && pages == book.pages && chapters == book.chapters &&
                sellPrice == book.sellPrice && loanPrice == book.loanPrice && status == book.status;
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    public Book(String author, String title, Cover cover, int id, int pages, int chapters,
                double sellPrice, double loanPrice, Status status)
    {
        this.author = author;
        this.title = title;
        this.cover = cover;
        this.id = id;
        this.pages = pages;
        this.chapters = chapters;
        this.sellPrice = sellPrice;
        this.loanPrice = loanPrice;
        this.status = status;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getTitle()
    {
        return title;
    }

    public int getId()
    {
        return id;
    }
}

package LibraryDatabase;

public class Book
{
    final String author;
    final String title;
    final Cover cover;
    final int id;
    final int pages;
    final int chapters;
    final double sellPrice;
    final double loanPrice;
    Status status;

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
}

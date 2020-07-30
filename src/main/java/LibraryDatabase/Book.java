package LibraryDatabase;

public class Book
{
    private final String author;
    private final String title;
    private final Cover cover;
    private final int id;
    private final int pages;
    private final int chapters;
    private final double sellPrice;
    private final double loanPrice;
    private Status status;

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

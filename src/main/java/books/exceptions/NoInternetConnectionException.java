package books.exceptions;

public class NoInternetConnectionException extends RuntimeException
{
    public NoInternetConnectionException(Throwable throwable)
    {
        super(throwable);
    }
}


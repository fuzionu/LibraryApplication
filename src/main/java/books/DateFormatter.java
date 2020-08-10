package books;

public class DateFormatter
{
    private final API api;

    public DateFormatter(API api)
    {
        this.api = api;
    }

    public String formatFullDate()
    {
        String date = formatDate();
        String time = formatTime();

        return date + ", " + time;
    }

    private String formatTime()
    {
        String[] splittedDateTime = splitDateTime("\\.");
        return splittedDateTime[0].split("T")[1];
    }

    private String formatDate()
    {
        String date = splitDateTime("T")[0];


        String day = date.substring(8, 10);
        String month = date.substring(5, 7);
        String year = date.substring(0, 4);

        return day + "." + month + "." + year;
    }

    private String[] splitDateTime(String splitter)
    {
        return api.getCurrentTime().split(splitter);
    }

    public static class MalformedJsonException extends RuntimeException
    {
        public MalformedJsonException(Throwable throwable)
        {
            super(throwable);
        }
    }

    public static class NoInternetConnectionException extends RuntimeException
    {
        public NoInternetConnectionException(Throwable throwable)
        {
            super(throwable);
        }
    }
}

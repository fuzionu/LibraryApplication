package books;

import books.exceptions.NoInternetConnectionException;

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
        return splitDateTime("\\.")[0].split("T")[1];
    }

    private String formatDate()
    {
        try
        {
            String date = splitDateTime("T")[0];

            String day = date.substring(8, 10);
            String month = date.substring(5, 7);
            String year = date.substring(0, 4);

            return day + "." + month + "." + year;
        }
        catch (NoInternetConnectionException exc)
        {
            return "No internet connection";
        }
    }

    private String[] splitDateTime(String splitter)
    {
        return api.getCurrentTime().split(splitter);
    }
}

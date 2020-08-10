package LibraryDatabase;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.net.MalformedURLException;

public class DateFormatter
{
    private final API api;

    public DateFormatter(API api)
    {
        this.api = api;
    }

    public String formatFullDate()
    {
        try
        {
            return tryFormatFullDate();
        }
        catch (MalformedURLException | JsonMappingException exc)
        {
            throw new RuntimeException();
        }
        catch (JsonParseException exc)
        {
            throw new MalformedJsonException(exc);
        }
        catch (IOException exc)
        {
            throw new NoInternetConnectionException(exc);
        }
    }

    private String tryFormatFullDate() throws IOException
    {
        String date = formatDate();
        String time = formatTime();

        return date + ", " + time;
    }


    private String formatTime() throws IOException
    {
        String[] splittedDateTime = splitDateTime("\\.");
        String fullTime = splittedDateTime[0].split("T")[1];

        return fullTime;
    }

    private String formatDate() throws IOException
    {
        String[] dateTime = splitDateTime("T");
        String date = dateTime[0];

        String day = getSubstring(date, 8, 10);
        String month = getSubstring(date, 5, 7);
        String year = getSubstring(date, 0, 4);

        return day + "." + month + "." + year;
    }

    private String getSubstring(String date, int startIndex, int endIndex)
    {
        String substring = date.substring(startIndex, endIndex);
        return substring;
    }

    private String[] splitDateTime(String splitter) throws IOException
    {
        String[] dateTime = api.getCurrentTime().split(splitter);
        return dateTime;
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

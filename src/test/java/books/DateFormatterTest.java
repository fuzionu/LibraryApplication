package books;

import org.junit.jupiter.api.Test;

import static books.DateFormatter.MalformedJsonException;
import static books.DateFormatter.NoInternetConnectionException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DateFormatterTest
{
    @Test
    void shouldFormatFullData()
    {
        // given
        DateFormatter dateFormatter = new DateFormatter(mockAPI());

        // when
        String actual = dateFormatter.formatFullDate();

        // then
        assertEquals("10.08.2020, 23:10:00", actual);
    }

    @Test
    void shouldThrowRuntimeException()
    {
        // given
        DateFormatter dateFormatter = new DateFormatter(mockAPIThrowingExc(RuntimeException.class));

        // then
        assertPrecisely(RuntimeException.class, dateFormatter::formatFullDate);
    }

    @Test
    void shouldThrowMalformedJsonException()
    {
        // given
        DateFormatter dateFormatter = new DateFormatter(mockAPIThrowingExc(MalformedJsonException.class));

        // then
        assertPrecisely(MalformedJsonException.class, dateFormatter::formatFullDate);
    }

    @Test
    void shouldThrowNoInternetConnectionException()
    {
        // given
        DateFormatter dateFormatter = new DateFormatter(mockAPIThrowingExc(NoInternetConnectionException.class));

        // then
        assertPrecisely(NoInternetConnectionException.class, dateFormatter::formatFullDate);
    }

    private void assertPrecisely(Class<? extends Exception> excType, Runnable runnable)
    {
        Exception exception = assertThrows(excType, runnable::run);
        assertEquals(excType, exception.getClass());
    }

    private API mockAPI()
    {
        API api = mock(API.class);

        when(api.getCurrentTime()).thenReturn(fullJsonData());

        return api;
    }

    private API mockAPIThrowingExc(Class<? extends Exception> exc)
    {
        API api = mock(API.class);
        when(api.getCurrentTime()).thenThrow(exc);

        return api;
    }

    private String fullJsonData()
    {
        return "2020-08-10T23:10:00.326942+02:00";
    }
}
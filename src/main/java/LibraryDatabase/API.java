package LibraryDatabase;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class API
{
    public String getCurrentTime() throws IOException
    {
        Map map = new ObjectMapper().readValue(new URL("https://worldtimeapi.org/api/timezone/Europe/Warsaw"), Map.class);
        return (String) map.get("datetime");
    }
}

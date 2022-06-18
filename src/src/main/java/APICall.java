
import org.json.*;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class APICall
{
    static Map<String, String> propData;

    static {
        try
        {
            propData = Util.getProperties("src/src/main/java/conf.properties");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static final String URL= propData.get("URL");
    public static void main(String[] args) throws Exception
    {
        GetUser userObj = new GetUser();
        String baseurl = URL+"/?language="+propData.get("LANGUAGE").toString();
        JSONObject users = GetUser.getRequest(baseurl);
        if(users != null)
        {
            System.out.println(users);
        }
        else
            System.out.println("No Data fetched...!!! :( ");
    }
}


import java.io.*;
import java.net.*;

import org.json.*;

public class GetUser
{
    public static JSONArray getRequest(String url) throws IOException, JSONException
    {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("accept","application/JSON");
        String result = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
        //System.out.println(result);
        //result = result.substring(1, result.length() - 1);
        System.out.println(result);
        JSONArray response = new JSONArray(result);
        //System.out.println(response);
        return response;
    }
}

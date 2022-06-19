
import org.json.*;

import java.io.FileWriter;
import java.io.IOException;
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
    public static FileWriter file;
    public static final String URL= propData.get("URL");
    public static void main(String[] args) throws Exception
    {
        String baseurl = URL+"/?language="+propData.get("LANGUAGE");
        JSONArray users = GetUser.getRequest(baseurl);
        //noinspection ConstantConditions
        file = new FileWriter("src/src/main/java/output.json");
        try
        {
            for (int i  = 0; i < users.length(); i++)
            {
                JSONObject obj = users.getJSONObject(i);
                file.write(obj.toString());
            }
        }
        catch (JSONException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                file.flush();
                file.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

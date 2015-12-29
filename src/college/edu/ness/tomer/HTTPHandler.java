package college.edu.ness.tomer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Dev on 29/12/2015.
 */
public class HTTPHandler {
    public static InputStream getHTTP(String path){
        HttpURLConnection con = null;
        try {
            String s = "http://openweathermap.org/api";
            URL url = new URL(path);
            con =
                    (HttpURLConnection)url.openConnection();
            int statusCode = con.getResponseCode();
            InputStream in = con.getInputStream();
            return in;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
           // if (con!=null)
               // con.disconnect();
        }
        return null;
    }

}

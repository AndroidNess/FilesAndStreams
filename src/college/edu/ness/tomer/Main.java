package college.edu.ness.tomer;

import college.edu.ness.tomer.entities.Coord;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.InputStream;

public class Main {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?zip=94040,us&appid=2de143494c0b295cca9337e1e96b00e0";

    public static void main(String[] args) {
        InputStream in = HTTPHandler.getHTTP(WEATHER_URL);
        String data = IOUtils.read(in);
        JSONParser parser =  new JSONParser();
        try {
            JSONObject result = (JSONObject)parser.parse(data);
            JSONObject coord = (JSONObject) result.get("coord");
            Coord c = new Coord(coord);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}

package college.edu.ness.tomer.entities;

import org.json.simple.JSONObject;

public class Coord
{

    public Coord(JSONObject json){
        //parse this json to the fields
        Double lon = (Double) json.get("lon");
        Double lat = (Double) json.get("lat");
        this.lon = lon.toString();
        this.lat = lat.toString();
        //And so on
    }
    private String lon;

    private String lat;

    public String getLon ()
    {
        return lon;
    }

    public void setLon (String lon)
    {
        this.lon = lon;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [lon = "+lon+", lat = "+lat+"]";
    }
}
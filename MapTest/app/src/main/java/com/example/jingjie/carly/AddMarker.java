package com.example.jingjie.carly;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

/**
 * Created by Jingjie on 3/9/2017.
 */

class AddMarker
{
    public static ArrayList<Station> stationList=new ArrayList<>();

    public static void addStation()
    {
        //mid left
        //cw
        stationList.add(new Station("Etiwanda/Mike Curbs walk", "NH",  34.236917, -118.531557,"clockwise"));
        stationList.add(new Station("Matador Walk/ Prai rie St.", "UN", 34.239140, -118.531606,"clockwise"));
        stationList.add(new Station("Etiwanda/ Jacaranda walk", "EU", 34.240957, -118.531616,"clockwise"));
        //ccw
        stationList.add(new Station("Etiwanda/Mike Curbs walk", "NH", 34.236790, -118.531904,"counterClockwise"));
        stationList.add(new Station("Matador Walk/ Prai rie St.", "UN", 34.239306, -118.531855,"counterClockwise"));
        stationList.add(new Station("Etiwanda/ Jacaranda walk", "EU", 34.241102, -118.531876,"counterClockwise"));




        //mid right
        //cw
        stationList.add(new Station("Jacaranda walk/ Lindley Ave.","JD",34.240870, -118.527476,"clockwise"));
        stationList.add(new Station("Matador walk/ Lindley Ave.","CS",34.239097, -118.527448,"clockwise"));
        stationList.add(new Station("Mike Curbs walk/ Lindley Ave.","BK",34.236871, -118.527472,"clockwise"));
        //ccw
        stationList.add(new Station("Jacaranda walk/ Lindley Ave.","JD",34.240992, -118.527265,"counterClockwise"));
        stationList.add(new Station("Matador walk/ Lindley Ave.","CS",34.239213, -118.527244,"counterClockwise"));
        stationList.add(new Station("Mike Curbs walk/ Lindley Ave.","BK",34.236737, -118.527240,"counterClockwise"));
    }


    public static void addMarkerToMap(GoogleMap googleMap)
    {
        for(int i=0;i<stationList.size();i++)
        {
            stationList.get(i).addMarker(googleMap);
        }
        //googleMap.addMarker(new MarkerOptions().position(new LatLng(34.2398565, -118.529266)).title("Hello world"));

    }

    public static void drawLine(GoogleMap googleMap)
    {
        PolylineOptions midRight;
        PolylineOptions midLeft;

        for(int i=0;i<stationList.size();i++)
        {

        }
        //googleMap.addMarker(new MarkerOptions().position(new LatLng(34.2398565, -118.529266)).title("Hello world"));
    }




}
class Station
{
    String name;
    String abbr;
    String direction="";
    LatLng latLng;
    public Station(String name,String abbr,double lat,double lng,String direction)
    {
        this.name=name;
        this.abbr=abbr;
        this.latLng=new LatLng(lat,lng);
        this.direction=direction;
    }
    public void addMarker(GoogleMap googleMap)
    {
        if(direction.equals("clockwise"))
            googleMap.addMarker(new MarkerOptions().position(latLng).title(abbr+" "+direction).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        else
            googleMap.addMarker(new MarkerOptions().position(latLng).title(abbr+" "+direction).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
    }

}
package com.example.jingjie.carly;

import android.graphics.Color;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
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

        //1
        stationList.add(new Station("Lot B1, B2","B1",34.236790, -118.533812,"counterClockwise"));

        //2
        stationList.add(new Station("Lot B4","B4",34.239235, -118.533810,"counterClockwise"));

        //3
        stationList.add(new Station("Lot B5","B5",34.241991, -118.533795,"counterClockwise"));

        //4
        stationList.add(new Station("Plummer St.","Plummer",34.242751, -118.529231,"counterClockwise"));

        //5
        stationList.add(new Station("Soccer Plaza","Soccer",34.242736, -118.524686,"counterClockwise"));

        //6
        stationList.add(new Station("Lot G4","G4",34.240942, -118.524584,"counterClockwise"));

        //7
        stationList.add(new Station("Rainforest","Rainforest",34.238994, -118.525280,"counterClockwise"));

        //8
        stationList.add(new Station("Orange Grove","Orange",34.237307, -118.525604,"counterClockwise"));

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
        PolylineOptions midInner=new PolylineOptions().add(new LatLng(34.236917, -118.531557),new LatLng(34.239140, -118.531606)
                ,new LatLng(34.240957, -118.531616),new LatLng(34.240870, -118.527476),new LatLng(34.239097, -118.527448),
                new LatLng(34.236871, -118.527472),new LatLng(34.236917, -118.531557)).width(8)
                .color(Color.RED);
        PolylineOptions midOuter=new PolylineOptions().add(new LatLng(34.236790, -118.531904),new LatLng(34.239306, -118.531855)
                ,new LatLng(34.241102, -118.531876),new LatLng(34.240992, -118.527265),new LatLng(34.239213, -118.527244),
                new LatLng(34.236737, -118.527240),new LatLng(34.236790, -118.531904)).width(8)
                .color(Color.BLUE);
        PolylineOptions lowerLeft=new PolylineOptions().add(new LatLng(34.236790, -118.531904),new LatLng(34.236790, -118.533812)
                ,new LatLng(34.239306,-118.533812),new LatLng(34.239306, -118.531855)).width(8)
                .color(Color.BLUE);

        PolylineOptions upperMid=new PolylineOptions().add(new LatLng(34.242771, -118.531785),new LatLng(34.242748, -118.527334)
                ,new LatLng(34.240992, -118.527265)).width(8)
                .color(Color.BLUE);

        PolylineOptions upperLeft=new PolylineOptions().add(new LatLng(34.239306,-118.533812),new LatLng(34.242742, -118.533791)
                ,new LatLng(34.242771, -118.531785),new LatLng(34.241102, -118.531876)).width(8)
                .color(Color.BLUE);

        PolylineOptions upperRight=new PolylineOptions().add(new LatLng(34.242748, -118.527334),new LatLng(34.242736, -118.524686)
                ,new LatLng(34.240942, -118.524584),new LatLng(34.240992, -118.527265)).width(8)
                .color(Color.BLUE);

        PolylineOptions leftMid=new PolylineOptions().add(new LatLng(34.240942, -118.524584),new LatLng(34.239008, -118.524608)
                ,new LatLng(34.238989, -118.525702),new LatLng(34.237384, -118.525724),new LatLng(34.237329, -118.527328)).width(8)
                .color(Color.BLUE);

        Polyline lineMidInner=googleMap.addPolyline(midInner);
        Polyline lineOuterInner=googleMap.addPolyline(midOuter);
        Polyline lineLowerLeft=googleMap.addPolyline(lowerLeft);
        Polyline lineUpperLeft=googleMap.addPolyline(upperLeft);
        Polyline lineUpperMid=googleMap.addPolyline(upperMid);
        Polyline lineUpperRight=googleMap.addPolyline(upperRight);
        Polyline lineLeftMid=googleMap.addPolyline(leftMid);
        /*
        for(int i=0;i<stationList.size();i++)
        {

        }
        */
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
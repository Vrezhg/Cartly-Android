package com.example.jingjie.maptest;

import java.util.ArrayList;

/**
 * Created by Jingjie on 11/15/2016.
 */

public class LocationData
{
    ArrayList<String[]> loc=new ArrayList<>();

    public LocationData()
    {
        loc.add(new String[]{"Matador Bookstore","34.237507","-118.527996"});
        loc.add(new String[]{"Oviatt Library","34.239877","-118.529304"});
        loc.add(new String[]{"Jacaranda Hall","34.241163","-118.528423"});
        loc.add(new String[]{"Sierra Hall","34.238359","-118.531086"});
        loc.add(new String[]{"Live Oak Hall","34.238226","-118.527965"});
    }

    public String[] getLocation(String str)
    {
        for(int i=0;i<loc.size();i++)
        {
            String[] tempStr=loc.get(i);
            if(str.equals(tempStr[0]))
            {
                return loc.get(i);
            }
        }
        return new String[3];
    }
}

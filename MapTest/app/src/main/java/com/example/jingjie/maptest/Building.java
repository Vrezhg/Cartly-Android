package com.example.jingjie.maptest;

/**
 * Created by Jingjie on 11/20/2016.
 */

public class Building
{
    private String name;
    private double lat;
    private double lng;
    private String abbr;



    public Building(String[] str)
    {
        name=str[0];
        lat= Double.parseDouble(str[1]);
        lng= Double.parseDouble(str[2]);
        abbr=str[3];
    }
    public Building()
    {

    }

    //index 6:
    //1, Building
    //2, TeachingBuilding
    //3, ParkingBuilding
    //4, Restaurant
    public static Building buildingFactory(String[] str)
    {
        Building returnBuilding=null;
        switch (Integer.parseInt(str[6]))
        {
            case 1:
                returnBuilding=new Building(str);
                break;
            case 2:
                returnBuilding=new TeachingBuilding(str);
                break;
            case 3:
                returnBuilding=new ParkingBuilding(str);
                break;
            case 4:
                returnBuilding=new Restaurant(str);
                break;
        }
        return returnBuilding;
    }

    public double getLat()
    {
        return lat;
    }

    public double getLng()
    {
        return lng;
    }

    public String  getName()
    {
        return name;
    }
    public String getAbbr()
    {
        return abbr;
    }

    public String getSearchKey()
    {
        return name;
    }

    public String getDiscription()
    {
        return name;
    }

}

class TeachingBuilding extends Building
{
    private String department;
    private String college;

    public TeachingBuilding(String[] str)
    {
        super(str);
        department=str[4];
        college=str[5];
    }

    public String getSearchKey()
    {
        return super.getSearchKey()+department+college;
    }

    public String getDiscription()
    {
        String result=super.getDiscription()+"\n";
        result=result+college+"\n";
        result=result+department;
        return result;
    }

}

class ParkingBuilding extends Building
{
    boolean studentParking;
    public ParkingBuilding(String[] str)
    {
        super(str);
        studentParking="true".equals(str[4]);
    }

    public boolean isStudentParking()
    {
        return studentParking;
    }
    public String getSearchKey()
    {
        return super.getSearchKey()+getAbbr();
    }
}

class Restaurant extends Building
{
    boolean isMeal=true;
    public Restaurant(String[] str)
    {
        super(str);
        if(str[4].equals("0"))
        {
            isMeal=true;
        }
        else if(str[4].equals("1"))
        {
            isMeal=false;
        }
    }
    public boolean isMeal()
    {
        return isMeal;
    }
}


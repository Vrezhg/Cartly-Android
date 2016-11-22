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

class parkingBuilding extends Building
{
    boolean isStudentParking;
    String employeeOnly="";

    public parkingBuilding(String[] str)
    {

    }

}

class restaurant extends Building
{

}

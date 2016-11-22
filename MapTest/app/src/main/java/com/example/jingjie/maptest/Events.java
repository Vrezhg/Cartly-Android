package com.example.jingjie.maptest;

/**
 * Created by Jingjie on 11/21/2016.
 */

public abstract class Events
{
    public Events()
    {

    }
    public abstract String getEvents(int i);
}

class ManEvents extends Events
{
    String[] e;
    public ManEvents()
    {
        e=new String[]{"http://www.gomatadors.com/schedule.aspx?path=baseball",
                "http://www.gomatadors.com/schedule.aspx?path=mbball",
                "http://www.gomatadors.com/schedule.aspx?path=cross",
                "http://www.gomatadors.com/schedule.aspx?path=mgolf",
                "http://www.gomatadors.com/schedule.aspx?path=msoc",
                "http://www.gomatadors.com/schedule.aspx?path=mtrack",
                "http://www.gomatadors.com/schedule.aspx?path=mvball"};
    }
    public String getEvents(int i)
    {
        return e[i];
    }

}

class WomanEvents extends Events
{
    String[] e;
    public WomanEvents()
    {
        e=new String[]{"http://www.gomatadors.com/schedule.aspx?path=wbball",
                "http://www.gomatadors.com/schedule.aspx?path=wbvball",
                "http://www.gomatadors.com/schedule.aspx?path=wcross",
                "http://www.gomatadors.com/schedule.aspx?path=wgolf",
                "http://www.gomatadors.com/schedule.aspx?path=wsoc",
                "http://www.gomatadors.com/schedule.aspx?path=softball&",
                "http://www.gomatadors.com/schedule.aspx?path=wten",
                "http://www.gomatadors.com/schedule.aspx?path=wtrack",
                "http://www.gomatadors.com/schedule.aspx?path=wvball"};
    }
    public String getEvents(int i)
    {
        return e[i];
    }

}
package com.example.jingjie.maptest;

import java.util.ArrayList;

/**
 * Created by Jingjie on 11/15/2016.
 */

public class LocationData
{
    ArrayList<Building> loc=new ArrayList<>();

    public LocationData()
    {
        //name,lat,lng,abbr,sub-department,college,
        loc.add(new Building(new String[]{"Matador Bookstore","34.237507","-118.527996","BK","",""}));
        loc.add(new Building(new String[]{"Oviatt Library","34.239877","-118.529304","OV","",""}));
        loc.add(new Building(new String[]{"Bayramian Hall","34.240251","-118.530780","BH","",""}));
        loc.add(new TeachingBuilding(new String[]{"Jacaranda Hall","34.241163","-118.528423","JD","Computer Science,Civil Engineering,Computer Engineering,Electrical Engineering,Manufacturing Systems Engineering,Mechanical Engineering,Department of Nursing,Department of Health Sciences,Department of Environmental and Occupational Health","Engineering and Computer Science"}));
        loc.add(new TeachingBuilding(new String[]{"Sierra Hall","34.238359","-118.531086","SH","Department of Asian American Studies,Department of Central American Studies,Department of Chicana and Chicano Studies,Department of English,Department of Gender and Women's Studies,Department of Linguistics/TESL,Modern & Classical Languages & Literatures,Department of Philosophy,Department of Religious Studies,Department of Anthropology,Department of Geography,Department of Political Science,Department of Psychology,Department of Social Work,Department of Urban Studies & Planning","College of Humanities"}));
        loc.add(new TeachingBuilding(new String[]{"Live Oak Hall","34.238226","-118.527965","LO","Department of Geological Sciences,Department of Mathematics,Department of Physics & Astronomy","College of Science and Math"}));
        loc.add(new Building(new String[]{"University Hall","34.239761","-118.531995","UN","",""}));
        loc.add(new TeachingBuilding(new String[]{"Art and Design Center","34.243852","-118.530013","AC","Department of ART",""}));
        loc.add(new TeachingBuilding(new String[]{"Manzanita Hall","34.237620","-118.529843","MZ","Department of Communication Studies,Department of Cinema and Television Arts,Department of Journalism",""}));
        loc.add(new TeachingBuilding(new String[]{"Cypress Hall","34.236068","-118.529691","CY","Department of Music","Mike Curb College of Arts, Media, and Communication"}));
        loc.add(new TeachingBuilding(new String[]{"Juniper Hall","34.241896","-118.530863","JH","Accounting and Information Systems,Business Law,Economics,Finance Financial Planning and Insurance,Management,Marketing,Real Estate,Systems and Operations Management","David Nazarian College of Business and Economics"}));
        loc.add(new TeachingBuilding(new String[]{"Education","34.241316","-118.530571","ED","Department of Education","Michael D. Eisner College of Education"}));
        loc.add(new TeachingBuilding(new String[]{"Sequoia Hall","34.240163","-118.528288","SQ","Department of Family and Consumer Sciences","College of Health and Human Development","Health & Human Development"}));
        loc.add(new TeachingBuilding(new String[]{"Monterey Hall","34.236662","-118.523841","MH","Department of Communication Disorders and Sciences",""}));
        loc.add(new TeachingBuilding(new String[]{"Redwood Hall","34.241857","-118.525985","RE","Department of Kinesiology,Recreation and Tourism Management",""}));
        loc.add(new TeachingBuilding(new String[]{"Chaparral Hall","34.238112","-118.527120","CR","Department of Biology","College of Science and Math"}));
        loc.add(new TeachingBuilding(new String[]{"Eucalyptus Hall","34.238679","-118.528764","EH","Department of Chemistry and Biochemistry","College of Science and Math"}));
        loc.add(new TeachingBuilding(new String[]{"Santa Susana Hall","34.237610","-118.529379","SN","Department of Africana Studies,Department of Sociology","College of Social and Behavioral Sciences"}));
        loc.add(new TeachingBuilding(new String[]{"Sierra Tower","34.238670","-118.530268","ST","Department of History","College of Social and Behavioral Sciences"}));
        //parking
        //name,lat,lng,abbr,employeeOnly,


    }

    public Building getLocation(String str)
    {
        if(str.length()<=3)
        {
            return getLocationByAbbr(str);
        }

        for(int i=0;i<loc.size();i++)
        {
            Building building=loc.get(i);
            if(str.equalsIgnoreCase(building.getName()))
            {
                return building;
            }
        }

        for(int i=0;i<loc.size();i++)
        {
            String str1= ((str.toLowerCase()).split(" "))[0];
            Building building=loc.get(i);
            if (building instanceof TeachingBuilding)
            {
                if ((building.getName() + building.getDiscription()).toLowerCase().contains(str1))
                {
                    return building;
                }
            }
        }
        return null;
    }

    public Building getLocationByAbbr(String str)
    {
        for(int i=0;i<loc.size();i++)
        {
            Building building=loc.get(i);
            if(str.equalsIgnoreCase(building.getAbbr()))
            {
                return building;
            }
        }

        return null;
    }
}

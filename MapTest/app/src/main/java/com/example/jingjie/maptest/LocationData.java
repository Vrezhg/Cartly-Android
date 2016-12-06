package com.example.jingjie.maptest;

import java.util.ArrayList;

/**
 * Created by Jingjie on 11/15/2016.
 */

public class LocationData
{
    ArrayList<Building> loc = new ArrayList<>();
    ArrayList<String[]> info = new ArrayList<>();
    /*
    public LocationData()
    {
        //index 6:
        //1, Building
        //2, TeachingBuilding
        //3, ParkingBuilding
        //4, Restaurant
        //name,lat,lng,abbr,sub-department,college,building type
        loc.add(Building.buildingFactory(new String[]{"Matador Bookstore","34.237507","-118.527996","BK","","","1"}));
        loc.add(Building.buildingFactory(new String[]{"Oviatt Library","34.239877","-118.529304","OV","","","1"}));
        loc.add(Building.buildingFactory(new String[]{"Bayramian Hall","34.240251","-118.530780","BH","","","1"}));
        loc.add(Building.buildingFactory(new String[]{"Jacaranda Hall","34.241163","-118.528423","JD","Computer Science,Civil Engineering,Computer Engineering,Electrical Engineering,Manufacturing Systems Engineering,Mechanical Engineering,Department of Nursing,Department of Health Sciences,Department of Environmental and Occupational Health","Engineering and Computer Science","2"}));
        loc.add(Building.buildingFactory(new String[]{"Sierra Hall","34.238359","-118.531086","SH","Department of Asian American Studies,Department of Central American Studies,Department of Chicana and Chicano Studies,Department of English,Department of Gender and Women's Studies,Department of Linguistics/TESL,Modern & Classical Languages & Literatures,Department of Philosophy,Department of Religious Studies,Department of Anthropology,Department of Geography,Department of Political Science,Department of Psychology,Department of Social Work,Department of Urban Studies & Planning","College of Humanities","2"}));
        loc.add(Building.buildingFactory(new String[]{"Live Oak Hall","34.238226","-118.527965","LO","Department of Geological Sciences,Department of Mathematics,Department of Physics & Astronomy","College of Science and Math","2"}));
        loc.add(Building.buildingFactory(new String[]{"University Hall","34.239761","-118.531995","UN","","","1"}));
        loc.add(Building.buildingFactory(new String[]{"Art and Design Center","34.243852","-118.530013","AC","Department of ART","","2"}));
        loc.add(Building.buildingFactory(new String[]{"Manzanita Hall","34.237620","-118.529843","MZ","Department of Communication Studies,Department of Cinema and Television Arts,Department of Journalism","","2"}));
        loc.add(Building.buildingFactory(new String[]{"Cypress Hall","34.236068","-118.529691","CY","Department of Music","Mike Curb College of Arts, Media, and Communication","2"}));
        loc.add(Building.buildingFactory(new String[]{"Juniper Hall","34.241896","-118.530863","JH","Accounting and Information Systems,Business Law,Economics,Finance Financial Planning and Insurance,Management,Marketing,Real Estate,Systems and Operations Management","David Nazarian College of Business and Economics","2"}));
        loc.add(Building.buildingFactory(new String[]{"Education","34.241316","-118.530571","ED","Department of Education","Michael D. Eisner College of Education","2"}));
        loc.add(Building.buildingFactory(new String[]{"Sequoia Hall","34.240163","-118.528288","SQ","Department of Family and Consumer Sciences, College of Health and Human Development","Health & Human Development","2"}));
        loc.add(Building.buildingFactory(new String[]{"Monterey Hall","34.236662","-118.523841","MH","Department of Communication Disorders and Sciences","","2"}));
        loc.add(Building.buildingFactory(new String[]{"Redwood Hall","34.241857","-118.525985","RE","Department of Kinesiology,Recreation and Tourism Management","","2"}));
        loc.add(Building.buildingFactory(new String[]{"Chaparral Hall","34.238112","-118.527120","CR","Department of Biology","College of Science and Math","2"}));
        loc.add(Building.buildingFactory(new String[]{"Eucalyptus Hall","34.238679","-118.528764","EH","Department of Chemistry and Biochemistry","College of Science and Math","2"}));
        loc.add(Building.buildingFactory(new String[]{"Santa Susana Hall","34.237610","-118.529379","SN","Department of Africana Studies,Department of Sociology","College of Social and Behavioral Sciences","2"}));
        loc.add(Building.buildingFactory(new String[]{"Sierra Tower","34.238670","-118.530268","ST","Department of History","College of Social and Behavioral Sciences","2"}));
        loc.add(Building.buildingFactory(new String[]{"Subway","34.239707","-118.526377","","","","4"}));
        loc.add(Building.buildingFactory(new String[]{"Freudian Sip in USU","34.239848","-118.527139","","","","4"}));
        loc.add(Building.buildingFactory(new String[]{"Freudian Sip in library","34.239886","-118.529629","","","","4"}));
        loc.add(Building.buildingFactory(new String[]{"Freudian Sip in Arbor Grill","34.241085","-118.529773","","","","4"}));
        loc.add(Building.buildingFactory(new String[]{"Arbor Grill","34.241178","-118.529766","AR","","","4"}));
        //parking
        //name,lat,lng,abbr,,
    }
    */

    public LocationData()
    {
        fillInfo();
        for (int i = 0; i < info.size(); i++)
        {
            loc.add(Building.buildingFactory(info.get(i)));
        }
    }


    public void fillInfo()
    {
        //index 6:
        //1, Building
        //2, TeachingBuilding
        //3, ParkingBuilding
        //4, Restaurant
        //name,lat,lng,abbr,sub-department,college,building type
        info.add(new String[]{"Matador Bookstore", "34.237507", "-118.527996", "BK", "", "", "1"});
        info.add(new String[]{"Oviatt Library", "34.239877", "-118.529304", "OV", "", "", "1"});
        info.add(new String[]{"Bayramian Hall", "34.240251", "-118.530780", "BH", "", "", "1"});
        info.add(new String[]{"Jacaranda Hall", "34.241163", "-118.528423", "JD", "Computer Science,Civil Engineering,Computer Engineering,Electrical Engineering,Manufacturing Systems Engineering,Mechanical Engineering,Department of Nursing,Department of Health Sciences,Department of Environmental and Occupational Health", "Engineering and Computer Science", "2"});
        info.add(new String[]{"Sierra Hall", "34.238359", "-118.531086", "SH", "Department of Asian American Studies,Department of Central American Studies,Department of Chicana and Chicano Studies,Department of English,Department of Gender and Women's Studies,Department of Linguistics/TESL,Modern & Classical Languages & Literatures,Department of Philosophy,Department of Religious Studies,Department of Anthropology,Department of Geography,Department of Political Science,Department of Psychology,Department of Social Work,Department of Urban Studies & Planning", "College of Humanities", "2"});
        info.add(new String[]{"Live Oak Hall", "34.238226", "-118.527965", "LO", "Department of Geological Sciences,Department of Mathematics,Department of Physics & Astronomy", "College of Science and Math", "2"});
        info.add(new String[]{"University Hall", "34.239761", "-118.531995", "UN", "", "", "1"});
        info.add(new String[]{"Art and Design Center", "34.243852", "-118.530013", "AC", "Department of ART", "", "2"});
        info.add(new String[]{"Manzanita Hall", "34.237620", "-118.529843", "MZ", "Department of Communication Studies,Department of Cinema and Television Arts,Department of Journalism", "", "2"});
        info.add(new String[]{"Cypress Hall", "34.236068", "-118.529691", "CY", "Department of Music", "Mike Curb College of Arts, Media, and Communication", "2"});
        info.add(new String[]{"Juniper Hall", "34.241896", "-118.530863", "JH", "Accounting and Information Systems,Business Law,Economics,Finance Financial Planning and Insurance,Management,Marketing,Real Estate,Systems and Operations Management", "David Nazarian College of Business and Economics", "2"});
        info.add(new String[]{"Education", "34.241316", "-118.530571", "ED", "Department of Education", "Michael D. Eisner College of Education", "2"});
        info.add(new String[]{"Sequoia Hall", "34.240163", "-118.528288", "SQ", "Department of Family and Consumer Sciences, College of Health and Human Development", "Health & Human Development", "2"});
        info.add(new String[]{"Monterey Hall", "34.236662", "-118.523841", "MH", "Department of Communication Disorders and Sciences", "", "2"});
        info.add(new String[]{"Redwood Hall", "34.241857", "-118.525985", "RE", "Department of Kinesiology,Recreation and Tourism Management", "", "2"});
        info.add(new String[]{"Chaparral Hall", "34.238112", "-118.527120", "CR", "Department of Biology", "College of Science and Math", "2"});
        info.add(new String[]{"Eucalyptus Hall", "34.238679", "-118.528764", "EH", "Department of Chemistry and Biochemistry", "College of Science and Math", "2"});
        info.add(new String[]{"Santa Susana Hall", "34.237610", "-118.529379", "SN", "Department of Africana Studies,Department of Sociology", "College of Social and Behavioral Sciences", "2"});
        info.add(new String[]{"Sierra Tower", "34.238670", "-118.530268", "ST", "Department of History", "College of Social and Behavioral Sciences", "2"});
        info.add(new String[]{"Asian American Activities Center", "34.244239732", "-118.533782256", "AA", "", "", "1"});

        //restaurant
        //name,lat,lng,abbr,type,
        //0 meal , 1 cafe
        info.add(new String[]{"Subway", "34.239707", "-118.526377", "", "0", "", "4"});
        info.add(new String[]{"Freudian Sip in USU", "34.239848", "-118.527139", "", "1", "", "4"});
        info.add(new String[]{"Freudian Sip in library", "34.239886", "-118.529629", "", "1", "", "4"});
        info.add(new String[]{"Freudian Sip in Arbor Grill", "34.241085", "-118.529773", "", "1", "", "4"});
        info.add(new String[]{"Arbor Grill", "34.241178", "-118.529766", "AR", "0", "", "4"});
        //parking
        //name,lat,lng,abbr,isStudentParking,
        info.add(new String[]{"Lot B1", "34.236037", "-118.532008", "B1", "true", "", "3"});
        info.add(new String[]{"Lot B2", "34.236848", "-118.533051", "B2", "true", "", "3"});
        info.add(new String[]{"Lot B3", "34.238001", "-118.533519", "B3", "", "", "3"});
        info.add(new String[]{"Parking Structure B3", "34.237915", "-118.532171", "", "true", "", "3"});
        info.add(new String[]{"Lot B4", "34.239885", "-118.533262", "B4", "", "", "3"});
        info.add(new String[]{"Lot B5", "34.242280", "-118.532691", "B5", "", "", "3"});
        info.add(new String[]{"Parking Structure B5", "34.241575", "-118.532565", "", "true", "", "3"});
        info.add(new String[]{"Lot B6", "34.243433", "-118.532446", "B6", "true", "", "3"});
        info.add(new String[]{"Lot D1", "34.235796", "-118.530155", "D1", "", "", "3"});
        info.add(new String[]{"Lot C6", "34.244251", "-118.531198", "C6", "", "", "3"});
        info.add(new String[]{"Lot D6", "34.243793", "-118.529107", "D6", "", "", "3"});
        info.add(new String[]{"Lot E6", "34.243374", "-118.528528", "E6", "true", "", "3"});
        info.add(new String[]{"Lot E5", "34.242094", "-118.527690", "E5", "", "", "3"});
        info.add(new String[]{"Lot F5", "34.241744", "-118.525315", "F5", "true", "", "3"});
        info.add(new String[]{"Lot F4", "34.240828", "-118.526469", "F4", "", "", "3"});
        info.add(new String[]{"Lot G4", "34.240618", "-118.523603", "G4", "", "", "3"});
        info.add(new String[]{"Lot G3", "34.238123", "-118.523963", "G3", "true", "", "3"});
        info.add(new String[]{"Parking Structure G3", "34.238024", "-118.525020", "", "true", "", "3"});
        info.add(new String[]{"Lot F3", "34.238412", "-118.526061", "F3", "", "", "3"});
        info.add(new String[]{"Lot G1", "34.236144", "-118.523858", "G1", "", "", "3"});

    }

    public String[] getLocName()
    {
        String[] strArr=new String[loc.size()+1];
        strArr[0]="";
        for(int i=1;i<strArr.length;i++)
        {
            strArr[i]=loc.get(i-1).getName();
        }
        return strArr;
    }

    public String[] getTeachingBuildingName()
    {
        ArrayList<TeachingBuilding> tb=getClassRoomList();
        String[] strArr=new String[tb.size()+1];
        strArr[0]="";
        for(int i=1;i<strArr.length;i++)
        {
            strArr[i]=tb.get(i-1).getName();
        }
        return strArr;

    }

    public String[] getParkingName()
    {
        ArrayList<ParkingBuilding> tb=getParkingList();
        String[] strArr=new String[tb.size()+1];
        strArr[0]="";
        for(int i=1;i<strArr.length;i++)
        {
            strArr[i]=tb.get(i-1).getName();
        }
        return strArr;

    }

    public String[] getStudentParkingName()
    {
        ArrayList<ParkingBuilding> tb=getParkingList();
        ArrayList<ParkingBuilding> stuP=new ArrayList<>();
        for(int i=0;i<tb.size();i++)
        {
            if(tb.get(i).isStudentParking())
            {
                stuP.add(tb.get(i));
            }
        }


        String[] strArr=new String[stuP.size()+1];
        strArr[0]="";
        for(int i=1;i<strArr.length;i++)
        {
            strArr[i]=stuP.get(i-1).getName();
        }
        return strArr;

    }


    public String[] getResturantName()
    {
        ArrayList<Restaurant> tb=getRestaurantList();
        String[] strArr=new String[tb.size()+1];
        strArr[0]="";
        for(int i=1;i<strArr.length;i++)
        {
            strArr[i]=tb.get(i-1).getName();
        }
        return strArr;

    }

    public String[] getMealRestuName()
    {
        ArrayList<Restaurant> tb=getRestaurantList();
        ArrayList<Restaurant> stuP=new ArrayList<>();
        for(int i=0;i<tb.size();i++)
        {
            if(tb.get(i).isMeal())
            {
                stuP.add(tb.get(i));
            }
        }

        String[] strArr=new String[stuP.size()+1];
        strArr[0]="";
        for(int i=1;i<strArr.length;i++)
        {
            strArr[i]=stuP.get(i-1).getName();
        }
        return strArr;
    }

    public String[] getCafeName()
    {
        ArrayList<Restaurant> tb=getRestaurantList();
        ArrayList<Restaurant> stuP=new ArrayList<>();
        for(int i=0;i<tb.size();i++)
        {
            if(!tb.get(i).isMeal())
            {
                stuP.add(tb.get(i));
            }
        }

        String[] strArr=new String[stuP.size()+1];
        strArr[0]="";
        for(int i=1;i<strArr.length;i++)
        {
            strArr[i]=stuP.get(i-1).getName();
        }
        return strArr;
    }






    public ArrayList<TeachingBuilding> getClassRoomList()
    {
        ArrayList<TeachingBuilding> result=new ArrayList<>();
        Building b;
        for(int i=0;i<loc.size();i++)
        {
            b=loc.get(i);
            if(b instanceof TeachingBuilding)
            {
                result.add((TeachingBuilding)b);
            }
        }
        return result;
    }

    public ArrayList<ParkingBuilding> getParkingList()
    {
        ArrayList<ParkingBuilding> result=new ArrayList<>();
        Building b;
        for(int i=0;i<loc.size();i++)
        {
            b=loc.get(i);
            if(b instanceof ParkingBuilding)
            {
                result.add((ParkingBuilding)b);
            }
        }
        return result;
    }

    public ArrayList<Restaurant> getRestaurantList()
    {
        ArrayList<Restaurant> result=new ArrayList<>();
        Building b;
        for(int i=0;i<loc.size();i++)
        {
            b=loc.get(i);
            if(b instanceof Restaurant)
            {
                result.add((Restaurant)b);
            }
        }
        return result;
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

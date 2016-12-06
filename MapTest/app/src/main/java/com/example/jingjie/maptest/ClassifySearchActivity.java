package com.example.jingjie.maptest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ClassifySearchActivity extends AppCompatActivity
{
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    long start=0;
    long end1=0;
    long end2=0;
    long end3=0;
    private ArrayAdapter<CharSequence> adapter1;
    private ArrayAdapter<CharSequence> adapter2;
    private ArrayAdapter<CharSequence> adapter3;
    private String startPos1="";
    private String endPos1="";
    private String startPos2="";
    private String endPos2="";
    private String startPos3="";
    private String endPos3="";
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private LocationData locationData=new LocationData();
    private boolean isStudentParking;
    private int resturantType;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_search);
        initView();
    }

    public void initView()
    {
        initSpinner1();
        addListenerOnButton1();
        isStudentParking=false;
        initSpinner2();
        addListenerOnButton2();
        resturantType=0;
        initSpinner3();
        addListenerOnButton3();
        addListenerOnFlipStudentParking();
        addListenerToChangeRestuType();
    }

    public void addListenerOnButton1(){
        final Context context = this;
        button1 = (Button)findViewById(R.id.searchClassBuildingBtn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ClassifySearchActivity.this,mapActivity.class);
                i.putExtra("start",startPos1);
                i.putExtra("end",endPos1);
                startActivity(i);
            }
        });
    }
    public void initSpinner1()
    {
        spinner1 = (Spinner)findViewById(R.id.teachingBuildingSpinner);
        try
        {
            adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,locationData.getTeachingBuildingName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>parent, View view, int i, long l) {
                end1=parent.getItemIdAtPosition(i);
                endPos1= (String) adapter1.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void initSpinner2()
    {
        String[] list;
        if(!isStudentParking)
        {
            list=locationData.getParkingName();
            TextView tv=(TextView)findViewById(R.id.textView3);
            tv.setText("Search Parking");

        }
        else
        {
            list=locationData.getStudentParkingName();
            TextView tv=(TextView)findViewById(R.id.textView3);
            tv.setText("Search Student Parking");

        }
        spinner2 = (Spinner)findViewById(R.id.spinner3);
        try
        {
            adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>parent, View view, int i, long l) {
                end2=parent.getItemIdAtPosition(i);
                endPos2= (String) adapter2.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void addListenerOnButton2(){
        final Context context = this;
        button2 = (Button)findViewById(R.id.searchParkingBtn);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ClassifySearchActivity.this,mapActivity.class);
                i.putExtra("start",startPos2);
                i.putExtra("end",endPos2);
                startActivity(i);
            }
        });
    }




    public void initSpinner3()
    {
        String[] list;
        if(resturantType==0)
        {
            list=locationData.getResturantName();
            TextView tv=(TextView)findViewById(R.id.textView4);
            tv.setText("Search Restaurant");

        }
        else if(resturantType==1)
        {
            list=locationData.getMealRestuName();
            TextView tv=(TextView)findViewById(R.id.textView4);
            tv.setText("Search Meal");

        }
        else
        {
            list=locationData.getCafeName();
            TextView tv=(TextView)findViewById(R.id.textView4);
            tv.setText("Search Cafe");

        }



        spinner3 = (Spinner)findViewById(R.id.spinner4);
        try
        {
            adapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>parent, View view, int i, long l) {
                end3=parent.getItemIdAtPosition(i);
                endPos3= (String) adapter3.getItem(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void addListenerOnButton3(){
        final Context context = this;
        button3 = (Button)findViewById(R.id.searchRestaurantBtn);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ClassifySearchActivity.this,mapActivity.class);
                i.putExtra("start",startPos3);
                i.putExtra("end",endPos3);
                startActivity(i);
            }
        });
    }

    public void addListenerOnFlipStudentParking(){
        final Context context = this;
        button4 = (Button)findViewById(R.id.flipIsStudent);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isStudentParking=!isStudentParking;
                initSpinner2();
            }
        });
    }
    public void changeRestuType()
    {
        resturantType=(resturantType+1)%3;
    }

    public void addListenerToChangeRestuType(){
        final Context context = this;
        button5 = (Button)findViewById(R.id.Meal_Cafe_All_Btn);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeRestuType();
                initSpinner3();
            }
        });
    }
}

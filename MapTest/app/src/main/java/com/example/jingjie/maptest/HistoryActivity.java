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
import android.widget.Toast;

public class HistoryActivity extends AppCompatActivity
{
    History h;
    String path;
    Spinner spinner;
    long start=0;
    long end=0;
    ArrayAdapter<CharSequence> adapter;
    String startPos="";
    String endPos="";
    Button button;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();


    }
    public void initView()
    {
        path=this.getFilesDir().getPath().toString();
        try
        {

            h=new History(path);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //init spinner
        spinner = (Spinner)findViewById(R.id.spinner);
        try
        {
            adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,(""+","+h.getHistory()).split(","));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>parent, View view, int i, long l) {
                end=parent.getItemIdAtPosition(i);
                endPos= (String) adapter.getItem(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addListenerOnButton();
        addListenerOnButton2();
    }

    public void addListenerOnButton(){
        final Context context = this;
        button = (Button)findViewById(R.id.HistoryToMap);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(HistoryActivity.this,mapActivity.class);
                i.putExtra("start",startPos);
                i.putExtra("end",endPos);
                startActivity(i);
            }
        });
    }

    public void addListenerOnButton2(){
        final Context context = this;
        button2 = (Button)findViewById(R.id.ClearHistoryBtn);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try
                {
                    h.clearHistory();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }

                spinner = (Spinner)findViewById(R.id.spinner);
                try
                {
                    adapter = new ArrayAdapter(HistoryActivity.this,android.R.layout.simple_spinner_item,(""+","+h.getHistory()).split(","));
                } catch (Exception e)
                {
                    e.printStackTrace();
                }

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Apply the adapter to the spinner
                spinner.setAdapter(adapter);

            }
        });
    }

}

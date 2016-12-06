package com.example.jingjie.maptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EventsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);


        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EventsActivity.this,ManEventsActivity.class);
                startActivity(i);
            }
        });

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EventsActivity.this,WomanEventsActivity.class);
                startActivity(i);
            }
        });

    }
}

package com.example.logsignsql.Quarters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.logsignsql.R;

public class ThirdQuarter extends AppCompatActivity {
    Toolbar toolbar;
    GridView gridView;
    String topicName[] = {" Module 18",
            "Module 19",
            "Module 20",
            "Module 21",
            "Module 22",
            "Module 23",
            "Module 24",
            "Module 25",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_quarter);


        toolbar = findViewById(R.id.toolbar3);
        gridView = findViewById(R.id.topics_name);

        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TopicAdapter adapter = new TopicAdapter(topicName,ThirdQuarter.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(ThirdQuarter.this, topicName[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
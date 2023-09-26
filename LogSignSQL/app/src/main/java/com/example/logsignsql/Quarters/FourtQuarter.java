package com.example.logsignsql.Quarters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.logsignsql.R;

public class FourtQuarter extends AppCompatActivity {
    Toolbar toolbar;
    GridView gridView;
    String topicName[] = {" Module 26",
            "Module 27",
            "Module 28",
            "Module 29",
            "Module 30",
            "Module 31",
            "Module 32",
            "Module 33",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourt_quarter);


        toolbar = findViewById(R.id.toolbar4);
        gridView = findViewById(R.id.topics_name);

        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TopicAdapter adapter = new TopicAdapter(topicName,FourtQuarter.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(FourtQuarter.this, topicName[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
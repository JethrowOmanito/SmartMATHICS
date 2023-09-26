package com.example.logsignsql.Quarters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.logsignsql.R;

public class SecondQuarter extends AppCompatActivity {

    Toolbar toolbar;
    GridView gridView;
    String topicName[] = {" Module 9",
            "Module 10",
            "Module 11",
            "Module 12",
            "Module 13",
            "Module 14",
            "Module 16",
            "Module 17",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_quarter);


        toolbar = findViewById(R.id.toolbar2);
        gridView = findViewById(R.id.topics_name);

        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TopicAdapter adapter = new TopicAdapter(topicName, SecondQuarter.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(SecondQuarter.this, topicName[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
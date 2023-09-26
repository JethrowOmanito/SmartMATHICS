package com.example.logsignsql.Quarters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.logsignsql.Quarter1.modulu1.Modulu1;
import com.example.logsignsql.R;

public class FirstQuarter extends AppCompatActivity {

    Toolbar toolbar;
    GridView gridView;
    String topicName[] = {" Module 1",
            "Module 2",
            "Module 3",
            "Module 4",
            "Module 5",
            "Module 6",
            "Module 7",
            "Module 8",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_quarter);


        toolbar = findViewById(R.id.toolbar);
        gridView = findViewById(R.id.topics_name);

        setSupportActionBar(toolbar);

        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TopicAdapter adapter = new TopicAdapter(topicName,FirstQuarter.this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(FirstQuarter.this, topicName[i],Toast.LENGTH_SHORT).show();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if (i == 0) { // Check if "Module 1" is clicked (position 0)
                    // Start the Module1Activity
                    startActivity(new Intent(FirstQuarter.this, Modulu1.class));
                } else {
                    // Handle clicks for other modules if needed
                    Toast.makeText(FirstQuarter.this, topicName[i], Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}
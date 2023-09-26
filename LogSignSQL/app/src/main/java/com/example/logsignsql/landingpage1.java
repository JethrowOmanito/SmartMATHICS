package com.example.logsignsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.logsignsql.databinding.ActivityLoginBinding;

public class landingpage1 extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage1);

        Button btnStudent = findViewById(R.id.login_student);
        Button btnTeacher = findViewById(R.id.login_teacher);

        // Set a click listener for the Student button
        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the Student activity
                Intent intent = new Intent(landingpage1.this, loginActivity.class);
                startActivity(intent);
            }
        });

        // Set a click listener for the Teacher button
        btnTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the Teacher activity
                Intent intent = new Intent(landingpage1.this, TeacherCodeInput.class);
                startActivity(intent);
            }
        });

        // Set a click listener for the "Not Yet Registered? Signup" text
        TextView signupRedirectText = findViewById(R.id.signupRedirectText);
        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the Signup activity
                Intent intent = new Intent(landingpage1.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class TeacherCodeInput extends AppCompatActivity {

    private EditText teacherCodeEditText;
    private Button submitCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_code_input);

        teacherCodeEditText = findViewById(R.id.teacherCodeEditText);
        submitCodeButton = findViewById(R.id.submitCodeButton);

        submitCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the entered code from the EditText
                String enteredCode = teacherCodeEditText.getText().toString();

                // Check if the entered code is correct (you should implement this logic)
                if (isCodeValid(enteredCode)) {
                    // Code is valid, redirect to the Teacher panel
                    Toast.makeText(TeacherCodeInput.this, "Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TeacherCodeInput.this, TeacherPanel.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(TeacherCodeInput.this, "Wrong Code.", Toast.LENGTH_SHORT).show();
                    // Code is invalid, show an error message or handle it accordingly
                    // For example, you can display a toast message or an error TextView
                }
            }
        });
    }

    // Implement your code validation logic here
    private boolean isCodeValid(String code) {
        // Replace this with your actual code validation logic
        // For example, compare the entered code with a predefined code
        return code.equals("YmazzXXD");
    }
}
package com.example.logsignsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.logsignsql.databinding.ActivityLoginBinding;

public class loginActivity extends AppCompatActivity {


        ActivityLoginBinding binding;
        DatabaseHelper databaseHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityLoginBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            databaseHelper = new DatabaseHelper(this);

            binding.loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = binding.loginName.getText().toString();
                    String password = binding.loginPassword.getText().toString();

                    if (email.equals("") || password.equals(""))
                        Toast.makeText(loginActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                    else {
                        Boolean checkCredentials = databaseHelper.checkEmailPassowrd(email, password);

                        if (checkCredentials) {
                            // Retrieve the user's name and pass it to MainActivity
                            String userName = databaseHelper.getUserName(email, password);

                            Toast.makeText(loginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("USERNAME", userName); // Pass the user's name
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(loginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

            binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(loginActivity.this, SignupActivity.class);
                    startActivity(intent);
                }
            });
        }
    }






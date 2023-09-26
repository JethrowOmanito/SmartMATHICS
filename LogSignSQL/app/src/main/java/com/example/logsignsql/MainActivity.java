package com.example.logsignsql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.student);
        navigationView = findViewById(R.id.nav_student_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
       try{
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           navigationView.setNavigationItemSelectedListener(this);
       }catch (NullPointerException ex){
           ex.printStackTrace();
       }


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this,R.id.main_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        if (itemId == R.id.pdf) {
            Toast.makeText(this, "PDF", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.video) {
            Toast.makeText(this, "Video", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.exam) {
            Toast.makeText(this, "Exam", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.module) {
            Toast.makeText(this, "Module", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.share) {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.logout) {
            // Handle Logout action
            Toast.makeText(this, "Bye!", Toast.LENGTH_SHORT).show();

            // Redirect to the login screen
            Intent intent = new Intent(this, landingpage1.class);
            startActivity(intent);

            // Optionally, you can finish the current activity to prevent the user from navigating back to it after logging out.
            finish();
        }

        return true;
    }

}

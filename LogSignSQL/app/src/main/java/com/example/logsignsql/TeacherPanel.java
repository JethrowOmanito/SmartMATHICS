package com.example.logsignsql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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

public class TeacherPanel extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_panel);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = findViewById(R.id.Teachers);
        //navigationView = findViewById(R.id.nav_teacher_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            navigationView.setNavigationItemSelectedListener(this);
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }


        bottomNavigationView = findViewById(R.id.teacher_navigation);
        navController = Navigation.findNavController(this, R.id.teacher_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.attend) {
            Toast.makeText(this, "Attendance", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.add_student) {
            Toast.makeText(this, "Add Student", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.score) {
            Toast.makeText(this, "Score", Toast.LENGTH_SHORT).show();
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

        // Close the navigation drawer
        drawerLayout.closeDrawers();

        return true;
    }
}

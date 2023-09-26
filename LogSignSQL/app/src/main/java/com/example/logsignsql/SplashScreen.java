package com.example.logsignsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener {

    ImageView imageView;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.splash_logo);
        animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.splash_anim);
        animation.setAnimationListener(this);
        imageView.startAnimation(animation);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, landingpage1.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // Delay for 3000 milliseconds (3 seconds)
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
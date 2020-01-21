package com.example.avinlagi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView bg_splash,avinlogo;
    Animation splash_screen,btt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bg_splash = findViewById(R.id.bg_splash);
        avinlogo = findViewById(R.id.avinlogo);
        splash_screen = AnimationUtils.loadAnimation(this, R.anim.splash_screen);
        btt = AnimationUtils.loadAnimation(this,R.anim.btt);

        //run animation
        bg_splash.startAnimation(splash_screen);
        avinlogo.startAnimation(btt);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gotostart = new Intent(SplashScreen.this, Onboarding_one.class);
                startActivity(gotostart);
                finish();
            }
        }, 3000);


    }
}

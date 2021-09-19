package com.sandeep.baatchit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.sandeep.baatchit.Login.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    private  ImageView ivsplash;
    private TextView tvsplash;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //to hide the action bar
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
        ivsplash = findViewById(R.id.icSplash);
        tvsplash = findViewById(R.id.tvSplash);

        animation = AnimationUtils.loadAnimation(this,R.anim.splash_animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        ivsplash.startAnimation(animation);
        tvsplash.startAnimation(animation);
    }
}
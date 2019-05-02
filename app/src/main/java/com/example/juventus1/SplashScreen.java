package com.example.juventus1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(Login.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#000000"))
                .withLogo(R.drawable.juve_logo);
        //.withHeaderText("Welcome to Juventus FC!")
        //.withFooterText("@Copyright 2019");
        //.withAfterLogoText

        //Color-Text
        //config.getHeaderTextView().setTextColor(Color.WHITE);
        //config.getFooterTextView().setTextColor(Color.WHITE);

        //set to view
        View view = config.create();

        //set to view to content
        setContentView(view);

    }
}

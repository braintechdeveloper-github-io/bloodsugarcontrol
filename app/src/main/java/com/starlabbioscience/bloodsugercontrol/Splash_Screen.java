package com.starlabbioscience.bloodsugercontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * @AUTHOR : JOHN MELODY ME || HAFIZAN ||
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: BLOOD SUGAR CONTROL
 */

public class Splash_Screen extends AppCompatActivity {

    Handler HANDLER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        HANDLER = new Handler();

        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent TOAUTHENTICATION;
                TOAUTHENTICATION = new Intent(Splash_Screen.this, MainActivity.class);
                startActivity(TOAUTHENTICATION);
            }
        }, 5010);
    }
}

package com.starlabbioscience.bloodsugercontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @AUTHOR : JOHN MELODY ME || HAFIZAN ||
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: BLOOD SUGAR CONTROL
 */

public class MainActivity extends AppCompatActivity {
    // UI- DECLARE:
    Button SETTING;

    @Override
    public void onStart(){
        super.onStart();
        System.out.println("__");
    }

    private void INIT_DECLARATION() {
        SETTING = findViewById(R.id.setting);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        INIT_DECLARATION();
        // ONCLICK TO SETTING ACTIVITY:
        SETTING.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TOSETTING;
                TOSETTING = new Intent(MainActivity.this, Pereference.class);
                startActivity(TOSETTING);
            }
        });
    }
}

package com.starlabbioscience.bloodsugercontrol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @AUTHOR : JOHN MELODY ME || HAFIZAN ||
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: BLOOD SUGAR CONTROL
 */

public class MainActivity extends AppCompatActivity {
    // UI- DECLARE:

    @Override
    public void onStart(){
        super.onStart();
    }

    private void INIT_DECLARATION() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        INIT_DECLARATION();
    }

}

package com.starlabbioscience.bloodsugercontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * @AUTHOR : JOHN MELODY ME || HAFIZAN ||
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: BLOOD SUGAR CONTROL
 */

public class MainActivity extends AppCompatActivity {
    // UI- DECLARE:
    Button SETTING, PLAY, FORWARD, REWIND, STOP;
    MediaPlayer BiauralPlayer;


    @Override
    public void onStart(){
        super.onStart();
        System.out.println("__");
        BiauralPlayer.setVolume(0,0);
    }

    private void INIT_DECLARATION() {
        SETTING = findViewById(R.id.setting);

        BiauralPlayer = MediaPlayer.create(MainActivity.this,R.raw.sample);
        BiauralPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        BiauralPlayer.setVolume(0,0);
        BiauralPlayer.setLooping(true);

        PLAY = findViewById(R.id.PLAY_BUTTON);
        STOP = findViewById(R.id.stop);
        REWIND = findViewById(R.id.previous);
        FORWARD = findViewById(R.id.forward);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        INIT_DECLARATION();

        final int TIME, FF, RR;
        TIME = BiauralPlayer.getCurrentPosition();
        FF = 5000;
        RR = 5000;

        // ONCLICK TO SETTING ACTIVITY:
        SETTING.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TOSETTING;
                TOSETTING = new Intent(MainActivity.this, Pereference.class);
                startActivity(TOSETTING);
            }
        });

        // ONCLICK ```PLAY BUTTON``` CONFIG:
        PLAY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Pause, Play, Stop, Rewind, Forward;

                Pause = getResources()
                        .getString(R.string.pause);
                Play = getResources()
                        .getString(R.string.play);
                Stop = getResources()
                        .getString(R.string.stop);
                Rewind = getResources()
                        .getString(R.string.Rewind);
                Forward = getResources()
                        .getString(R.string.forward);

                if (BiauralPlayer.isPlaying()){
                    //BiauralPlayer.setVolume(0,0);
                    BiauralPlayer.pause();
                    PLAY.setBackgroundResource(R.mipmap.blek);
                    Toast.makeText(getApplicationContext(),
                            Pause, Toast.LENGTH_SHORT)
                            .show();
                } else {
                    BiauralPlayer.setVolume(80,80);
                    BiauralPlayer.start();
                    PLAY.setBackgroundResource(R.mipmap.sheeet);
                    Toast.makeText(getApplicationContext(),
                            Play, Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        // ONCLICK ```REWIND BUTTON``` CONFIG:
        REWIND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String REWIND_FIVE;
                REWIND_FIVE = "- 5 SEC";

                Toast.makeText(getApplicationContext(), REWIND_FIVE,
                        Toast.LENGTH_SHORT)
                        .show();

                if (TIME + RR >= 0){
                    BiauralPlayer.seekTo(TIME - RR);
                    System.out.println("MUSIC REWIND -5 SECONDS");
                } else {
                    System.out.println("LOG: REWIND FAILED");
                }
            }
        });

        // ONCLICK ```FORWARD BUTTON``` CONFIG:
        FORWARD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FORWARD_FIVE;
                FORWARD_FIVE = "+ 5 SEC";

                Toast.makeText(getApplicationContext(), FORWARD_FIVE,
                        Toast.LENGTH_SHORT)
                        .show();

                if (TIME + FF <= BiauralPlayer.getDuration()){
                    BiauralPlayer.seekTo(TIME + FF);
                    System.out.println("MUSIC FORWARD +5 SECONDS");
                } else {
                    System.out.println("LOG: FORWARD FAILED");
                }
            }
        });

        // ONCLICK ```STOP BUTTON``` CONFIG:
        STOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stop;
                stop = getResources().getString(R.string.stop);

                Toast.makeText(getApplicationContext(), stop
                        ,Toast.LENGTH_SHORT)
                        .show();

                PLAY.setBackgroundResource(R.mipmap.blek);
                if (BiauralPlayer.isPlaying()){
                    BiauralPlayer.pause();
                    Intent restart;
                    restart = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(restart);
                } else {
                    System.out.println("STOP PLAYING FAILED.");
                }
            }
        });
    }
}

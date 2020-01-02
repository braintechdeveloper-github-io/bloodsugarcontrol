package com.starlabbioscience.bloodsugercontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
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
    Button FACEBOOK, WEBSITE, WHATSAPP;
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

        FACEBOOK = findViewById(R.id.fb);
        WEBSITE = findViewById(R.id.web);
        WHATSAPP = findViewById(R.id.ws);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        INIT_DECLARATION();

        final int TIME, FF, RR;
        TIME = BiauralPlayer.getCurrentPosition();
        FF = 0b1001110001000;
        RR = 0b1001110001000;

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
                String Pause, Play;

                Pause = getResources()
                        .getString(R.string.pause);
                Play = getResources()
                        .getString(R.string.play);

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
                String Rewind;
                Rewind = getResources()
                        .getString(R.string.Rewind);

                Toast.makeText(getApplicationContext(), Rewind,
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
                String Forward;
                Forward = getResources()
                        .getString(R.string.forward);

                Toast.makeText(getApplicationContext(), Forward,
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

    public void FACEBOOK(View view){
        Intent TOFACEBOOKPAGE = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://web.facebook.com/StarLabsBioscience?_rdc=1&_rdr"));
        startActivity(TOFACEBOOKPAGE);
    }

    public void WEBSITE(View view){
        Intent TOWEBSITE = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.starlabs.com.my/"));
        startActivity(TOWEBSITE);
    }

    public void WHATSAPP(View view){
        Intent TOWHATSAPP = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://wa.me/6013-9319018?text=[This%20is%20automated%20Message].%20I%20Would%20like%20to%20know%20more.%20"));
        startActivity(TOWHATSAPP);
    }
}

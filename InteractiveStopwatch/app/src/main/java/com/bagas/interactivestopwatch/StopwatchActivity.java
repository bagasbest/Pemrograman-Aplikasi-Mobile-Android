package com.bagas.interactivestopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import java.security.Principal;
import java.security.PublicKey;

public class StopwatchActivity extends AppCompatActivity {

    Button btnGo, btnStop;
    ImageView imgAnchor;
    Animation roundingAlong;
    Chronometer stopwatch;
    //private boolean running;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        btnGo = findViewById(R.id.btn_go);
        btnStop = findViewById(R.id.btn_stop);
        imgAnchor = findViewById(R.id.img_anchor);
        stopwatch = findViewById(R.id.stopwatch);

        //load anim
        roundingAlong = AnimationUtils.loadAnimation(this, R.anim.rounding_stopwatch);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  if(!running) {
                    //passing anim
                    roundingAlong.setDuration(1000);

                    imgAnchor.startAnimation(roundingAlong);
                    btnStop.animate().alpha(1).translationY(-80).setDuration(300).start();
                    btnGo.animate().alpha(0).setDuration(300).start();

                    //start time
                    stopwatch.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    stopwatch.start();
                   // running = true;
                //}
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(running) {

                    btnStop.animate().alpha(0).setDuration(300).start();
                    btnGo.animate().alpha(1).translationY(+20).setDuration(300).start();

                    //stop time
                    stopwatch.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - stopwatch.getBase();


                    roundingAlong.setDuration(0);
                    imgAnchor.setAnimation(roundingAlong);
                   // running = false;
                //}
            }
        });


    }
}

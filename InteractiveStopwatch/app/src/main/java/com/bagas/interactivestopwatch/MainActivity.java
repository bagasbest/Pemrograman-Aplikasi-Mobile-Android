package com.bagas.interactivestopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSplash, tvSubSplash;
    Button btnStart;
    Animation atg,btgOne, btgTwo;
    ImageView imgSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tv_judul);
        tvSubSplash = findViewById(R.id.tv_description);
        btnStart = findViewById(R.id.btn_start);
        imgSplash = findViewById(R.id.img_splash);

        //load animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgOne = AnimationUtils.loadAnimation(this, R.anim.btg_one);
        btgTwo = AnimationUtils.loadAnimation(this, R.anim.btg_two);

        //passing animation
        imgSplash.startAnimation(atg);
        tvSplash.startAnimation(btgOne);
        tvSubSplash.startAnimation(btgOne);
        btnStart.startAnimation(btgTwo);

        //passing event
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StopwatchActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });



    }
}

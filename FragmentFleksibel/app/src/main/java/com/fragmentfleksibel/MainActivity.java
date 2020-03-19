package com.fragmentfleksibel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        HomeFragment hm = new HomeFragment();
        Fragment f = fm.findFragmentByTag(HomeFragment.class.getSimpleName());

        if(!(f instanceof HomeFragment)){
            Log.d("Fragment Fleksibel", "Nama Fragment " + HomeFragment.class.getSimpleName());
            fm.beginTransaction()
                    .add(R.id.main_frame, hm, HomeFragment.class.getSimpleName())
                    .commit();
        }
    }
}

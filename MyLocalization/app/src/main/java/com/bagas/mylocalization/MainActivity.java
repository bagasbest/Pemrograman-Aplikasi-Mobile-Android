package com.bagas.mylocalization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvHello = findViewById(R.id.tv_hello);
        TextView tvPlural = findViewById(R.id.tv_plural);
        TextView tvXliff = findViewById(R.id.tv_xliff);

        int pokeCount = 3;
        String hello  = String.format(getResources().getString(R.string.hello_world), "Bagas Pangestu", pokeCount, "Bagas Ganteng");
        tvHello.setText(hello);

        int songCount = 5;
        String pluralText = getResources().getQuantityString(R.plurals.numberOfSongAvailable, songCount, songCount);
        tvPlural.setText(pluralText);

        tvXliff.setText(getResources().getString(R.string.app_homeurl));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_change_settings) {
            Intent i = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}

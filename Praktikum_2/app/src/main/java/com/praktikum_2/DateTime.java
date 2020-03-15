package com.praktikum_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TaskInfo;
import android.content.Intent;
import android.os.Bundle;
import android.view.CollapsibleActionView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class DateTime extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Date and Time");

        Button button = findViewById(R.id.bt_date);
        Button button2 = findViewById(R.id.bt_time);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dp = new DataPickerFragment();
                dp.show(getSupportFragmentManager(), "date picker");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Fungsi masih belum bisa :(", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, dayOfMonth);

        String s = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);


    }

    private void setMode(int menu_pilihan) {
        switch (menu_pilihan)  {
            case R.id.item1:
                Toast.makeText(this, "You Selected Order", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(this, MainActivity.class);
                startActivity(j);
                break;

            case R.id.item2:
                Toast.makeText(this, "You Selected Status", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item3:
                Toast.makeText(this, "You Selected Favorite", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item4:
                Toast.makeText(this, "You Selected Contact", Toast.LENGTH_SHORT).show();
                break;

            case R.id.kalender:
                Toast.makeText(this, "You Selected Calender", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, DateTime.class);
                break;

            case R.id.keranjang:
                Toast.makeText(this, "Bring to bucket", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(this, MainDessert.class);
                startActivity(k);
                break;

        }

    }
}

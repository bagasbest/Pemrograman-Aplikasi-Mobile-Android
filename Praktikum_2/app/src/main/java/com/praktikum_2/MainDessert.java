package com.praktikum_2;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainDessert extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<Dessert> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dessert_main);

        rv = findViewById(R.id.rv_dessert);
        rv.setHasFixedSize(true);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Droid Cafe");

        list.addAll(dessertData.getListData());
        showReyclerList();



    }

    private void showReyclerList() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        ListDessertAdapter listDessertAdapter = new ListDessertAdapter(list);
        rv.setAdapter(listDessertAdapter);

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
                startActivity(i);
                break;

            case R.id.keranjang:
                Toast.makeText(this, "Bring to bucket", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(this, MainActivity.class);
                startActivity(j);
                break;

        }

    }

}

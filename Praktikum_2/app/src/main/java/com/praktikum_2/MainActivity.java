package com.praktikum_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.radiogrup);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        //untuk mengaktifkan adapter
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //terapkan adapter ke spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "You Selected Order", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this, "You Selected Status", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Toast.makeText(this, "You Selected Favorite", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, MainDessert.class);
                startActivity(i);
                return true;

            case R.id.item4:
                Toast.makeText(this, "You Selected Contact", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.kalender:
                Toast.makeText(this, "You Selected Calender", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(this, DateTime.class);
                startActivity(j);
                return true;

            case R.id.keranjang:
                Toast.makeText(this, "Bring to bucket", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void checkButton(View view) {
        int rbSelected = rg.getCheckedRadioButtonId();

        rb = findViewById(rbSelected);
        Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
    }





    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerLabel = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), spinnerLabel, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

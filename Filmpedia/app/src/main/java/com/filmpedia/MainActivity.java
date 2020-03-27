package com.filmpedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.app.Person;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity{

    private PosterfilmAdapter adapter;
    private  String[] judul, tanggal, desc, rating, genre;
    private TypedArray foto;
    private ArrayList<Posterfilm> posterfilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.lv_main);
        adapter = new PosterfilmAdapter(this);
        lv.setAdapter(adapter);

        prepare();
        addItem();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, DetailActivity.class);

                Posterfilm p = new Posterfilm();
                p.setJudul(judul[position]);
                p.setTanggal(tanggal[position]);
                p.setDeskripsi(desc[position]);
                p.setRating(rating[position]);
                p.setGenre(genre[position]);
                p.setFoto(foto.getResourceId(position, -1));

                posterfilms.add(p);

                //sudah diubah
                i.putExtra(DetailActivity.EXTRA_POSTERFILM, p);
                startActivity(i);

            }
        });

    }

    private void prepare(){
        judul = getResources().getStringArray(R.array.judul_film);
        tanggal = getResources().getStringArray(R.array.tanggal_film);
        desc = getResources().getStringArray(R.array.desc_film);
        rating = getResources().getStringArray(R.array.rating_film);
        foto = getResources().obtainTypedArray(R.array.foto_film);
        genre = getResources().getStringArray(R.array.genre_film);
    }

    private void addItem() {
        posterfilms = new ArrayList<>();


        for (int i=0; i<judul.length; i++){
            Posterfilm pf = new Posterfilm();
            pf.setJudul(judul[i]);
            pf.setTanggal(tanggal[i]);
            pf.setDeskripsi(desc[i]);
            pf.setRating(rating[i]);
            pf.setGenre(genre[i]);
            pf.setFoto(foto.getResourceId(i,-1));

            posterfilms.add(pf);
        }
        adapter.setPosterfilm(posterfilms);
    }
}

package com.filmpedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgDetail;
    TextView judulDetail, tanggalDetail, descDetail, ratingDetail, genreDetail;

    String judul, tanggal, desc, rating, genre;

    Button btnVote;


    public static final String EXTRA_POSTERFILM = "extra_posterfilm";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.ic_share){
            ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String apkpath = api.sourceDir;
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("application/vnd.android.package-archive");
            i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
            startActivity(Intent.createChooser(i, "Bagikan Melalui"));
        }
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.img_detail);
        judulDetail = findViewById(R.id.judul_detail);
        tanggalDetail = findViewById(R.id.tanggal_detail);
        descDetail = findViewById(R.id.desc_detail);
        ratingDetail = findViewById(R.id.rating_detail);
        genreDetail = findViewById(R.id.genre_detail);

        btnVote = findViewById(R.id.btn_vote);
        btnVote.setOnClickListener(this);

        //tidak menggunakan arrayList, saat getIntent
        Posterfilm posterfilms = this.getIntent().getParcelableExtra(EXTRA_POSTERFILM);

        assert posterfilms != null;
        Glide.with(this)
                .load(posterfilms.getFoto())
                .into(imgDetail);

        judul = posterfilms.getJudul();
        judulDetail.setText(judul);

        tanggal = posterfilms.getTanggal();
        tanggalDetail.setText(tanggal);

        desc = posterfilms.getDeskripsi();
        descDetail.setText(desc);

        rating = posterfilms.getRating();
        ratingDetail.setText(rating);

        genre = posterfilms.getGenre();
        genreDetail.setText(genre);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Kamu nge-vote " + judul, Toast.LENGTH_SHORT).show();
    }
}

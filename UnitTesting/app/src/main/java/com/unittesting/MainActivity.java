package com.unittesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.TestLooperManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel mainViewModel;
    
    private Button btnVol, btnCir, btnSur, btnSev;
    private TextView tvHasil;
    private EditText etPjg, etLbr, etTgi;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new MainViewModel(new CuboidModel());
        
        etLbr = findViewById(R.id.et_lebar);
        etPjg = findViewById(R.id.et_panjang);
        etTgi = findViewById(R.id.et_tinggi);
        
        tvHasil = findViewById(R.id.tv_hasil);
        
        btnVol = findViewById(R.id.btn_vol);
        btnSur = findViewById(R.id.btn_surfacearea);
        btnSev = findViewById(R.id.btn_save);
        btnCir = findViewById(R.id.btn_circumference);
        
        btnSev.setOnClickListener(this);
        btnCir.setOnClickListener(this);
        btnSur.setOnClickListener(this);
        btnVol.setOnClickListener(this);
        
        
        
    }

    @Override
    public void onClick(View v) {
        String panjang = etPjg.getText().toString().trim();
        String lenar = etLbr.getText().toString().trim();
        String tinggi = etTgi.getText().toString().trim();
        
        if(TextUtils.isEmpty(panjang)){
            etPjg.setError("Field ini tidak boleh kosong");
        }else if(TextUtils.isEmpty(lenar)){
            etLbr.setError("Field ini tidak boleh kosong");
        }else if(TextUtils.isEmpty(tinggi)){
            etLbr.setError("Field ini tidak boleh kosong");
        }else{
            double p = Double.parseDouble(panjang);
            double l = Double.parseDouble(lenar);
            double t = Double.parseDouble(tinggi);
            
            if(v.getId() == R.id.btn_save){
                mainViewModel.save(p,l,t);
                visible();
            }else if(v.getId() == R.id.btn_vol){
                tvHasil.setText(String.valueOf(mainViewModel.getVolume()));
                gone();
            }else if(v.getId() == R.id.btn_circumference){
                tvHasil.setText(String.valueOf(mainViewModel.getCircumference()));
                gone();
            }else if(v.getId() == R.id.btn_surfacearea){
                tvHasil.setText(String.valueOf(mainViewModel.getSurfacearea()));
                gone();
            }
        }
    }

    private void gone() {
        btnCir.setVisibility(View.GONE);
        btnVol.setVisibility(View.GONE);
        btnSur.setVisibility(View.GONE);
        btnSev.setVisibility(View.VISIBLE);
    }

    private void visible() {
        btnVol.setVisibility(View.VISIBLE);
        btnCir.setVisibility(View.VISIBLE);
        btnSur.setVisibility(View.VISIBLE);
        btnSev.setVisibility(View.GONE);
    }
}

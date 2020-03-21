package com.fragmentfleksibel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener{

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDetail = view.findViewById(R.id.btn_detail_category);
        btnDetail.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_detail_category) {
            DetailFragment df = new DetailFragment();

            Bundle b = new Bundle();
            b.putString(DetailFragment.EXTRA_NAME, "Gaya Hidup");
            String descripion = "Kategori ini berisi Produk-produk Gaya Hidup";

            df.setArguments(b);
            df.setDescription(descripion);

            FragmentManager fm = getFragmentManager();

            if(fm != null){
                fm.beginTransaction()
                        .replace(R.id.main_frame, df, DetailFragment.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }

        }
    }
}

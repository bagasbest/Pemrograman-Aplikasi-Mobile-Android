package com.fragmentfleksibel;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements View.OnClickListener {
    OptionDataFragment.OnOptionDialogListener onOptionDialogListener = new OptionDataFragment.OnOptionDialogListener(){
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };

    Button btnProfil, btnShowDialog;
    TextView tvGayaHidup, tvDetail;

    public static String EXTRA_NAME = "extra_name";
    public  static  String EXTRA_DESCRIPTION = "extra_description";
    private String description;

    public String getDescription(){
        return  description;
    }

    public void setDescription( String description){
        this.description = description;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvGayaHidup = view.findViewById(R.id.tv_gaya_hidup);
        tvDetail = view.findViewById(R.id.tv_Detail);

        btnProfil = view.findViewById(R.id.btn_back_to_activity);
        btnProfil.setOnClickListener(this);

        btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String categoryName= getArguments().getString(EXTRA_NAME);
        tvGayaHidup.setText(categoryName);
        tvDetail.setText(getDescription());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_to_activity:
                Intent i = new Intent(getActivity(), ProfilActivity.class);
                startActivity(i);
                break;
            case  R.id.btn_show_dialog:
                OptionDataFragment option = new OptionDataFragment();

                FragmentManager fm = getChildFragmentManager();
                option.show(fm, OptionDataFragment.class.getSimpleName());
                break;
        }
    }
}

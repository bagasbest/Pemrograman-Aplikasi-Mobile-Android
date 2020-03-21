package com.fragmentfleksibel;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDataFragment extends DialogFragment implements View.OnClickListener {
    Button btnPilih, btnTutup;
    RadioGroup rg;
    RadioButton rbBagas, rbAni, rbMamat, rbOpik, rbSueb;
    OnOptionDialogListener onOptionDialogListener;

    public OptionDataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPilih = view.findViewById(R.id.btn_choose);
        btnPilih.setOnClickListener(this);

        btnTutup = view.findViewById(R.id.btn_close);
        btnTutup.setOnClickListener(this);

        rg = view.findViewById(R.id.radio_option);

        rbAni = view.findViewById(R.id.rb_ani);
        rbBagas = view.findViewById(R.id.rb_bagas);
        rbMamat = view.findViewById(R.id.rb_mamat);
        rbOpik = view.findViewById(R.id.rb_opik);
        rbSueb = view.findViewById(R.id.rb_sueb);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_data, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Fragment f = getParentFragment();

        if(f instanceof DetailFragment){
            DetailFragment df = (DetailFragment) f;
            this.onOptionDialogListener = df.onOptionDialogListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.onOptionDialogListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_close:
                getDialog().cancel();
                break;

            case R.id.btn_choose:
                int checkRadioButtonID = rg.getCheckedRadioButtonId();

                if(checkRadioButtonID != -1){
                    String brillant = null;

                    switch (checkRadioButtonID){
                        case R.id.rb_bagas:
                            brillant = rbBagas.getText().toString().trim();
                            break;

                        case R.id.rb_ani:
                            brillant = rbAni.getText().toString().trim();
                            break;

                        case R.id.rb_mamat:
                            brillant = rbMamat.getText().toString().trim();
                            break;

                        case R.id.rb_opik:
                            brillant = rbOpik.getText().toString().trim();
                            break;

                        case  R.id.rb_sueb:
                            brillant = rbSueb.getText().toString().trim();
                            break;

                    }

                    if(onOptionDialogListener != null){
                        onOptionDialogListener.onOptionChosen(brillant);
                    }
                    getDialog().dismiss();
                }
                break;



        }
    }


    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }
}

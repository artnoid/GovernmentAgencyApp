package com.example.datainstansi.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.datainstansi.R;
import com.example.datainstansi.view.activity.BandungActivity;
import com.example.datainstansi.view.activity.JakbarActivity;
import com.example.datainstansi.view.activity.JakselActivity;
import com.example.datainstansi.view.activity.JaktimActivity;
import com.example.datainstansi.view.activity.JakutActivity;
import com.example.datainstansi.view.activity.PurwakartaActivity;

public class DistrictFragment extends Fragment {

    private Button btnBandung, btnPurwakarta, btnJakbar, btnJaksel,
                    btnJaktim, btnJakut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.district_fragment, container, false);

        btnBandung = view.findViewById(R.id.btnBandung);
        btnPurwakarta = view.findViewById(R.id.btnPurwakarta);
        btnJakbar = view.findViewById(R.id.btnJakbar);
        btnJaksel = view.findViewById(R.id.btnJaksel);
        btnJaktim = view.findViewById(R.id.btnJaktim);
        btnJakut = view.findViewById(R.id.btnJakut);

        btnBandung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(getActivity(),
                        BandungActivity.class);
                startActivity(moveIntent);
            }
        });

        btnPurwakarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(getActivity(),
                        PurwakartaActivity.class);
                startActivity(moveIntent);
            }
        });

        btnJakbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(getActivity(),
                        JakbarActivity.class);
                startActivity(moveIntent);
            }
        });

        btnJaktim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(getActivity(),
                        JaktimActivity.class);
                startActivity(moveIntent);
            }
        });

        btnJaksel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(getActivity(),
                        JakselActivity.class);
                startActivity(moveIntent);
            }
        });

        btnJakut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(getActivity(),
                        JakutActivity.class);
                startActivity(moveIntent);
            }
        });

        return view;
    }
}

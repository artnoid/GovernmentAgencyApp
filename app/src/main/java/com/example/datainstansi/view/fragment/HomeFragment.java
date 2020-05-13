package com.example.datainstansi.view.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.datainstansi.R;
import com.example.datainstansi.datalokal.MessageActivity;
import com.example.datainstansi.datalokal.TampilDBActivity;

public class HomeFragment extends Fragment {

    private Button btnMessage, btnRead;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        btnMessage = view.findViewById(R.id.btnMessage);
        btnRead = view.findViewById(R.id.btnRead);

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(getActivity(),
                        MessageActivity.class);
                startActivity(moveIntent);
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(getActivity(),
                        TampilDBActivity.class);
                startActivity(moveIntent);
            }
        });
        return view;
    }
}

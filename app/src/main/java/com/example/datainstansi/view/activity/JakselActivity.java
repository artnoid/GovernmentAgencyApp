package com.example.datainstansi.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.adapter.BandungDiscoverAdapter;
import com.example.datainstansi.adapter.JakselDiscoverAdapter;
import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;
import com.example.datainstansi.model.district.jakarta_selatan.JakselDiscoverInstansiItem;
import com.example.datainstansi.viewmodel.BandungViewModel;
import com.example.datainstansi.viewmodel.JakselViewModel;

import java.util.ArrayList;

public class JakselActivity extends AppCompatActivity {

    private JakselDiscoverAdapter jakselDiscoverAdapter;
    private RecyclerView rvJakselDiscover;
    private JakselViewModel jakselViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_jaksel);

        jakselDiscoverAdapter = new JakselDiscoverAdapter(this);
        jakselDiscoverAdapter.notifyDataSetChanged();

        rvJakselDiscover = findViewById(R.id.activitymain_rv_subdata);
        rvJakselDiscover.setLayoutManager(new GridLayoutManager(this,1));

        jakselViewModel = new ViewModelProvider(this).get(JakselViewModel.class);
        jakselViewModel.setJakselDiscover();
        jakselViewModel.getJakselDiscover().observe(this,getJakselDiscover);

        rvJakselDiscover.setAdapter(jakselDiscoverAdapter);
    }

    private Observer<ArrayList<JakselDiscoverInstansiItem>> getJakselDiscover = new Observer<ArrayList<JakselDiscoverInstansiItem>>() {
        @Override
        public void onChanged(ArrayList<JakselDiscoverInstansiItem> jakselDiscoverInstansiItems) {
            if (jakselDiscoverInstansiItems != null){
                jakselDiscoverAdapter.setData(jakselDiscoverInstansiItems);
            }
        }
    };
}

package com.example.datainstansi.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.datainstansi.R;
import com.example.datainstansi.adapter.BandungDiscoverAdapter;
import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;
import com.example.datainstansi.viewmodel.BandungViewModel;

import java.util.ArrayList;

public class BandungActivity extends AppCompatActivity {

    private BandungDiscoverAdapter bandungDiscoverAdapter;
    private RecyclerView rvBandungDiscover;
    private BandungViewModel bandungViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_bandung);

        bandungDiscoverAdapter = new BandungDiscoverAdapter(this);
        bandungDiscoverAdapter.notifyDataSetChanged();

        rvBandungDiscover = findViewById(R.id.activitymain_rv_subdata);
        rvBandungDiscover.setLayoutManager(new GridLayoutManager(this,1));

        bandungViewModel = new ViewModelProvider(this).get(BandungViewModel.class);
        bandungViewModel.setBandungDiscover();
        bandungViewModel.getBandungDiscover().observe(this,getBandungDiscover);

        rvBandungDiscover.setAdapter(bandungDiscoverAdapter);
    }

    private Observer<ArrayList<BandungDiscoverInstansiItem>> getBandungDiscover = new Observer<ArrayList<BandungDiscoverInstansiItem>>() {
        @Override
        public void onChanged(ArrayList<BandungDiscoverInstansiItem> bandungDiscoverInstansiItems) {
            if (bandungDiscoverInstansiItems != null){
                bandungDiscoverAdapter.setData(bandungDiscoverInstansiItems);
            }
        }
    };
}

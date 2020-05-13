package com.example.datainstansi.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.adapter.BandungDiscoverAdapter;
import com.example.datainstansi.adapter.JakutDiscoverAdapter;
import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;
import com.example.datainstansi.model.district.jakarta_utara.JakutDiscoverInstansiItem;
import com.example.datainstansi.viewmodel.BandungViewModel;
import com.example.datainstansi.viewmodel.JakutViewModel;

import java.util.ArrayList;

public class JakutActivity extends AppCompatActivity {

    private JakutDiscoverAdapter jakutDiscoverAdapter;
    private RecyclerView rvJakutDiscover;
    private JakutViewModel jakutViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_jakut);

        jakutDiscoverAdapter = new JakutDiscoverAdapter(this);
        jakutDiscoverAdapter.notifyDataSetChanged();

        rvJakutDiscover = findViewById(R.id.activitymain_rv_subdata);
        rvJakutDiscover.setLayoutManager(new GridLayoutManager(this,1));

        jakutViewModel = new ViewModelProvider(this).get(JakutViewModel.class);
        jakutViewModel.setJakutDiscover();
        jakutViewModel.getJakutDiscover().observe(this,getJakutDiscover);

        rvJakutDiscover.setAdapter(jakutDiscoverAdapter);
    }

    private Observer<ArrayList<JakutDiscoverInstansiItem>> getJakutDiscover = new Observer<ArrayList<JakutDiscoverInstansiItem>>() {
        @Override
        public void onChanged(ArrayList<JakutDiscoverInstansiItem> jakutDiscoverInstansiItems) {
            if (jakutDiscoverInstansiItems != null){
                jakutDiscoverAdapter.setData(jakutDiscoverInstansiItems);
            }
        }
    };
}

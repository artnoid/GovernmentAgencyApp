package com.example.datainstansi.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.adapter.BandungDiscoverAdapter;
import com.example.datainstansi.adapter.JaktimDiscoverAdapter;
import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;
import com.example.datainstansi.model.district.jakarta_timur.JaktimDiscoverInstansiItem;
import com.example.datainstansi.viewmodel.BandungViewModel;
import com.example.datainstansi.viewmodel.JaktimViewModel;

import java.util.ArrayList;

public class JaktimActivity extends AppCompatActivity {

    private JaktimDiscoverAdapter jaktimDiscoverAdapter;
    private RecyclerView rvJaktimDiscover;
    private JaktimViewModel jaktimViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_jaktim);

        jaktimDiscoverAdapter = new JaktimDiscoverAdapter(this);
        jaktimDiscoverAdapter.notifyDataSetChanged();

        rvJaktimDiscover = findViewById(R.id.activitymain_rv_subdata);
        rvJaktimDiscover.setLayoutManager(new GridLayoutManager(this,1));

        jaktimViewModel = new ViewModelProvider(this).get(JaktimViewModel.class);
        jaktimViewModel.setJaktimDiscover();
        jaktimViewModel.getJaktimDiscover().observe(this,getJaktimDiscover);

        rvJaktimDiscover.setAdapter(jaktimDiscoverAdapter);
    }

    private Observer<ArrayList<JaktimDiscoverInstansiItem>> getJaktimDiscover = new Observer<ArrayList<JaktimDiscoverInstansiItem>>() {
        @Override
        public void onChanged(ArrayList<JaktimDiscoverInstansiItem> jaktimDiscoverInstansiItems) {
            if (jaktimDiscoverInstansiItems != null){
                jaktimDiscoverAdapter.setData(jaktimDiscoverInstansiItems);
            }
        }
    };
}

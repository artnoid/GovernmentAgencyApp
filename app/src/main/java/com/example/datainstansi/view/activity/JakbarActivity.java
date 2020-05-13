package com.example.datainstansi.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.adapter.BandungDiscoverAdapter;
import com.example.datainstansi.adapter.JakbarDiscoverAdapter;
import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;
import com.example.datainstansi.model.district.jakarta_barat.JakbarDiscoverInstansiItem;
import com.example.datainstansi.viewmodel.BandungViewModel;
import com.example.datainstansi.viewmodel.JakbarViewModel;

import java.util.ArrayList;

public class JakbarActivity extends AppCompatActivity {

    private JakbarDiscoverAdapter jakbarDiscoverAdapter;
    private RecyclerView rvJakbarDiscover;
    private JakbarViewModel jakbarViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_jakbar);

        jakbarDiscoverAdapter = new JakbarDiscoverAdapter(this);
        jakbarDiscoverAdapter.notifyDataSetChanged();

        rvJakbarDiscover = findViewById(R.id.activitymain_rv_subdata);
        rvJakbarDiscover.setLayoutManager(new GridLayoutManager(this,1));

        jakbarViewModel = new ViewModelProvider(this).get(JakbarViewModel.class);
        jakbarViewModel.setJakbarDiscover();
        jakbarViewModel.getJakbarDiscover().observe(this,getJakbarDiscover);

        rvJakbarDiscover.setAdapter(jakbarDiscoverAdapter);
    }

    private Observer<ArrayList<JakbarDiscoverInstansiItem>> getJakbarDiscover = new Observer<ArrayList<JakbarDiscoverInstansiItem>>() {
        @Override
        public void onChanged(ArrayList<JakbarDiscoverInstansiItem> jakbarDiscoverInstansiItems) {
            if (jakbarDiscoverInstansiItems != null){
                jakbarDiscoverAdapter.setData(jakbarDiscoverInstansiItems);
            }
        }
    };
}

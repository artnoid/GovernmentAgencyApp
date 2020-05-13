package com.example.datainstansi.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.adapter.AllDiscoverAdapter;
import com.example.datainstansi.model.all.AllDiscoverInstansiItem;
import com.example.datainstansi.viewmodel.AllViewModel;

import java.util.ArrayList;

public class AllAgencyActivity extends AppCompatActivity {

    private AllDiscoverAdapter allDiscoverAdapter;
    private RecyclerView rvAllDiscover;
    private AllViewModel allViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_all);

        allDiscoverAdapter = new AllDiscoverAdapter(this);
        allDiscoverAdapter.notifyDataSetChanged();

        rvAllDiscover = findViewById(R.id.activitymain_rv_subdata);
        rvAllDiscover.setLayoutManager(new GridLayoutManager(this,1));
        rvAllDiscover.setAdapter(allDiscoverAdapter);

        allViewModel = new ViewModelProvider(this).get(AllViewModel.class);
        allViewModel.setOfficeDiscover();
        allViewModel.getAllDiscover().observe(this,getAllDiscover);

    }

    private Observer<ArrayList<AllDiscoverInstansiItem>> getAllDiscover = new Observer<ArrayList<AllDiscoverInstansiItem>>() {
        @Override
        public void onChanged(ArrayList<AllDiscoverInstansiItem> allDiscoverInstansiItems) {
            if (allDiscoverInstansiItems != null){
                allDiscoverAdapter.setData(allDiscoverInstansiItems);
            }
        }
    };
}

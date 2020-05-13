package com.example.datainstansi.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.adapter.PurwakartaDiscoverAdapter;
import com.example.datainstansi.model.district.purwakarta.PurwakartaDiscoverInstansiItems;
import com.example.datainstansi.viewmodel.PurwakartaViewModel;

import java.util.ArrayList;

public class PurwakartaActivity extends AppCompatActivity {

    private PurwakartaDiscoverAdapter purwakartaDiscoverAdapter;
    private RecyclerView rvPurwakartaDiscover;
    private PurwakartaViewModel purwakartaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_purwakarta);

        purwakartaDiscoverAdapter = new PurwakartaDiscoverAdapter(this);
        purwakartaDiscoverAdapter.notifyDataSetChanged();

        rvPurwakartaDiscover = findViewById(R.id.activitymain_rv_subdata);
        rvPurwakartaDiscover.setLayoutManager(new GridLayoutManager(this,1));

        purwakartaViewModel = new ViewModelProvider(this).get(PurwakartaViewModel.class);
        purwakartaViewModel.setPurwakartaDiscover();
        purwakartaViewModel.getPurwakartaDiscover().observe(this,getPurwakartaDiscover);

        rvPurwakartaDiscover.setAdapter(purwakartaDiscoverAdapter);
    }

    private Observer<ArrayList<PurwakartaDiscoverInstansiItems>> getPurwakartaDiscover = new Observer<ArrayList<PurwakartaDiscoverInstansiItems>>() {
        @Override
        public void onChanged(ArrayList<PurwakartaDiscoverInstansiItems> purakartaDiscoverInstansiItems) {
            if (purakartaDiscoverInstansiItems != null){
                purwakartaDiscoverAdapter.setData(purakartaDiscoverInstansiItems);
            }
        }
    };
}

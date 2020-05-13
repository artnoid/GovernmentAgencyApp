package com.example.datainstansi.view.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.datainstansi.R;
import com.example.datainstansi.adapter.OfficeDiscoverAdapter;
import com.example.datainstansi.model.all.AllDiscoverInstansiItem;
import com.example.datainstansi.view.activity.AllAgencyActivity;
import com.example.datainstansi.viewmodel.AllViewModel;

import java.util.ArrayList;

public class OfficeFragment extends Fragment {

    private OfficeDiscoverAdapter officeDiscoverAdapter;
    private RecyclerView rvOfficeDiscover;
    private AllViewModel allViewModel;
    private Button btnDetail;

    public OfficeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.office_fragment, container, false);
        btnDetail = view.findViewById(R.id.btnDetail);
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(getActivity(), AllAgencyActivity.class);
                startActivity(moveIntent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        officeDiscoverAdapter = new OfficeDiscoverAdapter(getContext());
        officeDiscoverAdapter.notifyDataSetChanged();

        rvOfficeDiscover = view.findViewById(R.id.activitymain_rv_office);
        rvOfficeDiscover.setLayoutManager(new GridLayoutManager(getContext(),1));

        allViewModel = new ViewModelProvider(this).get(AllViewModel.class);
        allViewModel.setOfficeDiscover();
        allViewModel.getAllDiscover().observe(this,getAllDiscover);

        rvOfficeDiscover.setAdapter(officeDiscoverAdapter);
    }

    private Observer<ArrayList<AllDiscoverInstansiItem>> getAllDiscover = new Observer<ArrayList<AllDiscoverInstansiItem>>() {
        @Override
        public void onChanged(ArrayList<AllDiscoverInstansiItem> allDiscoverInstansiItems) {
            if (allDiscoverInstansiItems != null){
                officeDiscoverAdapter.setData(allDiscoverInstansiItems);
            }
        }
    };
}

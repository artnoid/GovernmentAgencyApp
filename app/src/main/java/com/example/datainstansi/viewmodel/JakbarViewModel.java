package com.example.datainstansi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;
import com.example.datainstansi.model.district.bandung.BandungDiscoverResponse;
import com.example.datainstansi.model.district.jakarta_barat.JakbarDiscoverInstansiItem;
import com.example.datainstansi.model.district.jakarta_barat.JakbarDiscoverResponse;
import com.example.datainstansi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JakbarViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<JakbarDiscoverInstansiItem>>
            listDiscoverJakbar = new MutableLiveData<>();

    public void setJakbarDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiJakbar().getJakbarDiscover().enqueue(new Callback<JakbarDiscoverResponse>() {
            @Override
            public void onResponse(Call<JakbarDiscoverResponse> call, Response<JakbarDiscoverResponse> response) {
                JakbarDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getDaftarInstansi() != null){
                    ArrayList<JakbarDiscoverInstansiItem> jakbarDiscoverItems =
                            responseDiscover.getDaftarInstansi();
                    listDiscoverJakbar.postValue(jakbarDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<JakbarDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<JakbarDiscoverInstansiItem>> getJakbarDiscover(){
        return listDiscoverJakbar;
    }
}

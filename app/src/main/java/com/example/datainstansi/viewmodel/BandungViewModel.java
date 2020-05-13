package com.example.datainstansi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;
import com.example.datainstansi.model.district.bandung.BandungDiscoverResponse;
import com.example.datainstansi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BandungViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<BandungDiscoverInstansiItem>>
            listDiscoverBandung = new MutableLiveData<>();

    public void setBandungDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiBandung().getBandungDiscover().enqueue(new Callback<BandungDiscoverResponse>() {
            @Override
            public void onResponse(Call<BandungDiscoverResponse> call, Response<BandungDiscoverResponse> response) {
                BandungDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getDaftarInstansi() != null){
                    ArrayList<BandungDiscoverInstansiItem> bandungDiscoverItems =
                            responseDiscover.getDaftarInstansi();
                    listDiscoverBandung.postValue(bandungDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<BandungDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<BandungDiscoverInstansiItem>> getBandungDiscover(){
        return listDiscoverBandung;
    }
}

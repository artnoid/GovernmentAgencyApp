package com.example.datainstansi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;
import com.example.datainstansi.model.district.bandung.BandungDiscoverResponse;
import com.example.datainstansi.model.district.jakarta_timur.JaktimDiscoverInstansiItem;
import com.example.datainstansi.model.district.jakarta_timur.JaktimDiscoverResponse;
import com.example.datainstansi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JaktimViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<JaktimDiscoverInstansiItem>>
            listDiscoverJaktim = new MutableLiveData<>();

    public void setJaktimDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiJaktim().getJaktimDiscover().enqueue(new Callback<JaktimDiscoverResponse>() {
            @Override
            public void onResponse(Call<JaktimDiscoverResponse> call, Response<JaktimDiscoverResponse> response) {
                JaktimDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getDaftarInstansi() != null){
                    ArrayList<JaktimDiscoverInstansiItem> jaktimDiscoverItems =
                            responseDiscover.getDaftarInstansi();
                    listDiscoverJaktim.postValue(jaktimDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<JaktimDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<JaktimDiscoverInstansiItem>> getJaktimDiscover(){
        return listDiscoverJaktim;
    }
}

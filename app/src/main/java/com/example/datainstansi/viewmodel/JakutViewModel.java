package com.example.datainstansi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.datainstansi.model.district.jakarta_utara.JakutDiscoverInstansiItem;
import com.example.datainstansi.model.district.jakarta_utara.JakutDiscoverResponse;
import com.example.datainstansi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JakutViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<JakutDiscoverInstansiItem>>
            listDiscoverJakut = new MutableLiveData<>();

    public void setJakutDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiJakut().getJakutDiscover().enqueue(new Callback<JakutDiscoverResponse>() {
            @Override
            public void onResponse(Call<JakutDiscoverResponse> call, Response<JakutDiscoverResponse> response) {
                JakutDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getDaftarInstansi() != null){
                    ArrayList<JakutDiscoverInstansiItem> jakutDiscoverItems =
                            responseDiscover.getDaftarInstansi();
                    listDiscoverJakut.postValue(jakutDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<JakutDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<JakutDiscoverInstansiItem>> getJakutDiscover(){
        return listDiscoverJakut;
    }
}

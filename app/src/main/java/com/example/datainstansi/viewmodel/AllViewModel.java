package com.example.datainstansi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.datainstansi.model.all.AllDiscoverInstansiItem;
import com.example.datainstansi.model.all.AllDiscoverResponse;
import com.example.datainstansi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<AllDiscoverInstansiItem>>
            listDiscoverAll = new MutableLiveData<>();

    public void setOfficeDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiAll().getAllDiscover().enqueue(new Callback<AllDiscoverResponse>() {
            @Override
            public void onResponse(Call<AllDiscoverResponse> call, Response<AllDiscoverResponse> response) {
                AllDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getInstansi() != null){
                    ArrayList<AllDiscoverInstansiItem> allDiscoverItems =
                            responseDiscover.getInstansi();
                    listDiscoverAll.postValue(allDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<AllDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<AllDiscoverInstansiItem>> getAllDiscover(){
        return listDiscoverAll;
    }
}

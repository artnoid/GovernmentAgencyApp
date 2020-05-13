package com.example.datainstansi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;
import com.example.datainstansi.model.district.bandung.BandungDiscoverResponse;
import com.example.datainstansi.model.district.jakarta_selatan.JakselDiscoverInstansiItem;
import com.example.datainstansi.model.district.jakarta_selatan.JakselDiscoverResponse;
import com.example.datainstansi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JakselViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<JakselDiscoverInstansiItem>>
            listDiscoverJaksel = new MutableLiveData<>();

    public void setJakselDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiJaksel().getJakselDiscover().enqueue(new Callback<JakselDiscoverResponse>() {
            @Override
            public void onResponse(Call<JakselDiscoverResponse> call, Response<JakselDiscoverResponse> response) {
                JakselDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getDaftarInstansi() != null){
                    ArrayList<JakselDiscoverInstansiItem> jakselDiscoverItems =
                            responseDiscover.getDaftarInstansi();
                    listDiscoverJaksel.postValue(jakselDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<JakselDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<JakselDiscoverInstansiItem>> getJakselDiscover(){
        return listDiscoverJaksel;
    }
}

package com.example.datainstansi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.datainstansi.model.district.purwakarta.PurwakartaDiscoverInstansiItems;
import com.example.datainstansi.model.district.purwakarta.PurwakartaDiscoverResponse;
import com.example.datainstansi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PurwakartaViewModel extends ViewModel {

    private ApiMain apiMain;
    private MutableLiveData<ArrayList<PurwakartaDiscoverInstansiItems>>
            listDiscoverPurwakarta = new MutableLiveData<>();

    public void setPurwakartaDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiPurwakarta().getPurwakartaDiscover().enqueue(new Callback<PurwakartaDiscoverResponse>() {
            @Override
            public void onResponse(Call<PurwakartaDiscoverResponse> call, Response<PurwakartaDiscoverResponse> response) {
                PurwakartaDiscoverResponse responseDiscover = response.body();
                if (responseDiscover != null && responseDiscover.getDaftarInstansi() != null){
                    ArrayList<PurwakartaDiscoverInstansiItems> purwakartaDiscoverItems =
                            responseDiscover.getDaftarInstansi();
                    listDiscoverPurwakarta.postValue(purwakartaDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<PurwakartaDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<PurwakartaDiscoverInstansiItems>> getPurwakartaDiscover(){
        return listDiscoverPurwakarta;
    }
}

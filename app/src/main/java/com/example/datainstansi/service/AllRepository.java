package com.example.datainstansi.service;

import com.example.datainstansi.model.all.AllDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AllRepository {

    @GET("semuainstansi")
    Call<AllDiscoverResponse> getAllDiscover();

}

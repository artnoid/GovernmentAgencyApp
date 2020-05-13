package com.example.datainstansi.service;

import com.example.datainstansi.model.district.purwakarta.PurwakartaDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PurwakartaRepository {

    @GET("daftar_instansi/Kabupaten Purwakarta")
    Call<PurwakartaDiscoverResponse> getPurwakartaDiscover();
}

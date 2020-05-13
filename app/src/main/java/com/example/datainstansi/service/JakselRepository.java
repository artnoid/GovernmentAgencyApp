package com.example.datainstansi.service;

import com.example.datainstansi.model.district.bandung.BandungDiscoverResponse;
import com.example.datainstansi.model.district.jakarta_selatan.JakselDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JakselRepository {

    @GET("daftar_instansi/Kota Jakarta Selatan")
    Call<JakselDiscoverResponse> getJakselDiscover();
}

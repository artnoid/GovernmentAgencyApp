package com.example.datainstansi.service;

import com.example.datainstansi.model.district.bandung.BandungDiscoverResponse;
import com.example.datainstansi.model.district.jakarta_barat.JakbarDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JakbarRepository {

    @GET("daftar_instansi/Kota Jakarta Barat")
    Call<JakbarDiscoverResponse> getJakbarDiscover();
}

package com.example.datainstansi.service;

import com.example.datainstansi.model.district.bandung.BandungDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BandungRepository {

    @GET("daftar_instansi/Kota Bandung")
    Call<BandungDiscoverResponse> getBandungDiscover();
}

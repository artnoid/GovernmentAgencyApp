package com.example.datainstansi.service;

import com.example.datainstansi.model.district.bandung.BandungDiscoverResponse;
import com.example.datainstansi.model.district.jakarta_barat.JakbarDiscoverResponse;
import com.example.datainstansi.model.district.jakarta_timur.JaktimDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JaktimRepository {

    @GET("daftar_instansi/Kota Jakarta Timur")
    Call<JaktimDiscoverResponse> getJaktimDiscover();
}

package com.example.datainstansi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public AllRepository getApiAll(){
        String BASE_URL = "http://dev.farizdotid.com/api/instansi/";
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(AllRepository.class);
    }

    public BandungRepository getApiBandung(){
        String BASE_URL = "http://dev.farizdotid.com/api/instansi/";
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(BandungRepository.class);
    }

    public PurwakartaRepository getApiPurwakarta(){
        String BASE_URL = "http://dev.farizdotid.com/api/instansi/";
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(PurwakartaRepository.class);
    }

    public JakbarRepository getApiJakbar(){
        String BASE_URL = "http://dev.farizdotid.com/api/instansi/";
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(JakbarRepository.class);
    }

    public JaktimRepository getApiJaktim(){
        String BASE_URL = "http://dev.farizdotid.com/api/instansi/";
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(JaktimRepository.class);
    }

    public JakutRepository getApiJakut(){
        String BASE_URL = "http://dev.farizdotid.com/api/instansi/";
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(JakutRepository.class);
    }

    public JakselRepository getApiJaksel(){
        String BASE_URL = "http://dev.farizdotid.com/api/instansi/";
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(JakselRepository.class);
    }
}

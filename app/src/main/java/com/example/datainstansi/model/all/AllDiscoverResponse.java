package com.example.datainstansi.model.all;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class AllDiscoverResponse {

	@SerializedName("instansi")
	private ArrayList<AllDiscoverInstansiItem> instansi;

	public void setInstansi(ArrayList<AllDiscoverInstansiItem> instansi){
		this.instansi = instansi;
	}

	public ArrayList<AllDiscoverInstansiItem> getInstansi(){
		return instansi;
	}

	@Override
 	public String toString(){
		return 
			"AllDiscoverResponse{" +
			"instansi = '" + instansi + '\'' + 
			"}";
		}
}
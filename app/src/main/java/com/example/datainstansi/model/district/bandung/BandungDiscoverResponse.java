package com.example.datainstansi.model.district.bandung;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BandungDiscoverResponse {

	@SerializedName("daftar_instansi")
	private ArrayList<BandungDiscoverInstansiItem> daftarInstansi;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setDaftarInstansi(ArrayList<BandungDiscoverInstansiItem> daftarInstansi){
		this.daftarInstansi = daftarInstansi;
	}

	public ArrayList<BandungDiscoverInstansiItem> getDaftarInstansi(){
		return daftarInstansi;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"BandungDiscoverResponse{" +
			"daftar_instansi = '" + daftarInstansi + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
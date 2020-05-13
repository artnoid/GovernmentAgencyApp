package com.example.datainstansi.model.district.jakarta_selatan;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class JakselDiscoverResponse {

	@SerializedName("daftar_instansi")
	private ArrayList<JakselDiscoverInstansiItem> daftarInstansi;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setDaftarInstansi(ArrayList<JakselDiscoverInstansiItem> daftarInstansi){
		this.daftarInstansi = daftarInstansi;
	}

	public ArrayList<JakselDiscoverInstansiItem> getDaftarInstansi(){
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
			"JakselDiscoverResponse{" +
			"daftar_instansi = '" + daftarInstansi + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
package com.example.datainstansi.model.district.jakarta_utara;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class JakutDiscoverResponse {

	@SerializedName("daftar_instansi")
	private ArrayList<JakutDiscoverInstansiItem> daftarInstansi;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setDaftarInstansi(ArrayList<JakutDiscoverInstansiItem> daftarInstansi){
		this.daftarInstansi = daftarInstansi;
	}

	public ArrayList<JakutDiscoverInstansiItem> getDaftarInstansi(){
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
			"JakutDiscoverResponse{" +
			"daftar_instansi = '" + daftarInstansi + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
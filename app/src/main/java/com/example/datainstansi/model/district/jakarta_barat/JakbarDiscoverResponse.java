package com.example.datainstansi.model.district.jakarta_barat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class JakbarDiscoverResponse {

	@SerializedName("daftar_instansi")
	private ArrayList<JakbarDiscoverInstansiItem> daftarInstansi;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	public void setDaftarInstansi(ArrayList<JakbarDiscoverInstansiItem> daftarInstansi){
		this.daftarInstansi = daftarInstansi;
	}

	public ArrayList<JakbarDiscoverInstansiItem> getDaftarInstansi(){
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
			"JakbarDiscoverResponse{" +
			"daftar_instansi = '" + daftarInstansi + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}
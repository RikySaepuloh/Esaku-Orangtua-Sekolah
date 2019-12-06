package com.saku.sekolah.model.login;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class PpItem{

	@SerializedName("nama")
	private String nama;

	@SerializedName("kode_pp")
	private String kodePp;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setKodePp(String kodePp){
		this.kodePp = kodePp;
	}

	public String getKodePp(){
		return kodePp;
	}

	@Override
 	public String toString(){
		return 
			"PpItem{" + 
			"nama = '" + nama + '\'' + 
			",kode_pp = '" + kodePp + '\'' + 
			"}";
		}
}
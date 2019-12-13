package com.saku.sekolah.model.beranda.prestasi;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Prestasi{

	@SerializedName("daftar")
	private List<DaftarPrestasi> daftar;

	@SerializedName("status")
	private boolean status;

	public void setDaftar(List<DaftarPrestasi> daftar){
		this.daftar = daftar;
	}

	public List<DaftarPrestasi> getDaftar(){
		return daftar;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Prestasi{" + 
			"daftar = '" + daftar + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
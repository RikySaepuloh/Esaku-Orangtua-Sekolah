package com.saku.sekolah.model.keuangan;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Riwayat{

	@SerializedName("daftar")
	private List<RiwayatItem> daftar;

	@SerializedName("status")
	private boolean status;

	public void setDaftar(List<RiwayatItem> daftar){
		this.daftar = daftar;
	}

	public List<RiwayatItem> getDaftar(){
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
			"Riwayat{" + 
			"daftar = '" + daftar + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
package com.saku.sekolah.model.keuangan;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Piutang{

	@SerializedName("so_akhir")
	private String soAkhir;

	@SerializedName("daftar")
	private List<PiutangItem> daftar;

	@SerializedName("daftar2")
	private List<Piutang2Item> daftar2;

	@SerializedName("status")
	private boolean status;

	public void setSoAkhir(String soAkhir){
		this.soAkhir = soAkhir;
	}

	public String getSoAkhir(){
		return soAkhir;
	}

	public void setDaftar(List<PiutangItem> daftar){
		this.daftar = daftar;
	}

	public List<PiutangItem> getDaftar(){
		return daftar;
	}

	public void setDaftar2(List<Piutang2Item> daftar2){
		this.daftar2 = daftar2;
	}

	public List<Piutang2Item> getDaftar2(){
		return daftar2;
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
			"Piutang{" + 
			"so_akhir = '" + soAkhir + '\'' + 
			",daftar = '" + daftar + '\'' + 
			",daftar2 = '" + daftar2 + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
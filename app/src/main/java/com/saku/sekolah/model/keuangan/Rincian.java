package com.saku.sekolah.model.keuangan;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Rincian{

	@SerializedName("daftar")
	private List<RincianItem> daftar;

	@SerializedName("daftar2")
	private List<Rincian2Item> daftar2;

	@SerializedName("daftar3")
	private List<Rincian3Item> daftar3;

	@SerializedName("status")
	private boolean status;

	public void setDaftar(List<RincianItem> daftar){
		this.daftar = daftar;
	}

	public List<RincianItem> getDaftar(){
		return daftar;
	}

	public void setDaftar2(List<Rincian2Item> daftar2){
		this.daftar2 = daftar2;
	}

	public List<Rincian2Item> getDaftar2(){
		return daftar2;
	}

	public void setDaftar3(List<Rincian3Item> daftar3){
		this.daftar3 = daftar3;
	}

	public List<Rincian3Item> getDaftar3(){
		return daftar3;
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
			"Rincian{" + 
			"daftar = '" + daftar + '\'' + 
			",daftar2 = '" + daftar2 + '\'' + 
			",daftar3 = '" + daftar3 + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
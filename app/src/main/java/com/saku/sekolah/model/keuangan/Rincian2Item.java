package com.saku.sekolah.model.keuangan;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Rincian2Item {

	@SerializedName("no_bill")
	private String noBill;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("jum_param")
	private String jumParam;

	@SerializedName("periode")
	private String periode;

	public void setNoBill(String noBill){
		this.noBill = noBill;
	}

	public String getNoBill(){
		return noBill;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setJumParam(String jumParam){
		this.jumParam = jumParam;
	}

	public String getJumParam(){
		return jumParam;
	}

	public void setPeriode(String periode){
		this.periode = periode;
	}

	public String getPeriode(){
		return periode;
	}

	@Override
 	public String toString(){
		return 
			"Rincian2Item{" +
			"no_bill = '" + noBill + '\'' + 
			",tanggal = '" + tanggal + '\'' + 
			",jum_param = '" + jumParam + '\'' + 
			",periode = '" + periode + '\'' + 
			"}";
		}
}
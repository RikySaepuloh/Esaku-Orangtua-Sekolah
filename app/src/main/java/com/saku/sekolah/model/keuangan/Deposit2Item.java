package com.saku.sekolah.model.keuangan;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Deposit2Item {

	@SerializedName("debet")
	private String debet;

	@SerializedName("no_bukti")
	private String noBukti;

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("tgl")
	private String tgl;

	@SerializedName("modul")
	private String modul;

	@SerializedName("kredit")
	private String kredit;

	@SerializedName("dc")
	private String dc;

	public void setDebet(String debet){
		this.debet = debet;
	}

	public String getDebet(){
		return debet;
	}

	public void setNoBukti(String noBukti){
		this.noBukti = noBukti;
	}

	public String getNoBukti(){
		return noBukti;
	}

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public String getKeterangan(){
		return keterangan;
	}

	public void setTgl(String tgl){
		this.tgl = tgl;
	}

	public String getTgl(){
		return tgl;
	}

	public void setModul(String modul){
		this.modul = modul;
	}

	public String getModul(){
		return modul;
	}

	public void setKredit(String kredit){
		this.kredit = kredit;
	}

	public String getKredit(){
		return kredit;
	}

	public void setDc(String dc){
		this.dc = dc;
	}

	public String getDc(){
		return dc;
	}

	@Override
 	public String toString(){
		return 
			"Deposit2Item{" +
			"debet = '" + debet + '\'' + 
			",no_bukti = '" + noBukti + '\'' + 
			",keterangan = '" + keterangan + '\'' + 
			",tgl = '" + tgl + '\'' + 
			",modul = '" + modul + '\'' + 
			",kredit = '" + kredit + '\'' + 
			",dc = '" + dc + '\'' + 
			"}";
		}
}
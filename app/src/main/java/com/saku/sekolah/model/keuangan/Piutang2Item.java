package com.saku.sekolah.model.keuangan;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Piutang2Item {

	@SerializedName("no_bukti")
	private String noBukti;

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("kode_lokasi")
	private String kodeLokasi;

	@SerializedName("tagihan")
	private String tagihan;

	@SerializedName("tgl")
	private String tgl;

	@SerializedName("bayar")
	private String bayar;

	@SerializedName("modul")
	private String modul;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("kode_param")
	private String kodeParam;

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

	public void setKodeLokasi(String kodeLokasi){
		this.kodeLokasi = kodeLokasi;
	}

	public String getKodeLokasi(){
		return kodeLokasi;
	}

	public void setTagihan(String tagihan){
		this.tagihan = tagihan;
	}

	public String getTagihan(){
		return tagihan;
	}

	public void setTgl(String tgl){
		this.tgl = tgl;
	}

	public String getTgl(){
		return tgl;
	}

	public void setBayar(String bayar){
		this.bayar = bayar;
	}

	public String getBayar(){
		return bayar;
	}

	public void setModul(String modul){
		this.modul = modul;
	}

	public String getModul(){
		return modul;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setKodeParam(String kodeParam){
		this.kodeParam = kodeParam;
	}

	public String getKodeParam(){
		return kodeParam;
	}

	@Override
 	public String toString(){
		return 
			"Piutang2Item{" +
			"no_bukti = '" + noBukti + '\'' + 
			",keterangan = '" + keterangan + '\'' + 
			",kode_lokasi = '" + kodeLokasi + '\'' + 
			",tagihan = '" + tagihan + '\'' + 
			",tgl = '" + tgl + '\'' + 
			",bayar = '" + bayar + '\'' + 
			",modul = '" + modul + '\'' + 
			",tanggal = '" + tanggal + '\'' + 
			",kode_param = '" + kodeParam + '\'' + 
			"}";
		}
}
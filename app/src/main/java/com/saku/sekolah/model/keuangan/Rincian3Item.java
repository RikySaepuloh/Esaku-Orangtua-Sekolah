package com.saku.sekolah.model.keuangan;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Rincian3Item {

	@SerializedName("nama")
	private String nama;

	@SerializedName("no_bill")
	private String noBill;

	@SerializedName("nis")
	private String nis;

	@SerializedName("bill")
	private String bill;

	@SerializedName("bayar")
	private String bayar;

	@SerializedName("saldo")
	private String saldo;

	@SerializedName("tanggal")
	private String tanggal;

	@SerializedName("kode_param")
	private String kodeParam;

	@SerializedName("periode")
	private String periode;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setNoBill(String noBill){
		this.noBill = noBill;
	}

	public String getNoBill(){
		return noBill;
	}

	public void setNis(String nis){
		this.nis = nis;
	}

	public String getNis(){
		return nis;
	}

	public void setBill(String bill){
		this.bill = bill;
	}

	public String getBill(){
		return bill;
	}

	public void setBayar(String bayar){
		this.bayar = bayar;
	}

	public String getBayar(){
		return bayar;
	}

	public void setSaldo(String saldo){
		this.saldo = saldo;
	}

	public String getSaldo(){
		return saldo;
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

	public void setPeriode(String periode){
		this.periode = periode;
	}

	public String getPeriode(){
		return periode;
	}

	@Override
 	public String toString(){
		return 
			"Rincian3Item{" +
			"nama = '" + nama + '\'' + 
			",no_bill = '" + noBill + '\'' + 
			",nis = '" + nis + '\'' + 
			",bill = '" + bill + '\'' + 
			",bayar = '" + bayar + '\'' + 
			",saldo = '" + saldo + '\'' + 
			",tanggal = '" + tanggal + '\'' + 
			",kode_param = '" + kodeParam + '\'' + 
			",periode = '" + periode + '\'' + 
			"}";
		}
}
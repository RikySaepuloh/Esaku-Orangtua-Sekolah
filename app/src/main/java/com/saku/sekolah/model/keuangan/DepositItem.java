package com.saku.sekolah.model.keuangan;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DepositItem {

	@SerializedName("kode_akt")
	private String kodeAkt;

	@SerializedName("kode_lokasi")
	private String kodeLokasi;

	@SerializedName("nama_kelas")
	private String namaKelas;

	@SerializedName("nama_jur")
	private String namaJur;

	@SerializedName("kode_pp")
	private String kodePp;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("kode_kelas")
	private String kodeKelas;

	@SerializedName("nama")
	private String nama;

	@SerializedName("nis")
	private String nis;

	@SerializedName("nama_pp")
	private String namaPp;

	@SerializedName("alamat2")
	private String alamat2;

	@SerializedName("id_bank")
	private String idBank;

	@SerializedName("kode_jur")
	private String kodeJur;

	public void setKodeAkt(String kodeAkt){
		this.kodeAkt = kodeAkt;
	}

	public String getKodeAkt(){
		return kodeAkt;
	}

	public void setKodeLokasi(String kodeLokasi){
		this.kodeLokasi = kodeLokasi;
	}

	public String getKodeLokasi(){
		return kodeLokasi;
	}

	public void setNamaKelas(String namaKelas){
		this.namaKelas = namaKelas;
	}

	public String getNamaKelas(){
		return namaKelas;
	}

	public void setNamaJur(String namaJur){
		this.namaJur = namaJur;
	}

	public String getNamaJur(){
		return namaJur;
	}

	public void setKodePp(String kodePp){
		this.kodePp = kodePp;
	}

	public String getKodePp(){
		return kodePp;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setKodeKelas(String kodeKelas){
		this.kodeKelas = kodeKelas;
	}

	public String getKodeKelas(){
		return kodeKelas;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setNis(String nis){
		this.nis = nis;
	}

	public String getNis(){
		return nis;
	}

	public void setNamaPp(String namaPp){
		this.namaPp = namaPp;
	}

	public String getNamaPp(){
		return namaPp;
	}

	public void setAlamat2(String alamat2){
		this.alamat2 = alamat2;
	}

	public String getAlamat2(){
		return alamat2;
	}

	public void setIdBank(String idBank){
		this.idBank = idBank;
	}

	public String getIdBank(){
		return idBank;
	}

	public void setKodeJur(String kodeJur){
		this.kodeJur = kodeJur;
	}

	public String getKodeJur(){
		return kodeJur;
	}

	@Override
 	public String toString(){
		return 
			"DepositItem{" +
			"kode_akt = '" + kodeAkt + '\'' + 
			",kode_lokasi = '" + kodeLokasi + '\'' + 
			",nama_kelas = '" + namaKelas + '\'' + 
			",nama_jur = '" + namaJur + '\'' + 
			",kode_pp = '" + kodePp + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",kode_kelas = '" + kodeKelas + '\'' + 
			",nama = '" + nama + '\'' + 
			",nis = '" + nis + '\'' + 
			",nama_pp = '" + namaPp + '\'' + 
			",alamat2 = '" + alamat2 + '\'' + 
			",id_bank = '" + idBank + '\'' + 
			",kode_jur = '" + kodeJur + '\'' + 
			"}";
		}
}
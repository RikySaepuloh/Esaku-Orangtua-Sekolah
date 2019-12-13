package com.saku.sekolah.model.beranda.prestasi;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class DaftarPrestasi {

	@SerializedName("no_bukti")
	private String noBukti;

	@SerializedName("keterangan")
	private String keterangan;

	@SerializedName("tempat")
	private String tempat;

	@SerializedName("tgl")
	private String tgl;

	@SerializedName("jenis")
	private String jenis;

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

	public void setTempat(String tempat){
		this.tempat = tempat;
	}

	public String getTempat(){
		return tempat;
	}

	public void setTgl(String tgl){
		this.tgl = tgl;
	}

	public String getTgl(){
		return tgl;
	}

	public void setJenis(String jenis){
		this.jenis = jenis;
	}

	public String getJenis(){
		return jenis;
	}

	@Override
 	public String toString(){
		return 
			"DaftarPrestasi{" +
			"no_bukti = '" + noBukti + '\'' + 
			",keterangan = '" + keterangan + '\'' + 
			",tempat = '" + tempat + '\'' + 
			",tgl = '" + tgl + '\'' + 
			",jenis = '" + jenis + '\'' + 
			"}";
		}
}
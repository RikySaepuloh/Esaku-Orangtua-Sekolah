package com.saku.sekolah.model.keuangan;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Keuangan{

	@SerializedName("saldo")
	private String saldo;

	@SerializedName("status")
	private boolean status;

	public void setSaldo(String saldo){
		this.saldo = saldo;
	}

	public String getSaldo(){
		return saldo;
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
			"Keuangan{" + 
			"saldo = '" + saldo + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
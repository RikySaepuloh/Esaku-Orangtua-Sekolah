package com.saku.sekolah.model.keuangan;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class RincianItem {

	@SerializedName("periode")
	private String periode;

	public void setPeriode(String periode){
		this.periode = periode;
	}

	public String getPeriode(){
		return periode;
	}

	@Override
 	public String toString(){
		return 
			"RincianItem{" +
			"periode = '" + periode + '\'' + 
			"}";
		}
}
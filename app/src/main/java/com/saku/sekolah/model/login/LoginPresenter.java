package com.saku.sekolah.model.login;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LoginPresenter{

	@SerializedName("pp")
	private List<PpItem> pp;

	public void setPp(List<PpItem> pp){
		this.pp = pp;
	}

	public List<PpItem> getPp(){
		return pp;
	}

	@Override
 	public String toString(){
		return 
			"LoginPresenter{" + 
			"pp = '" + pp + '\'' + 
			"}";
		}
}
package com.saku.sekolah.apihelper;

import android.app.Activity;
import android.content.Context;

public class UtilsApi {
    // Ini untuk base url nya
    public static final String BASE_URL_API = "http://saiweb.simkug.com/api/siswa/";

    // Mendeklarasikan Interface BaseApiService\
    public static BaseApiService getAPIService(Context context){
        return RetrofitClient.getClient(BASE_URL_API, context).create(BaseApiService.class);
    }
}

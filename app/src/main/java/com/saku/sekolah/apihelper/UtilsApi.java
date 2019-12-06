package com.saku.sekolah.apihelper;

public class UtilsApi {
    // Ini untuk base url nya
    public static final String BASE_URL_API = "http://saiweb.simkug.com/api/siswa/";

    // Mendeklarasikan Interface BaseApiService\
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}

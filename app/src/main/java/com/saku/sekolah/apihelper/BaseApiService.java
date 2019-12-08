package com.saku.sekolah.apihelper;

import com.saku.sekolah.model.keuangan.Piutang;
import com.saku.sekolah.model.login.KodePpPresenter;
import com.saku.sekolah.model.login.Login;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("Login.php?fx=login") // Ini untuk methodnya
    Call<Login> login(
            @Field("nik") String nik,
            @Field("pass") String pass,
            @Field("kode_pp") String kode_pp);

    @FormUrlEncoded
    @POST("Login.php?fx=getDaftarPP") // Ini untuk methodnya
    Call<KodePpPresenter> getDaftarPP(
            @Field("nis") String nis);

    @GET("Keuangan.php?fx=getPDD") // Ini untuk methodnya
    Call<Piutang> getPiutang(
            @Query("token") String token,
            @Query("nik") String nik,
            @Query("kode_pp") String kode_pp,
            @Query("kode_lokasi") String kode_lokasi
            );

}

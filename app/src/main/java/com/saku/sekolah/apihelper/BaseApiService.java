package com.saku.sekolah.apihelper;

import com.saku.sekolah.model.beranda.prestasi.Prestasi;
import com.saku.sekolah.model.keuangan.Deposit;
import com.saku.sekolah.model.keuangan.Piutang;
import com.saku.sekolah.model.keuangan.Rincian;
import com.saku.sekolah.model.keuangan.Riwayat;
import com.saku.sekolah.model.login.KodePpPresenter;
import com.saku.sekolah.model.login.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

//    @GET("Eskul.php?fx=getEskul") // Ini untuk methodnya
//    Call<Ekskul> getEkskul(
//            @Query("nik") String nik,
//            @Query("kode_pp") String kode_pp,
//            @Query("kode_lokasi") String kode_lokasi
//    );

    @GET("Prestasi.php?fx=getPrestasi") // Ini untuk methodnya
    Call<Prestasi> getPrestasi(
            @Query("nik") String nik,
            @Query("kode_pp") String kode_pp,
            @Query("kode_lokasi") String kode_lokasi
    );

    @GET("Keuangan.php?fx=getPDD") // Ini untuk methodnya
    Call<Deposit> getDeposit(
            @Query("nik") String nik,
            @Query("kode_pp") String kode_pp,
            @Query("kode_lokasi") String kode_lokasi
            );

    @GET("Keuangan.php?fx=getPiutang") // Ini untuk methodnya
    Call<Piutang> getPiutang(
            @Query("nik") String nik,
            @Query("kode_pp") String kode_pp,
            @Query("kode_lokasi") String kode_lokasi
    );


    @GET("Keuangan.php?fx=getRiwayat") // Ini untuk methodnya
    Call<Riwayat> getRiwayat(
            @Query("nik") String nik,
            @Query("kode_pp") String kode_pp,
            @Query("kode_lokasi") String kode_lokasi
    );

    @GET("Keuangan.php?fx=getDetailPiu") // Ini untuk methodnya
    Call<Rincian> getRincian(
            @Query("nik") String nik,
            @Query("kode_pp") String kode_pp,
            @Query("kode_lokasi") String kode_lokasi,
            @Query("tahun") String tahun
    );

}

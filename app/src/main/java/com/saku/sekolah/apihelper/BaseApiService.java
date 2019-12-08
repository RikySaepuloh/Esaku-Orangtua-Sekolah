package com.saku.sekolah.apihelper;

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

    @GET("Aset.php?fx=getDataAset") // Ini untuk methodnya
    Call<ResponseBody> getDataAset(
            @Query("qrcode") String qrcode,
            @Query("token") String token
    );

    @Multipart
    @POST("Aset.php?fx=ubahGambarAset")
    Call<ResponseBody>ubahGambarAset(
            @Part MultipartBody.Part file_gambar,
            @Part("filename") RequestBody name,
            @Part("no_bukti") RequestBody no_bukti,
            @Part("kode_lokasi") RequestBody kode_lokasi,
            @Part("token") RequestBody token
    );

    @Multipart
    @POST("Aset.php?fx=simpanInventaris")
    Call<ResponseBody>simpanInventaris(
            @Part MultipartBody.Part file_gambar,
            @Part("filename") RequestBody name,
            @Part("kode_lokasi") RequestBody kode_lokasi,
            @Part("no_ruangan") RequestBody no_ruangan,
            @Part("kode_aset") RequestBody kode_aset,
            @Part("kondisi") RequestBody kondisi,
            @Part("token") RequestBody token
    );

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

    @GET("Aset.php?fx=getDaftarAsset") // Ini untuk methodnya
    Call<ResponseBody> getDaftarAsset(
            @Query("kode_lokasi") String kode_lokasi,
            @Query("no_ruangan") String no_ruangan,
            @Query("kondisi") String kondisi,
            @Query("token") String token
    );

    @GET("Aset.php?fx=getPerbaikan") // Ini untuk methodnya
    Call<ResponseBody> getPerbaikan(
            @Query("kode_lokasi") String kode_lokasi,
            @Query("token") String token
    );

    @GET("Aset.php?fx=getLokasi") // Ini untuk methodnya
    Call<ResponseBody> getLokasi(
            @Query("kodePP") String kode_pp,
            @Query("token") String token
    );

    @GET("Aset.php?fx=getDetailPerbaikan") // Ini untuk methodnya
    Call<ResponseBody> getDetailPerbaikan(
            @Query("kode_lokasi") String kode_lokasi,
            @Query("mon_id") String mon_id,
            @Query("token") String token
    );

    @GET("Aset.php?fx=getInventarisBerjalan") // Ini untuk methodnya
    Call<ResponseBody> getInventarisBerjalan(
            @Query("kode_lokasi") String kode_lokasi,
            @Query("token") String token
    );

    @FormUrlEncoded
    @POST("Aset.php?fx=getGedung") // Ini untuk methodnya
    Call<ResponseBody> getGedung(
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("Aset.php?fx=getRuangan") // Ini untuk methodnya
    Call<ResponseBody> getRuangan(
            @Field("id_gedung") String id_gedung,
            @Field("token") String token
    );

    @FormUrlEncoded
    @POST("Aset.php?fx=getBarang") // Ini untuk methodnya
    Call<ResponseBody> getJenisBarang(
            @Field("id_ruangan") String id_ruangan,
            @Field("token") String token
    );

    @GET("Aset.php?fx=getDaftarBarang") // Ini untuk methodnya
    Call<ResponseBody> getBarang(
            @Query("id_barang") String id_barang,
            @Query("id_ruangan") String id_ruangan,
            @Query("id_gedung") String id_gedung,
            @Query("token") String token
    );

    @GET("Aset.php?fx=getDetailBarang") // Ini untuk methodnya
    Call<ResponseBody> getDetailBarang(
            @Query("id_nama") String id_nama,
            @Query("id_barang") String id_barang,
            @Query("id_ruangan") String id_ruangan,
            @Query("id_gedung") String id_gedung,
            @Query("token") String token
    );

    @GET("Aset.php?fx=getInventarisLengkap") // Ini untuk methodnya
    Call<ResponseBody> getInventarisLengkap(
            @Query("kode_lokasi") String kode_lokasi,
            @Query("token") String token
    );

}

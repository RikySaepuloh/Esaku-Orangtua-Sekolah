package com.saku.sekolah.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    String APP_NAME="Sekolah";
    private String userLog="user_log";
    private String userStatus="user_status";
    private String namalokasi="nama_lokasi";
    private String kodePP="kode_pp";
    private String noHp="no_hp";
    private String userPwd="user_pwd";
    private String isLogedIn="is_loged_in";
    private String kodeLokasiKonsol="kode_lokasi_konsol";
    private String namaUser="nama_user";
    private String periode="periode";
    private String formLogin="form_login";
    private String loginTime="login_time";
    private String logo="logo";
    private String nikUser="nik_user";
    private String email="email";
    private String kodeMenu="kode_menu";
    private String token="token";
    private String exitUrl="exit_url";
    private String kodeFs="kode_fs";
    private String hakakses="hakakses";
    private String foto="foto";
    private String apiKey="api_key";
    private String lokasi="lokasi";
    private String namaPP="nama_pp";
    private String dash="dash";
    private String kodeBidang="kode_bidang";


    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public Preferences(Context context){
        sp = context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void preferencesLogout(){
        spEditor.clear();
        spEditor.commit();
    }

    public void saveUserStatus(String value){
        spEditor.putString(userStatus, value);
        spEditor.commit();
    }

    public void saveNoHp(String value){
        spEditor.putString(noHp, value);
        spEditor.commit();
    }
    public void saveUserPwd(String value){
        spEditor.putString(userPwd, value);
        spEditor.commit();
    }

    public void saveKodeLokasiKonsol(String value){
        spEditor.putString(kodeLokasiKonsol, value);
        spEditor.commit();
    }
    public void saveNamaUser(String value){
        spEditor.putString(namaUser, value);
        spEditor.commit();
    }
    public void savePeriode(String value){
        spEditor.putString(periode, value);
        spEditor.commit();
    }
    public void saveFormLogin(String value){
        spEditor.putString(formLogin, value);
        spEditor.commit();
    }
    public void saveLoginTime(String value){
        spEditor.putString(loginTime, value);
        spEditor.commit();
    }
    public void saveLogo(String value){
        spEditor.putString(logo, value);
        spEditor.commit();
    }
    public void saveNikUser(String value){
        spEditor.putString(nikUser, value);
        spEditor.commit();
    }
    public void saveEmail(String value){
        spEditor.putString(email, value);
        spEditor.commit();
    }
    public void saveKodeMenu(String value){
        spEditor.putString(kodeMenu, value);
        spEditor.commit();
    }
    public void saveToken(String value){
        spEditor.putString(token, value);
        spEditor.commit();
    }
    public void saveExitUrl(String value){
        spEditor.putString(exitUrl, value);
        spEditor.commit();
    }
    public void saveKodeFs(String value){
        spEditor.putString(kodeFs, value);
        spEditor.commit();
    }
    public void saveHakAkses(String value){
        spEditor.putString(hakakses, value);
        spEditor.commit();
    }
    public void saveFoto(String value){
        spEditor.putString(foto, value);
        spEditor.commit();
    }
    public void saveApiKey(String value){
        spEditor.putString(apiKey, value);
        spEditor.commit();
    }
    public void saveLokasi(String value){
        spEditor.putString(lokasi, value);
        spEditor.commit();
    }
    public void saveNamaPp(String value){
        spEditor.putString(namaPP, value);
        spEditor.commit();
    }

    public void saveDash(String value){
        spEditor.putString(dash, value);
        spEditor.commit();
    }
    public void saveKodeBidang(String value){
        spEditor.putString(kodeBidang, value);
        spEditor.commit();
    }

    public void saveUserLog(String value){
        spEditor.putString(userLog, value);
        spEditor.commit();
    }

    public void setUserStatus(String value){
        spEditor.putString(userStatus, value);
        spEditor.commit();
    }

    public void saveNamaLokasi(String value){
        spEditor.putString(namalokasi, value);
        spEditor.commit();
    }

    public void saveKodePp(String value){
        spEditor.putString(kodePP, value);
        spEditor.commit();
    }

    public void setLoggedStatus(Boolean value){
        spEditor.putBoolean(isLogedIn, value);
        spEditor.commit();
    }

    public String getUserLog() {
        return sp.getString(userLog, "");
    }
    public String getUserStatus() {
        return sp.getString(getUserStatus(), "");
    }
    public String getNamalokasi() {
        return sp.getString(namalokasi, "");
    };
    public String getKodePP() {
        return sp.getString(getKodePP(), "");
    }
    public String getNoHp() {
        return sp.getString(noHp, "");
    }
    public String getUserPwd() {
        return sp.getString(userPwd, "");
    }
    public String getKodeLokasiKonsol() {
        return sp.getString(kodeLokasiKonsol, "");
    }
    public String getNamaUser() {
        return sp.getString(namaUser, "");
    }
    public String getPeriode() {
        return sp.getString(periode, "");
    }
    public String getFormLogin() {
        return sp.getString(formLogin, "");
    }
    public String getLoginTime() {
        return sp.getString(loginTime, "");
    }
    public String getLogo() {
        return sp.getString(logo, "");
    }
    public String getNikUser() {
        return sp.getString(nikUser, "");
    }
    public String getEmail() {
        return sp.getString(email, "");
    }
    public String getKodeMenu() {
        return sp.getString(kodeMenu, "");
    }
    public String getToken() {
        return sp.getString(token, "");
    }
    public String getExitUrl() {
        return sp.getString(exitUrl, "");
    }
    public String getKodeFs() {
        return sp.getString(kodeFs, "");
    }
    public String getHakakses() {
        return sp.getString(hakakses, "");
    }
    public String getFoto() {
        return sp.getString(foto, "");
    }
    public String getApiKey() {
        return sp.getString(apiKey, "");
    }
    public String getLokasi() {
        return sp.getString(lokasi, "");
    }
    public String getNamaPP() {
        return sp.getString(namaPP, "");
    }
    public String getDash() {
        return sp.getString(dash, "");
    }
    public String getKodeBidang() {
        return sp.getString(kodeBidang, "");
    }
    public Boolean getIsLogedIn() {
        return sp.getBoolean(isLogedIn, false);
    }
}

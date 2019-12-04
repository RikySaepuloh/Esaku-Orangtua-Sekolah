package com.saku.sekolah.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    String APP_NAME="Sekolah";
    String kode_lokasi="kode_lokasi";
    String username="username";
    String periode="periode";
    String api_key="api_key";
    String kodePP="kodePP";
    String nama_user="nama_user";
    String nik_user="nik_user";
    String password="password";
    String namaPP="namaPP";
    //    boolean loggedIn=false;
    String loggedIn="loggedIn";
    String kode_jab="kode_jab";
    String kode_rumah="kode_rumah";
    String no_telp="no_telp";
    String jabatan="jabatan";
    String email="email";
    String foto="foto";
    String token="token";

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

    public void saveKodeRumah(String value){
        spEditor.putString(kode_rumah, value);
        spEditor.commit();
    }

    public void saveKodeLokasi(String value){
        spEditor.putString(kode_lokasi, value);
        spEditor.commit();
    }

    public void saveUsername(String value){
        spEditor.putString(username, value);
        spEditor.commit();
    }

    public void savePeriode(String value){
        spEditor.putString(periode, value);
        spEditor.commit();
    }

    public void saveApiKey(String value){
        spEditor.putString(api_key, value);
        spEditor.commit();
    }

    public void saveKodePP(String value){
        spEditor.putString(kodePP, value);
        spEditor.commit();
    }

    public void saveNamaPP(String value){
        spEditor.putString(namaPP, value);
        spEditor.commit();
    }

    public void saveNamaUser(String value){
        spEditor.putString(nama_user, value);
        spEditor.commit();
    }

    public void saveNikUser(String value){
        spEditor.putString(nik_user, value);
        spEditor.commit();
    }

    public void savePassword(String value){
        spEditor.putString(password, value);
        spEditor.commit();
    }

    public void setLoggedStatus(String value){
        spEditor.putString(loggedIn, value);
        spEditor.commit();
    }

    public void saveKodeJab(String value){
        spEditor.putString(kode_jab, value);
        spEditor.commit();
    }

    public void saveEmail(String value){
        spEditor.putString(email, value);
        spEditor.commit();
    }

    public void saveJabatan(String value){
        spEditor.putString(jabatan, value);
        spEditor.commit();
    }

    public void saveNoTelp(String value){
        spEditor.putString(no_telp, value);
        spEditor.commit();
    }


    public void saveFoto(String value){
        spEditor.putString(foto, value);
        spEditor.commit();
    }

    public void saveToken(String value){
        spEditor.putString(token, value);
        spEditor.commit();
    }

    public String getToken() {
        return sp.getString(token, "");
    }

    public String getFoto() {
        return sp.getString(foto, "");
    }

    public String getNo_telp() {
        return sp.getString(no_telp, "");
    }

    public String getJabatan() {
        return sp.getString(jabatan, "");
    }

    public String getEmail() {
        return sp.getString(email, "");
    }

    public String getKode_jab() {
        return sp.getString(kode_jab, "");
    }

    public String getKodeRumah() {
        return sp.getString(kode_rumah, "");
    }

    public String getLoggedStatus(){
        return sp.getString(loggedIn, "false");
    }

    public String getUsername() {
        return sp.getString(username, "");
    }

    public String getKodeLokasi() {
        return sp.getString(kode_lokasi, "");
    }

    public String getPeriode() {
        return sp.getString(periode, "");
    }

    public String getApiKey() {
        return sp.getString(api_key, "");
    }

    public String getNamaPP() {
        return sp.getString(namaPP, "");
    }

    public String getKodePP() {
        return sp.getString(kodePP, "");
    }

    public String getNamaUser() {
        return sp.getString(nama_user, "");
    }

    public String getNikUser() {
        return sp.getString(nik_user, "");
    }

    public String getPassword() {
        return sp.getString(password, "");
    }

}

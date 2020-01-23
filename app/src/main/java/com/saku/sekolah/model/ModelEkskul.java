package com.saku.sekolah.model;

public class ModelEkskul {
    private String nama_ekskul;

    public String getNama_ekskul() {
        return nama_ekskul;
    }

    public void setNama_ekskul(String nama_ekskul) {
        this.nama_ekskul = nama_ekskul;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getMasuk() {
        return masuk;
    }

    public void setMasuk(String masuk) {
        this.masuk = masuk;
    }

    public String getBerakhir() {
        return berakhir;
    }

    public void setBerakhir(String berakhir) {
        this.berakhir = berakhir;
    }

    private String nama_guru;
    private String masuk;

    public ModelEkskul(String nama_ekskul, String nama_guru, String masuk, String berakhir) {
        this.nama_ekskul = nama_ekskul;
        this.nama_guru = nama_guru;
        this.masuk = masuk;
        this.berakhir = berakhir;
    }

    private String berakhir;
}

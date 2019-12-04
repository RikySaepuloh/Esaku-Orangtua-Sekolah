package com.saku.sekolah.model;

public class ModelPesan {
   String tanggal,judul,isi;

    public ModelPesan(String tanggal, String judul, String isi) {
        this.tanggal = tanggal;
        this.judul = judul;
        this.isi = isi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}

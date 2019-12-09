package com.saku.sekolah.model.keuangan;

public class ModelRiwayat {
    String tanggal,kode,jenis,deskripsi,nilai;

    public ModelRiwayat(String tanggal, String kode, String jenis, String deskripsi, String nilai) {
        this.tanggal = tanggal;
        this.kode = kode;
        this.jenis = jenis;
        this.deskripsi = deskripsi;
        this.nilai = nilai;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
}

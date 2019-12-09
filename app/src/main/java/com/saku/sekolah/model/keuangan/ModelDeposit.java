package com.saku.sekolah.model.keuangan;

public class ModelDeposit {
    String jenis,tanggal,kode,nilai;

    public ModelDeposit(String jenis, String tanggal, String kode, String nilai) {
        this.jenis = jenis;
        this.tanggal = tanggal;
        this.kode = kode;
        this.nilai = nilai;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
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

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
}

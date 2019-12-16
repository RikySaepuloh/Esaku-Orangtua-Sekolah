package com.saku.sekolah.model.beranda.prestasi;

public class ModelPrestasi {
    String tanggal,keterangan,tempat,jenis;

    public ModelPrestasi(String tanggal, String keterangan, String tempat, String jenis) {
        this.tanggal = tanggal;
        this.keterangan = keterangan;
        this.tempat = tempat;
        this.jenis = jenis;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}

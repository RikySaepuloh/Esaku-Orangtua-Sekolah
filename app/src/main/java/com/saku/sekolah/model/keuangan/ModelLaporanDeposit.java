package com.saku.sekolah.model.keuangan;

public class ModelLaporanDeposit {
    String tanggal,kode,transaksi,nilai,deskripsi,jenis;

    public ModelLaporanDeposit(String tanggal, String kode,String jenis, String transaksi, String nilai, String deskripsi) {
        this.jenis=jenis;
        this.tanggal = tanggal;
        this.kode = kode;
        this.transaksi = transaksi;
        this.nilai = nilai;
        this.deskripsi = deskripsi;
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

    public String getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(String transaksi) {
        this.transaksi = transaksi;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

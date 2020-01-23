package com.saku.sekolah.model;

public class ModalNotifikasi {
    private String tgl_notifikasi;
    private String judul_notifikasi;
    private String isi_notifikasi;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTgl_notifikasi() {
        return tgl_notifikasi;
    }

    public void setTgl_notifikasi(String tgl_notifikasi) {
        this.tgl_notifikasi = tgl_notifikasi;
    }

    public String getJudul_notifikasi() {
        return judul_notifikasi;
    }

    public void setJudul_notifikasi(String judul_notifikasi) {
        this.judul_notifikasi = judul_notifikasi;
    }

    public String getIsi_notifikasi() {
        return isi_notifikasi;
    }

    public void setIsi_notifikasi(String isi_notifikasi) {
        this.isi_notifikasi = isi_notifikasi;
    }

    public ModalNotifikasi(String tgl_notifikasi, String judul_notifikasi, String isi_notifikasi,String status) {
        this.tgl_notifikasi = tgl_notifikasi;
        this.judul_notifikasi = judul_notifikasi;
        this.isi_notifikasi = isi_notifikasi;
        this.status = status;
    }
}

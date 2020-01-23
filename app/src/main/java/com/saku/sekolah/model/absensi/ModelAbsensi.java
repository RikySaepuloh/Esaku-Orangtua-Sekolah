package com.saku.sekolah.model.absensi;

public class ModelAbsensi {
    private String status,tgl,jam;

    public ModelAbsensi(String status, String tgl, String jam) {
        this.status = status;
        this.tgl = tgl;
        this.jam = jam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}

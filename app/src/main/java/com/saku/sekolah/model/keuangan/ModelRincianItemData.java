package com.saku.sekolah.model.keuangan;

public class ModelRincianItemData {
    String kode_param,saldo;

    public ModelRincianItemData(String kode_param, String saldo) {
        this.kode_param = kode_param;
        this.saldo = saldo;
    }

    public String getKode_param() {
        return kode_param;
    }

    public void setKode_param(String kode_param) {
        this.kode_param = kode_param;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}

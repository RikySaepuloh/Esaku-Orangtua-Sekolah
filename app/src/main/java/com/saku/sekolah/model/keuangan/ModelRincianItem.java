package com.saku.sekolah.model.keuangan;

import java.util.ArrayList;
import java.util.List;

public class ModelRincianItem {
    String tanggal,kode,total_param;
    ArrayList<ModelRincianItemData> itemData;

    public ModelRincianItem(String tanggal, String kode, String total_param, ArrayList<ModelRincianItemData> itemData
    ) {
        this.tanggal = tanggal;
        this.kode = kode;
        this.total_param = total_param;
        this.itemData = itemData;
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

    public String getTotal_param() {
        return total_param;
    }

    public void setTotal_param(String total_param) {
        this.total_param = total_param;
    }

    public ArrayList<ModelRincianItemData> getItemData() {
        return itemData;
    }

    public void setItemData(ArrayList<ModelRincianItemData> itemData) {
        this.itemData = itemData;
    }
}

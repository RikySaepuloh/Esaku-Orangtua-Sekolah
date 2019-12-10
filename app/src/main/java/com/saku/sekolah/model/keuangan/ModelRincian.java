package com.saku.sekolah.model.keuangan;

import java.util.ArrayList;
import java.util.List;

public class ModelRincian {
    String periode;
    ArrayList<ModelRincianItem> rincianItems;

    public ModelRincian(String periode, ArrayList<ModelRincianItem> rincianItems) {
        this.periode = periode;
        this.rincianItems = rincianItems;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public ArrayList<ModelRincianItem> getRincianItems() {
        return rincianItems;
    }

    public void setRincianItems(ArrayList<ModelRincianItem> rincianItems) {
        this.rincianItems = rincianItems;
    }
}

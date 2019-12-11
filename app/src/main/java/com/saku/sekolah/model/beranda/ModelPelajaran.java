package com.saku.sekolah.model.beranda;

public class ModelPelajaran {
    String mapel,guru,kehadiran,masuk,berakhir;

    public ModelPelajaran(String mapel, String guru, String kehadiran, String masuk, String berakhir) {
        this.mapel = mapel;
        this.guru = guru;
        this.kehadiran = kehadiran;
        this.masuk = masuk;
        this.berakhir = berakhir;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getGuru() {
        return guru;
    }

    public void setGuru(String guru) {
        this.guru = guru;
    }

    public String getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(String kehadiran) {
        this.kehadiran = kehadiran;
    }

    public String getMasuk() {
        return masuk;
    }

    public void setMasuk(String masuk) {
        this.masuk = masuk;
    }

    public String getBerakhir() {
        return berakhir;
    }

    public void setBerakhir(String berakhir) {
        this.berakhir = berakhir;
    }
}

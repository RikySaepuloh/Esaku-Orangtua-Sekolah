package com.saku.sekolah;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AbsensiActivity extends Activity {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.absensi_hadir)
    TextView absensiHadir;
    @BindView(R.id.absensi_sakit)
    TextView absensiSakit;
    @BindView(R.id.absensi_izin)
    TextView absensiIzin;
    @BindView(R.id.absensi_alpa)
    TextView absensiAlpa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);
        ButterKnife.bind(this);

    }
}

package com.saku.sekolah;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.adapter.AbsensiAdapter;
import com.saku.sekolah.model.absensi.ModelAbsensi;

import java.util.ArrayList;

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
    @BindView(R.id.absensi_recyclerview)
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager lManager;
    private ArrayList<ModelAbsensi> mList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);
        ButterKnife.bind(this);
        makeList();
        kembali();
        recyclerView.setHasFixedSize(true);
        mAdapter = new AbsensiAdapter(mList);
        lManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(lManager);
    }


    void makeList(){
        mList = new ArrayList<>();
        mList.add(new ModelAbsensi("Hadir","02/12/2019","06:26"));
        mList.add(new ModelAbsensi("Ijin","02/12/2019","---"));
        mList.add(new ModelAbsensi("Sakit","02/12/2019","---"));
        mList.add(new ModelAbsensi("Alpha","02/12/2019","---"));
        mList.add(new ModelAbsensi("Hadir","02/12/2019","06:26"));
        mList.add(new ModelAbsensi("Hadir","02/12/2019","06:26"));
        mList.add(new ModelAbsensi("Hadir","02/12/2019","06:26"));

    }
    void kembali(){
       tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}

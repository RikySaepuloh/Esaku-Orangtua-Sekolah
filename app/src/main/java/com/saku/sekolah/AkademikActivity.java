package com.saku.sekolah;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.saku.sekolah.adapter.AkademikAdapter;
import com.saku.sekolah.model.ModalAkademik;

import java.util.ArrayList;

import butterknife.BindView;

public class AkademikActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ModalAkademik> mList;
    private TextView txt_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akademik);
        Kembali();
        AddList();
            recyclerView = findViewById(R.id.akademik_recyclerview);
        recyclerView.setHasFixedSize(true);
        mAdapter = new AkademikAdapter(mList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    void AddList(){
        mList = new ArrayList<>();
        mList.add(new ModalAkademik("12/11/2019","12/12/2019","Jadwal Akadeik"));
        mList.add(new ModalAkademik("12/11/2019","12/12/2019","Jadwal Akadeik"));
        mList.add(new ModalAkademik("12/11/2019","12/12/2019","Jadwal Akadeik"));
        mList.add(new ModalAkademik("12/11/2019","12/12/2019","Jadwal Akadeik"));
        mList.add(new ModalAkademik("12/11/2019","12/12/2019","Jadwal Akadeik"));
        mList.add(new ModalAkademik("12/11/2019","12/12/2019","Jadwal Akadeik"));
        mList.add(new ModalAkademik("12/11/2019","12/12/2019","Jadwal Akadeik"));
        mList.add(new ModalAkademik("12/11/2019","12/12/2019","Jadwal Akadeik"));
        mList.add(new ModalAkademik("12/11/2019","12/12/2019","Jadwal Akadeik"));
    }
    void Kembali(){
        txt_back= findViewById(R.id.tom_back);
        txt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}

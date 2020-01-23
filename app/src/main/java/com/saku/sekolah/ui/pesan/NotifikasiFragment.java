package com.saku.sekolah.ui.pesan;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saku.sekolah.LihatNotifikasiActivity;
import com.saku.sekolah.R;
import com.saku.sekolah.adapter.NotifikasiAdapter;
import com.saku.sekolah.model.ModalNotifikasi;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotifikasiFragment extends Fragment {


    public NotifikasiFragment() {
        // Required empty public constructor
    }

    private ArrayList<ModalNotifikasi> mNotifList;
    private RecyclerView mRecycleView;
    private NotifikasiAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notifikasi, container, false);
        CreateList();
        mRecycleView = view.findViewById(R.id.RV_notifikasi);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this.getContext());
        mAdapter = new NotifikasiAdapter(mNotifList);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new NotifikasiAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent i = new Intent(getContext(), LihatNotifikasiActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
    void CreateList(){
        mNotifList = new ArrayList<>();
        mNotifList.add(new ModalNotifikasi("20 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi","Belum Dibaca"));
        mNotifList.add(new ModalNotifikasi("20 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi dari pengirim notifikasi","Belum Dibaca"));
        mNotifList.add(new ModalNotifikasi("19 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi dari pengirim notifikasi","Dibaca"));
        mNotifList.add(new ModalNotifikasi("19 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi dari pengirim notifikasi","Dibaca"));
        mNotifList.add(new ModalNotifikasi("19 November 2019","Judul Notifikasi","Deskripsi isi dari notifikasi yang akan disampaikan kepada penerima notifikasi dari pengirim notifikasi","Dibaca"));

    }

}

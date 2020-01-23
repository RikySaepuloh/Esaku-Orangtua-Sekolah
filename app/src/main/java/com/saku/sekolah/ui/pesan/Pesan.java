package com.saku.sekolah.ui.pesan;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saku.sekolah.R;
import com.saku.sekolah.adapter.PesanAdapter;
import com.saku.sekolah.model.ModelPesan;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pesan extends Fragment {


    public Pesan() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    ArrayList<ModelPesan> pesanArrayList = new ArrayList<>();
    PesanAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pesan2, container, false);
        pesanArrayList.add(new ModelPesan("01 Januari 2019","Ini judul","Ini Isi"));
        pesanArrayList.add(new ModelPesan("same","Ini judul","Ini Isi"));
        adapter = new PesanAdapter(pesanArrayList);
        recyclerView = v.findViewById(R.id.pesan_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return v;
    }

}

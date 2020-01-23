package com.saku.sekolah.ui.beranda;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.saku.sekolah.R;
import com.saku.sekolah.adapter.EkskulAdapter;
import com.saku.sekolah.model.ModelEkskul;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EkskulFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLinear;
    private ArrayList<ModelEkskul> mList;

    public EkskulFragment(String hari) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ekskul, container, false);
        Context context = getContext();
        Create();
        recyclerView = v.findViewById(R.id.ekskul_recyclerview);
        recyclerView.setHasFixedSize(true);
        mAdapter = new EkskulAdapter(mList);
        mLinear = new LinearLayoutManager(context);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(mLinear);
        return v;
    }

    void Create(){
        mList = new ArrayList<>();
        mList.add(new ModelEkskul("Basket","Ibu Guru Cute.Spd","06:30","09:30"));
        mList.add(new ModelEkskul("Basket","Ibu Guru Cute.Spd","06:30","09:30"));
        mList.add(new ModelEkskul("Basket","Ibu Guru Cute.Spd","06:30","09:30"));
        mList.add(new ModelEkskul("Basket","Ibu Guru Cute.Spd","06:30","09:30"));
        mList.add(new ModelEkskul("Basket","Ibu Guru Cute.Spd","06:30","09:30"));
    }

}

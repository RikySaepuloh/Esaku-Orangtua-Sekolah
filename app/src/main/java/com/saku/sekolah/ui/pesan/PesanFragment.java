package com.saku.sekolah.ui.pesan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.saku.sekolah.R;
import com.saku.sekolah.adapter.PesanAdapter;
import com.saku.sekolah.model.ModelPesan;

import java.util.ArrayList;

import butterknife.BindView;

public class PesanFragment extends Fragment {

    TabLayout pesanTab;
    int position;
    View firstTab,secondTab;
    RecyclerView recyclerView;
    ArrayList<ModelPesan> pesanArrayList = new ArrayList<>();
    PesanAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesan, container, false);
        pesanTab=view.findViewById(R.id.pesan_tab);
        recyclerView = view.findViewById(R.id.pesan_recyclerview);
        firstTab = ((ViewGroup) pesanTab.getChildAt(0)).getChildAt(0);
        secondTab = ((ViewGroup) pesanTab.getChildAt(0)).getChildAt(1);
        recyclerView = view.findViewById(R.id.pesan_recyclerview);
        firstTab.setBackgroundResource(R.drawable.tab_rounded_left_active);
        secondTab.setBackgroundResource(R.drawable.tab_rounded_right);
        pesanArrayList.add(new ModelPesan("01 Januari 2019","Ini judul","Ini Isi"));
        pesanArrayList.add(new ModelPesan("same","Ini judul","Ini Isi"));
        adapter = new PesanAdapter(pesanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        pesanTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position=pesanTab.getSelectedTabPosition();

                switch (position){
                    case 0:
                        firstTab.setBackgroundResource(R.drawable.tab_rounded_left_active);
                        secondTab.setBackgroundResource(R.drawable.tab_rounded_right);
                        break;
                    case 1:
                        firstTab.setBackgroundResource(R.drawable.tab_rounded_left);
                        secondTab.setBackgroundResource(R.drawable.tab_rounded_right_active);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }
}
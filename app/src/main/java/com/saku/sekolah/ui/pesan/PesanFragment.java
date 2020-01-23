package com.saku.sekolah.ui.pesan;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.saku.sekolah.R;
import com.saku.sekolah.adapter.PesanAdapter;
import com.saku.sekolah.model.ModelPesan;
import com.saku.sekolah.model.keuangan.Keuangan;
import com.saku.sekolah.ui.beranda.BerandaFragment;
import com.saku.sekolah.ui.keuangan.DepositFragment;
import com.saku.sekolah.ui.keuangan.KeuanganFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class PesanFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<ModelPesan> pesanArrayList = new ArrayList<>();
    PesanAdapter adapter;
    private Button btn1;
    private Button btn2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesan, container, false);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frgm, new Pesan());
        ft.commit();
        btn1 =  view.findViewById(R.id.btn1);
        btn2= view.findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setTextColor(Color.parseColor("#5485e4"));
                btn1.setBackgroundResource(R.drawable.rounded_background_white);
                btn2.setBackgroundColor(Color.TRANSPARENT);
                btn2.setTextColor(Color.parseColor("#898989"));
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frgm, new Pesan());
                ft.commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setTextColor(Color.parseColor("#5485e4"));
                btn2.setBackgroundResource(R.drawable.rounded_background_white);
                btn1.setBackgroundColor(Color.TRANSPARENT);
                btn1.setTextColor(Color.parseColor("#898989"));
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frgm, new NotifikasiFragment());
                ft.commit();
            }
        });

        return view;
    }
}
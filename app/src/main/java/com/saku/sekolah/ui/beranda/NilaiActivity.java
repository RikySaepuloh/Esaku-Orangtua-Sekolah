package com.saku.sekolah.ui.beranda;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.saku.sekolah.R;
import com.saku.sekolah.adapter.DepositAdapter;
import com.saku.sekolah.adapter.SectionPagerAdapter;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.model.keuangan.ModelDeposit;
import com.saku.sekolah.preferences.Preferences;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NilaiActivity extends AppCompatActivity {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.pager)
    ViewPager pager;
    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;
    private ArrayList<ModelDeposit> depositArrayList = new ArrayList<>();
    private DepositAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);
        ButterKnife.bind(this);
        context = this;
        setUpViewPager(pager);
        tablayout.setupWithViewPager(pager);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setUpViewPager(ViewPager myViewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new NilaiFragment("UTS"), "Senin");
        adapter.addFragment(new NilaiFragment("UAS"), "Selasa");

        myViewPager.setAdapter(adapter);
    }
}

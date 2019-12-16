package com.saku.sekolah.ui.beranda;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.saku.sekolah.R;
import com.saku.sekolah.adapter.SectionPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EkskulActivity extends AppCompatActivity {
    Context context;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekskul);
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

        adapter.addFragment(new HariFragment("Senin"), "Senin");
        adapter.addFragment(new HariFragment("Selasa"), "Selasa");
        adapter.addFragment(new HariFragment("Rabu"), "Rabu");
        adapter.addFragment(new HariFragment("Kamis"), "Kamis");
        adapter.addFragment(new HariFragment("Jum'at"), "Jum'at");
        adapter.addFragment(new HariFragment("Sabtu"), "Sabtu");
//        adapter.addFragment(new HariFragment("Minggu"), "Minggu");

        myViewPager.setAdapter(adapter);
    }
}

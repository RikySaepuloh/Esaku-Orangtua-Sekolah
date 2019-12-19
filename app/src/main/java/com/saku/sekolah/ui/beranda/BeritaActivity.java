package com.saku.sekolah.ui.beranda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.saku.sekolah.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeritaActivity extends Activity {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.berita1)
    CardView berita1;
    @BindView(R.id.berita2)
    CardView berita2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        ButterKnife.bind(this);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        berita1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeritaActivity.this, DetailBeritaActivity.class);
                intent.putExtra("id","1");
                startActivity(intent);
            }
        });

        berita2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeritaActivity.this, DetailBeritaActivity.class);
                intent.putExtra("id","2");
                startActivity(intent);
            }
        });
    }
}

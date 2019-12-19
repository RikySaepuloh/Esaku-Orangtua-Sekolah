package com.saku.sekolah.ui.beranda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.saku.sekolah.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBeritaActivity extends Activity {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.gambar_berita)
    ImageView gambarBerita;
    @BindView(R.id.judul_berita)
    TextView judulBerita;
    @BindView(R.id.isi_berita)
    TextView isiBerita;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailberita);
        ButterKnife.bind(this);

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().getString("id").equals("1")) {
                gambarBerita.setImageResource(R.drawable.img_upacara);
                judulBerita.setText(R.string.dies_natalis);
                isiBerita.setText(R.string.text_berita);
            }else{
                gambarBerita.setImageResource(R.drawable.apel_pagi);
                judulBerita.setText(R.string.apel_pagi);
                isiBerita.setText(R.string.text_berita2);
            }
        }
    }
}

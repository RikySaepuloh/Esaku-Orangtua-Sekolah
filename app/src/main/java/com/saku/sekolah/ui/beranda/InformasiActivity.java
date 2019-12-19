package com.saku.sekolah.ui.beranda;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.saku.sekolah.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InformasiActivity extends Activity {
    @BindView(R.id.tv_back)
    TextView tvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);
        ButterKnife.bind(this);

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

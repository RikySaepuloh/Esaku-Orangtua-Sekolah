package com.saku.sekolah.ui.pengguna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.saku.sekolah.LoginActivity;
import com.saku.sekolah.R;
import com.saku.sekolah.preferences.Preferences;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PenggunaFragment extends Fragment {

    Preferences sp;
    Context context;
    @BindView(R.id.tv_pengguna_orangtua)
    TextView tvPenggunaOrangtua;
    @BindView(R.id.tv_pengguna_email)
    TextView tvPenggunaEmail;
    @BindView(R.id.tv_pengguna_notelp)
    TextView tvPenggunaNotelp;
    @BindView(R.id.tv_keluar)
    TextView tvKeluar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pengguna, container, false);
        ButterKnife.bind(this,view);
        context = getContext();
        sp = new Preferences(context);
        tvPenggunaOrangtua.setText(sp.getUserLog());
        tvPenggunaEmail.setText(sp.getEmail());
        tvPenggunaNotelp.setText(sp.getNoHp());
        tvKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.preferencesLogout();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
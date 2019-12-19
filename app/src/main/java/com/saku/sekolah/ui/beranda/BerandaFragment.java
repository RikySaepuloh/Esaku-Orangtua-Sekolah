package com.saku.sekolah.ui.beranda;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.saku.sekolah.AbsensiActivity;
import com.saku.sekolah.R;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.preferences.LoadImage;
import com.saku.sekolah.preferences.Preferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class BerandaFragment extends Fragment {
    @BindView(R.id.iv_profile)
    CircleImageView ivProfile;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.iv_alarm)
    TextView ivAlarm;
    @BindView(R.id.menu_absensi)
    LinearLayout menuAbsensi;
    @BindView(R.id.menu_pelajaran)
    LinearLayout menuPelajaran;
    @BindView(R.id.menu_akademik)
    LinearLayout menuAkademik;
    @BindView(R.id.menu_nilai)
    LinearLayout menuNilai;
    @BindView(R.id.menu_raport)
    LinearLayout menuRaport;
    @BindView(R.id.menu_prestasi)
    LinearLayout menuPrestasi;
    @BindView(R.id.menu_ekstrakurikuler)
    LinearLayout menuEkstrakurikuler;
    @BindView(R.id.menu_lainnya)
    LinearLayout menuLainnya;
    @BindView(R.id.tv_beranda_lihatsemua)
    TextView tvBerandaLihatsemua;
    @BindView(R.id.tv_beranda_judulberita)
    TextView tvBerandaJudulberita;
    @BindView(R.id.berita)
    CardView berita;
    @BindView(R.id.btn_informasi)
    Button btnInformasi;
    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;

    LoadImage loadImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        ButterKnife.bind(this, view);
        context = getContext();
        sp = new Preferences(context);
        mApiService = UtilsApi.getAPIService(context);
        loadImage = new LoadImage(ivProfile, sp.getFoto());
        tvUsername.setText(sp.getNamaUser());

        btnInformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), InformasiActivity.class);
                startActivity(intent);
            }
        });

        tvBerandaLihatsemua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BeritaActivity.class);
                startActivity(intent);
            }
        });

        berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DetailBeritaActivity.class);
                intent.putExtra("id", "1");
                startActivity(intent);
            }
        });

        menuPrestasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PrestasiActivity.class);
                startActivity(intent);
            }
        });
        menuEkstrakurikuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EkskulActivity.class);
                startActivity(intent);
            }
        });
        menuRaport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RaportActivity.class);
                startActivity(intent);
            }
        });
        menuNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NilaiActivity.class);
                startActivity(intent);
            }
        });
        menuAbsensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AbsensiActivity.class);
                startActivity(intent);
            }
        });
        menuPelajaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PelajaranActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
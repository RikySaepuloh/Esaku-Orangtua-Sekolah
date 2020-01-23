package com.saku.sekolah.ui.pengguna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.saku.sekolah.LoginActivity;
import com.saku.sekolah.R;
import com.saku.sekolah.adapter.CostumeAdapter;
import com.saku.sekolah.preferences.LoadImage;
import com.saku.sekolah.preferences.Preferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class PenggunaFragment extends Fragment {

    Preferences sp;
    Context context;
    String[] orangtua;
    String[] email;
    String[] nohp;
    String[] gambar;
    CostumeAdapter adapter;
    @BindView(R.id.tv_pengguna_orangtua)
    TextView tvPenggunaOrangtua;
    @BindView(R.id.tv_pengguna_email)
    TextView tvPenggunaEmail;
    @BindView(R.id.tv_pengguna_notelp)
    TextView tvPenggunaNotelp;
    @BindView(R.id.tv_keluar)
    TextView tvKeluar;
    LoadImage loadImage;
    @BindView(R.id.iv_profile)
    CircleImageView ivProfile;
    @BindView(R.id.tv_pengguna_siswa)
    TextView tvPenggunaSiswa;
    @BindView(R.id.spins)
    Spinner spins;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pengguna, container, false);
        ButterKnife.bind(this, view);
        context = getContext();
        sp = new Preferences(context);
        loadImage = new LoadImage(ivProfile, sp.getFoto());
        tvPenggunaSiswa.setText(sp.getNamaUser());
        tvPenggunaOrangtua.setText(sp.getUserLog());
        tvPenggunaEmail.setText(sp.getEmail());
        tvPenggunaNotelp.setText(sp.getNoHp());
        Createlist();
        adapter = new CostumeAdapter(getContext(),orangtua,gambar,email,nohp);
        spins.setAdapter(adapter);
        spins.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(email[i] == "Tambah Akun"){
                    Intent in = new Intent(getContext(),LoginActivity.class);
                    in.putExtra("action","action");
                    startActivity(in);
                }else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

    void Createlist(){
        orangtua = new String[]{sp.getNamaUser(),""};
        nohp = new String[]{"08132000000",""};
        email = new String[]{"asd@mail.com","Tambah Akun"};
        gambar = new String[]{sp.getFoto(),sp.getFoto()};
    }
}
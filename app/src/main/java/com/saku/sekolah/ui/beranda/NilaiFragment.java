package com.saku.sekolah.ui.beranda;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.saku.sekolah.R;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.preferences.Preferences;

import butterknife.ButterKnife;

public class NilaiFragment extends Fragment {
    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;
    String jenis;

    public NilaiFragment(String jenis) {
        this.jenis= jenis;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nilai, container, false);
        ButterKnife.bind(this, view);
        context = getContext();
        sp = new Preferences(context);
        mApiService = UtilsApi.getAPIService(context);
        return view;
    }
}

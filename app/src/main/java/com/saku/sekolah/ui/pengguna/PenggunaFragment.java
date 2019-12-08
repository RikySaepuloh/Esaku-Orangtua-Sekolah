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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.saku.sekolah.LoginActivity;
import com.saku.sekolah.MainActivity;
import com.saku.sekolah.R;
import com.saku.sekolah.model.login.Login;
import com.saku.sekolah.preferences.Preferences;

public class PenggunaFragment extends Fragment {

    TextView tv_exit;
    Preferences sp;
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pengguna, container, false);
        context=getContext();
        sp=new Preferences(context);
        tv_exit=view.findViewById(R.id.tv_keluar);
        tv_exit.setOnClickListener(new View.OnClickListener() {
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
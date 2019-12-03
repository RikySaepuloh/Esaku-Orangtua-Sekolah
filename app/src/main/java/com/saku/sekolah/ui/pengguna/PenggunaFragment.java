package com.saku.sekolah.ui.pengguna;

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

import com.saku.sekolah.R;

public class PenggunaFragment extends Fragment {

    private PenggunaViewModel penggunaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        penggunaViewModel =
                ViewModelProviders.of(this).get(PenggunaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pengguna, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        penggunaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
package com.saku.sekolah.ui.keuangan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.saku.sekolah.R;

import butterknife.BindView;

public class KeuanganFragment extends Fragment {

    TextView keuTagihan;
    String textTagihan,keuTag;
    LinearLayout menuBayar,menuRincian,menuRiwayat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keuangan, container, false);
        keuTagihan = view.findViewById(R.id.keu_tagihan);
        menuBayar = view.findViewById(R.id.menu_bayar);
        menuRincian = view.findViewById(R.id.menu_rincian);
        menuRincian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RincianFragment newFragment = new RincianFragment();

                FragmentTransaction transaction = null;
                if (getFragmentManager() != null) {
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment, newFragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                }
            }
        });
        menuBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment someFragment = new MetodePembayaranFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.id.nav_host_fragment, someFragment ); // give your fragment container id in first parameter
//                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
//                transaction.commit();
//
//                Fragment fragment = new MetodePembayaranFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.nav_host_fragment, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//                // Replace whatever is in the fragment_container view with this fragment,
//                // and add the transaction to the back stack so the user can navigate back
//                transaction.replace(R.id.fragment_container, newFragment);
//                transaction.addToBackStack(null);
//
//                // Commit the transaction
//                transaction.commit();

                // Create fragment and give it an argument specifying the article it should show
                MetodePembayaranFragment newFragment = new MetodePembayaranFragment();

                FragmentTransaction transaction = null;
                if (getFragmentManager() != null) {
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment, newFragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                }

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back

//                getFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.nav_host_fragment, new MetodePembayaranFragment())
//                        .commit();


            }
        });
        return view;
    }
}
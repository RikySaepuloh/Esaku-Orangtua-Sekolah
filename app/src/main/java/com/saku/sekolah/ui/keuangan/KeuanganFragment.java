package com.saku.sekolah.ui.keuangan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.saku.sekolah.R;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.keuangan.Keuangan;
import com.saku.sekolah.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KeuanganFragment extends Fragment {
    @BindView(R.id.keu_tag)
    TextView keuTag;
    @BindView(R.id.keu_tagihan)
    TextView keuTagihan;
    @BindView(R.id.menu_bayar)
    LinearLayout menuBayar;
    @BindView(R.id.menu_rincian)
    LinearLayout menuRincian;
    @BindView(R.id.menu_riwayat)
    LinearLayout menuRiwayat;
    @BindView(R.id.menu_piutang)
    LinearLayout menuPiutang;
    @BindView(R.id.menu_deposit)
    LinearLayout menuDeposit;
    @BindView(R.id.keu_spinner)
    Spinner keuSpinner;

    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;

    List<String> listAkun = new ArrayList<>();

//    TextView keuTagihan;
//    String textTagihan, keuTag;
//    LinearLayout menuBayar, menuRincian, menuRiwayat,menuPiutang,menuDeposit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_keuangan, container, false);
        ButterKnife.bind(this, view);
        mApiService = UtilsApi.getAPIService();
        context = getContext();
        sp = new Preferences(context);
        initDeposit(sp.getToken(), sp.getUserLog(), sp.getKodePP(), sp.getLokasi(), sp.getPeriode());

        initSpinner();

        initMenu();
//        keuSpinner


        return view;
    }

    private void initDeposit(String token, String nik, String kode_pp, String lokasi, String periode) {
        mApiService.getSaldoPiutang(token, nik, kode_pp, lokasi, periode)
                .enqueue(new Callback<Keuangan>() {
                    @Override
                    public void onResponse(Call<Keuangan> call, Response<Keuangan> response) {
                        if (response.isSuccessful()) {
                            if (response.body().isStatus()) {
                                keuTagihan.setText("Rp. " + response.body().getSaldo());
                            }
                        } else {
                            Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Keuangan> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initMenu(){
        menuRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RiwayatFragment newFragment = new RiwayatFragment();

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
        menuPiutang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PiutangFragment newFragment = new PiutangFragment();

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
        menuDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DepositFragment newFragment = new DepositFragment();

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
                MetodePembayaranFragment newFragment = new MetodePembayaranFragment();
                FragmentTransaction transaction = null;
                if (getFragmentManager() != null) {
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

    private void initSpinner(){
        listAkun.add(sp.getNamaUser());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, listAkun);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        keuSpinner.setAdapter(adapter);
        keuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextSize(10);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
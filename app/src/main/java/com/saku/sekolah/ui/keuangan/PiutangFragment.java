package com.saku.sekolah.ui.keuangan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.keuangan.DaftarItem;
import com.saku.sekolah.model.keuangan.Piutang;
import com.saku.sekolah.preferences.Preferences;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PiutangFragment extends Fragment {

    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tv_piutang_nama)
    TextView tvPiutangNama;
    @BindView(R.id.tv_piutang_nis)
    TextView tvPiutangNis;
    @BindView(R.id.tv_piutang_bank)
    TextView tvPiutangBank;
    @BindView(R.id.tv_piutang_saldo)
    TextView tvPiutangSaldo;
    @BindView(R.id.piutang_recyclerview)
    RecyclerView piutangRecyclerview;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.tv_piutang_sekolah)
    TextView tvPiutangSekolah;

    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_piutang, container, false);
        ButterKnife.bind(this, view);
        mApiService = UtilsApi.getAPIService();
        context = getContext();
        sp = new Preferences(context);
        initPiutang(sp.getToken(), sp.getUserLog(), sp.getKodePP(), sp.getLokasi());
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
            }
        });
        return view;
    }

    private void initPiutang(String token, String nik, String kode_pp, String lokasi) {
        progressBar.setVisibility(View.VISIBLE);
        mApiService.getPiutang(token, nik, kode_pp, lokasi)
                .enqueue(new Callback<Piutang>() {
                    @Override
                    public void onResponse(Call<Piutang> call, Response<Piutang> response) {
                        if (response.isSuccessful()) {
                            if (response.body().isStatus()) {
                                List<DaftarItem> dataSiswa = response.body().getDaftar();
                                if (dataSiswa.size() > 0) {
                                    for (int i = 0; i < dataSiswa.size(); i++) { //3 = Limit data
                                        tvPiutangSekolah.setText(dataSiswa.get(i).getNamaPp());
                                        tvPiutangNis.setText(": " + dataSiswa.get(i).getNis());
                                        tvPiutangNama.setText(": " + dataSiswa.get(i).getNama());
                                        tvPiutangBank.setText(": " + dataSiswa.get(i).getIdBank());
                                        tvPiutangSaldo.setText(": Rp. " + response.body().getSoAkhir());
                                    }
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        } else {
                            Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Piutang> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }


}
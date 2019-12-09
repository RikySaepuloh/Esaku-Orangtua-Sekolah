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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.adapter.LaporanDepositAdapter;
import com.saku.sekolah.adapter.PiutangAdapter;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.keuangan.ModelLaporanDeposit;
import com.saku.sekolah.model.keuangan.ModelPiutang;
import com.saku.sekolah.model.keuangan.ModelRiwayat;
import com.saku.sekolah.model.keuangan.Piutang;
import com.saku.sekolah.model.keuangan.Piutang2Item;
import com.saku.sekolah.model.keuangan.PiutangItem;
import com.saku.sekolah.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatFragment extends Fragment {

    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.rincian_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;
    private ArrayList<ModelRiwayat> riwayatArrayList = new ArrayList<>();
    private LaporanDepositAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_riwayat, container, false);
        ButterKnife.bind(this, view);
        mApiService = UtilsApi.getAPIService();
        context = getContext();
        sp = new Preferences(context);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
            }
        });
        return view;
    }

//    private void initRiwayat(String token, String nik, String kode_pp, String lokasi) {
//        progressBar.setVisibility(View.VISIBLE);
//        riwayatArrayList.clear();
//        mApiService.getRiwayat(token, nik, kode_pp, lokasi)
//                .enqueue(new Callback<Riwayat>() {
//                    @Override
//                    public void onResponse(Call<Riwayat> call, Response<Riwayat> response) {
//                        if (response.isSuccessful()) {
//                            if (response.body().isStatus()) {
//                                List<RiwayatItem> dataSiswa = response.body().getDaftar();
//                                if (dataSiswa.size() > 0) {
//                                    for (int i = 0; i < dataSiswa.size(); i++) { //3 = Limit data
//                                        tvPiutangSekolah.setText(dataSiswa.get(i).getNamaPp());
//                                        tvPiutangNis.setText(": " + dataSiswa.get(i).getNis());
//                                        tvPiutangNama.setText(": " + dataSiswa.get(i).getNama());
//                                        tvPiutangBank.setText(": " + dataSiswa.get(i).getIdBank());
//                                        tvPiutangSaldo.setText(": Rp. " + response.body().getSoAkhir());
//                                    }
//                                }
//                                List<Piutang2Item> dataTransaksi = response.body().getDaftar2();
//                                if (dataTransaksi.size() > 0) {
//                                    for (int i = 0; i < dataTransaksi.size(); i++) { //3 = Limit data
//                                        riwayatArrayList.add(new ModelRiwayat(
//                                                dataTransaksi.get(i).getTgl(),
//                                                dataTransaksi.get(i).getNoBukti(),
//                                                dataTransaksi.get(i).getModul(),
//                                                dataTransaksi.get(i).getBayar(),
//                                                dataTransaksi.get(i).getTagihan(),
//                                                dataTransaksi.get(i).getKeterangan()
//                                        ));
//                                    }
//                                    adapter = new PiutangAdapter(riwayatArrayList);
//                                    adapter.notifyDataSetChanged();
//                                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//                                    recyclerView.setLayoutManager(layoutManager);
//                                    recyclerView.setAdapter(adapter);
//                                }
//                                progressBar.setVisibility(View.GONE);
//                            }
//                        } else {
//                            Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Piutang> call, Throwable t) {
//                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
//                        progressBar.setVisibility(View.GONE);
//                    }
//                });
//    }

}
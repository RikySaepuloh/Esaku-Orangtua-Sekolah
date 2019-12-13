package com.saku.sekolah.ui.beranda;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.adapter.DepositAdapter;
import com.saku.sekolah.adapter.PelajaranAdapter;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.beranda.ModelPelajaran;
import com.saku.sekolah.model.keuangan.Deposit;
import com.saku.sekolah.model.keuangan.Deposit2Item;
import com.saku.sekolah.model.keuangan.DepositItem;
import com.saku.sekolah.model.keuangan.ModelDeposit;
import com.saku.sekolah.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HariFragment extends Fragment {
    String hari;
    @BindView(R.id.hari_mapel_berlangsung)
    TextView hariMapelBerlangsung;
    @BindView(R.id.hari_mapel_mulai)
    TextView hariMapelMulai;
    @BindView(R.id.hari_mapel_berakhir)
    TextView hariMapelBerakhir;
    @BindView(R.id.hari_recyclerview)
    RecyclerView hariRecyclerview;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;
    private ArrayList<ModelPelajaran> pelajaranArrayList = new ArrayList<>();
    private PelajaranAdapter adapter;

    public HariFragment(String hari) {
        this.hari = hari;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hari, container, false);
        ButterKnife.bind(this, view);
        context = getContext();
        mApiService = UtilsApi.getAPIService(context);
        sp = new Preferences(context);
        adapter=new PelajaranAdapter(context);
        hariMapelBerlangsung.setText(hari);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        hariRecyclerview.setLayoutManager(layoutManager);
        hariRecyclerview.setAdapter(adapter);
        pelajaranArrayList.clear();
        pelajaranArrayList.add(new ModelPelajaran("Bahasa Inggris","Siti Warindah","Alpha","07.30","09.30"));
        pelajaranArrayList.add(new ModelPelajaran("Bahasa Indonesia","Siti Badriah","Ijin","10.00","11.30"));
        pelajaranArrayList.add(new ModelPelajaran("Matematika","Obay","Sakit","13.00","15.00"));
        pelajaranArrayList.add(new ModelPelajaran("Fisika","Cecep Berbacep","Hadir","16.00","17.00"));
        pelajaranArrayList.add(new ModelPelajaran("BK","Liah Sumarliah","---","17.00","17.30"));
        adapter.addData(pelajaranArrayList);
//        initDeposit(sp.getToken(), sp.getUserLog(), sp.getKodePP(), sp.getLokasi());
        return view;
    }

//    private void initDeposit(String token, String nik, String kode_pp, String lokasi) {
//        progressBar.setVisibility(View.VISIBLE);
//        depositArrayList.clear();
//        mApiService.getDeposit(token, nik, kode_pp, lokasi)
//                .enqueue(new Callback<Deposit>() {
//                    @Override
//                    public void onResponse(Call<Deposit> call, Response<Deposit> response) {
//                        if (response.isSuccessful()) {
//                            if (response.body().isStatus()) {
//                                List<DepositItem> dataSiswa = response.body().getDaftar();
//                                if (dataSiswa.size() > 0) {
//                                    for (int i = 0; i < dataSiswa.size(); i++) {
//                                        listDepositSaldo.setText("Rp. " + response.body().getSoAkhir());
//                                        listDepositNama.setText(": " + dataSiswa.get(i).getNama());
//                                        listDepositNis.setText(": " + dataSiswa.get(i).getNis());
//                                        listDepositBank.setText(": " + dataSiswa.get(i).getIdBank());
//                                    }
//                                }
//                                List<Deposit2Item> dataTransaksi = response.body().getDaftar2();
//                                if (dataTransaksi.size() > 0) {
//                                    for (int i = 0; i < dataTransaksi.size(); i++) { //3 = Limit data
//                                        if (dataTransaksi.get(i).getDc().equals("C")) {
//                                            depositArrayList.add(new ModelDeposit(
//                                                    "Pembayaran",
//                                                    dataTransaksi.get(i).getTgl(),
//                                                    dataTransaksi.get(i).getNoBukti(),
//                                                    dataTransaksi.get(i).getKredit()
//                                            ));
//                                        } else {
//                                            depositArrayList.add(new ModelDeposit(
//                                                    "Deposit",
//                                                    dataTransaksi.get(i).getTgl(),
//                                                    dataTransaksi.get(i).getNoBukti(),
//                                                    dataTransaksi.get(i).getDebet()
//                                            ));
//                                        }
//                                    }
//                                    adapter = new DepositAdapter(depositArrayList);
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
//                    public void onFailure(Call<Deposit> call, Throwable t) {
//                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
//                        progressBar.setVisibility(View.GONE);
//                    }
//                });
//    }


}

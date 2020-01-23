package com.saku.sekolah.ui.keuangan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.saku.sekolah.R;
import com.saku.sekolah.adapter.RincianAdapter;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.keuangan.ModelRincian;
import com.saku.sekolah.model.keuangan.ModelRincianItem;
import com.saku.sekolah.model.keuangan.ModelRincianItemData;
import com.saku.sekolah.model.keuangan.Rincian;
import com.saku.sekolah.model.keuangan.Rincian2Item;
import com.saku.sekolah.model.keuangan.Rincian3Item;
import com.saku.sekolah.model.keuangan.RincianItem;
import com.saku.sekolah.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RincianActivity extends AppCompatActivity {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.rincian_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;
    private ArrayList<ModelRincian> rincianArrayList = new ArrayList<>();
    private ArrayList<ModelRincianItem> rincianItemArrayList = new ArrayList<>();
    private ArrayList<ModelRincianItemData> rincianItemDataArrayList = new ArrayList<>();
    RincianAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincian);
        ButterKnife.bind(this);
        context = this;
        sp = new Preferences(context);
        mApiService = UtilsApi.getAPIService(context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        adapter = new RincianAdapter(rincianArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        initRincian(sp.getUserLog(),sp.getKodePP(),sp.getLokasi(),"2018");
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initRincian(String nik, String kode_pp, String lokasi,String tahun) {
        progressBar.setVisibility(View.VISIBLE);
        rincianArrayList.clear();
        rincianItemArrayList.clear();
        rincianItemDataArrayList.clear();
        mApiService.getRincian(nik, kode_pp, lokasi,tahun)
                .enqueue(new Callback<Rincian>() {
                    @Override
                    public void onResponse(Call<Rincian> call, Response<Rincian> response) {
                        if (response.isSuccessful()) {
                            if (response.body().isStatus()) {
                                List<RincianItem> dataPeriode = response.body().getDaftar();
                                List<Rincian2Item> dataTransaksi = response.body().getDaftar2();
                                List<Rincian3Item> dataRincian = response.body().getDaftar3();
                                if (dataPeriode.size() > 0) {
                                    for (int i = 0; i < dataPeriode.size(); i++) {
                                        for (int a = 0; a<dataTransaksi.size();a++){
                                            for (int b = 0; b<dataRincian.size();b++){
                                                if (dataTransaksi.get(a).getNoBill().equals(dataRincian.get(b).getNoBill())

                                                        && dataPeriode.get(i).getPeriode().equals(dataRincian.get(b).getPeriode())
                                                ){
                                                    rincianItemDataArrayList.add(new ModelRincianItemData(
                                                            dataRincian.get(b).getKodeParam(),
                                                            dataRincian.get(b).getSaldo()
                                                    ));
                                                }
                                            }
                                            if (dataPeriode.get(i).getPeriode().equals(dataTransaksi.get(a).getPeriode())){
                                                rincianItemArrayList.add(new ModelRincianItem(
                                                        dataTransaksi.get(a).getTanggal(),
                                                        dataTransaksi.get(a).getNoBill(),
                                                        dataTransaksi.get(a).getJumParam(),
                                                        rincianItemDataArrayList
//                                                        dataTransaksi.get(a).getPeriode(),
//                                                        dataTransaksi.get(a).getNoBill()
                                                ));
                                            }
                                        }
                                        rincianArrayList.add(new ModelRincian(
                                                dataPeriode.get(i).getPeriode(),
                                                rincianItemArrayList));
                                    }
                                }
                                adapter.notifyDataSetChanged();
                            }
                            progressBar.setVisibility(View.GONE);
                        } else {
                            Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Rincian> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
}

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
import com.saku.sekolah.adapter.RiwayatAdapter;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.keuangan.ModelRiwayat;
import com.saku.sekolah.model.keuangan.Riwayat;
import com.saku.sekolah.model.keuangan.RiwayatItem;
import com.saku.sekolah.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatActivity extends AppCompatActivity {

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
    private RiwayatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);
        ButterKnife.bind(this);
        context = this;
        sp = new Preferences(context);
        mApiService = UtilsApi.getAPIService(context);

        initRiwayat(sp.getUserLog(), sp.getKodePP(), sp.getLokasi());
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initRiwayat(String nik, String kode_pp, String lokasi) {
        progressBar.setVisibility(View.VISIBLE);
        riwayatArrayList.clear();
        mApiService.getRiwayat(nik, kode_pp, lokasi)
                .enqueue(new Callback<Riwayat>() {
                    @Override
                    public void onResponse(Call<Riwayat> call, Response<Riwayat> response) {
                        if (response.isSuccessful()) {
                            if (response.body().isStatus()) {
                                List<RiwayatItem> dataTransaksi = response.body().getDaftar();
                                if (dataTransaksi.size() > 0) {
                                    for (int i = 0; i < dataTransaksi.size(); i++) {
                                        if(dataTransaksi.get(i).getModul().equals("BILL")){
                                            riwayatArrayList.add(new ModelRiwayat(
                                                    dataTransaksi.get(i).getTgl(),
                                                    dataTransaksi.get(i).getNoBukti(),
                                                    dataTransaksi.get(i).getModul(),
                                                    dataTransaksi.get(i).getKeterangan(),
                                                    dataTransaksi.get(i).getTagihan()
                                            ));
                                        }else{
                                            riwayatArrayList.add(new ModelRiwayat(
                                                    dataTransaksi.get(i).getTgl(),
                                                    dataTransaksi.get(i).getNoBukti(),
                                                    dataTransaksi.get(i).getModul(),
                                                    dataTransaksi.get(i).getKeterangan(),
                                                    dataTransaksi.get(i).getBayar()
                                            ));
                                        }
                                    }
                                    adapter = new RiwayatAdapter(riwayatArrayList);
                                    adapter.notifyDataSetChanged();
                                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                                    recyclerView.setLayoutManager(layoutManager);
                                    recyclerView.setAdapter(adapter);
                                }
                                progressBar.setVisibility(View.GONE);
                            }
                        } else {
                            Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Riwayat> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
}

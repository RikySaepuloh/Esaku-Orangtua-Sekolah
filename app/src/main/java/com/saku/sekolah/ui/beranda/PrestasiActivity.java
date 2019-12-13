package com.saku.sekolah.ui.beranda;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.adapter.PrestasiAdapter;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.beranda.prestasi.DaftarPrestasi;
import com.saku.sekolah.model.beranda.prestasi.ModelPrestasi;
import com.saku.sekolah.model.beranda.prestasi.Prestasi;
import com.saku.sekolah.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrestasiActivity extends AppCompatActivity {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.prestasi_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.nama_profil)
    TextView namaProfil;
    @BindView(R.id.nis_profil)
    TextView nisProfil;
    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;
    private ArrayList<ModelPrestasi> prestasiArrayList = new ArrayList<>();
    private PrestasiAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi);
        ButterKnife.bind(this);
        context = this;
        mApiService = UtilsApi.getAPIService(context);
        sp = new Preferences(context);
        namaProfil.setText(": "+sp.getNamaUser());
        nisProfil.setText(": "+sp.getUserLog()); //TODO:NIK HARUS JADI NIS
        adapter = new PrestasiAdapter(context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        initPrestasi(sp.getUserLog(), sp.getKodePP(), sp.getLokasi());

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initPrestasi(String nik, String kode_pp, String lokasi) {
        progressBar.setVisibility(View.VISIBLE);
        prestasiArrayList.clear();
        mApiService.getPrestasi(nik, kode_pp, lokasi)
                .enqueue(new Callback<Prestasi>() {
                    @Override
                    public void onResponse(Call<Prestasi> call, Response<Prestasi> response) {
                        if (response.isSuccessful()) {
                            if (response.body().isStatus()) {
                                List<DaftarPrestasi> daftarPrestasi = response.body().getDaftar();
                                if (daftarPrestasi.size() > 0) {
                                    for (int i = 0; i < daftarPrestasi.size(); i++) {
                                        prestasiArrayList.add(new ModelPrestasi(
                                                daftarPrestasi.get(i).getTgl(),
                                                daftarPrestasi.get(i).getKeterangan(),
                                                daftarPrestasi.get(i).getTempat(),
                                                daftarPrestasi.get(i).getJenis()
                                        ));
                                    }
                                    adapter.addData(prestasiArrayList);
                                }
                            }
                            progressBar.setVisibility(View.GONE);
                        } else {
                            Toast.makeText(context, "Server Bermasalah", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onFailure(Call<Prestasi> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }


}

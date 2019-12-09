package com.saku.sekolah.ui.keuangan;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.keuangan.Deposit;
import com.saku.sekolah.model.keuangan.Deposit2Item;
import com.saku.sekolah.model.keuangan.DepositItem;
import com.saku.sekolah.model.keuangan.ModelLaporanDeposit;
import com.saku.sekolah.preferences.LoadImage;
import com.saku.sekolah.preferences.Preferences;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanDepositFragment extends Fragment {


    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.deposit_nama)
    TextView depositNama;
    @BindView(R.id.deposit_nis)
    TextView depositNis;
    @BindView(R.id.deposit_bank)
    TextView depositBank;
    @BindView(R.id.deposit_saldo)
    TextView depositSaldo;
    @BindView(R.id.deposit_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.tv_deposit_sekolah)
    TextView tvDepositSekolah;
    @BindView(R.id.deposit_kelas)
    TextView depositKelas;
    @BindView(R.id.deposit_angkatan)
    TextView depositAngkatan;
    @BindView(R.id.deposit_jurusan)
    TextView depositJurusan;
    @BindView(R.id.iv_profile)
    ImageView ivProfile;

    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;
    private ArrayList<ModelLaporanDeposit> laporanDepositArrayList = new ArrayList<>();
    private LaporanDepositAdapter adapter;
    LoadImage loadImage;

//    String imgURL = "http://saiweb.simkug.com/upload/";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_laporan_deposit, container, false);
        ButterKnife.bind(this, view);
        mApiService = UtilsApi.getAPIService();
        context = getContext();
        sp = new Preferences(context);
        loadImage=new LoadImage(ivProfile,sp.getLogo());
//        loadImageFromURL(sp.getLogo());
        initLaporanDeposit(sp.getToken(), sp.getUserLog(), sp.getKodePP(), sp.getLokasi());
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
            }
        });
        return view;
    }

//    public void loadImageFromURL(String url) {
//        Picasso.get().load(imgURL + url).placeholder(R.drawable.img_loading)
//                .error(R.drawable.no_image)
//                .into(ivProfile, new com.squareup.picasso.Callback() {
//                    @Override
//                    public void onSuccess() {
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        Log.e("Error on ImageLoad:", e.toString());
//                    }
//                });
//    }

    private void initLaporanDeposit(String token, String nik, String kode_pp, String lokasi) {
        progressBar.setVisibility(View.VISIBLE);
        laporanDepositArrayList.clear();
        mApiService.getDeposit(token, nik, kode_pp, lokasi)
                .enqueue(new Callback<Deposit>() {
                    @Override
                    public void onResponse(Call<Deposit> call, Response<Deposit> response) {
                        if (response.isSuccessful()) {
                            if (response.body().isStatus()) {
                                List<DepositItem> dataSiswa = response.body().getDaftar();
                                if (dataSiswa.size() > 0) {
                                    for (int i = 0; i < dataSiswa.size(); i++) { //3 = Limit data
                                        tvDepositSekolah.setText(dataSiswa.get(i).getNamaPp());
                                        depositNis.setText(": " + dataSiswa.get(i).getNis());
                                        depositNama.setText(": " + dataSiswa.get(i).getNama());
                                        depositBank.setText(": " + dataSiswa.get(i).getIdBank());
                                        depositSaldo.setText(": Rp. " + response.body().getSoAkhir());
                                        depositKelas.setText(": " + dataSiswa.get(i).getNamaKelas());
                                        depositAngkatan.setText(": " + dataSiswa.get(i).getKodeAkt());
                                        depositJurusan.setText(": " + dataSiswa.get(i).getNamaJur());
                                    }
                                }
                                List<Deposit2Item> dataTransaksi = response.body().getDaftar2();
                                if (dataTransaksi.size() > 0) {
                                    int saldo = 0;
                                    for (int i = 0; i < dataTransaksi.size(); i++) { //3 = Limit data
                                        if (dataTransaksi.get(i).getDc().equals("C")) {
                                            saldo += Integer.parseInt(dataTransaksi.get(i).getDebet()) - Integer.parseInt(dataTransaksi.get(i).getKredit());
                                            laporanDepositArrayList.add(new ModelLaporanDeposit(
                                                    dataTransaksi.get(i).getTgl(),
                                                    dataTransaksi.get(i).getNoBukti(),
                                                    dataTransaksi.get(i).getDc(),
                                                    dataTransaksi.get(i).getKredit(),
                                                    String.valueOf(saldo),
                                                    dataTransaksi.get(i).getKeterangan()
                                            ));
                                        } else {
                                            saldo += Integer.parseInt(dataTransaksi.get(i).getDebet()) - Integer.parseInt(dataTransaksi.get(i).getKredit());
                                            laporanDepositArrayList.add(new ModelLaporanDeposit(
                                                    dataTransaksi.get(i).getTgl(),
                                                    dataTransaksi.get(i).getNoBukti(),
                                                    dataTransaksi.get(i).getDc(),
                                                    dataTransaksi.get(i).getDebet(),
                                                    String.valueOf(saldo),
                                                    dataTransaksi.get(i).getKeterangan()
                                            ));
                                        }
                                    }
                                    adapter = new LaporanDepositAdapter(laporanDepositArrayList);
                                    adapter.notifyDataSetChanged();
                                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
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
                    public void onFailure(Call<Deposit> call, Throwable t) {
                        Toast.makeText(context, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }
}

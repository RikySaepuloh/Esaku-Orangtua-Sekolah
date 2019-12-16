package com.saku.sekolah.ui.keuangan;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.saku.sekolah.R;
import com.saku.sekolah.adapter.DepositAdapter;
import com.saku.sekolah.apihelper.BaseApiService;
import com.saku.sekolah.apihelper.UtilsApi;
import com.saku.sekolah.model.keuangan.Deposit;
import com.saku.sekolah.model.keuangan.Deposit2Item;
import com.saku.sekolah.model.keuangan.DepositItem;
import com.saku.sekolah.model.keuangan.ModelDeposit;
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

public class DepositFragment extends Fragment {
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.list_deposit_saldo)
    TextView listDepositSaldo;
    @BindView(R.id.layout_deposit_title)
    LinearLayout layoutDepositTitle;
    @BindView(R.id.list_deposit_nama)
    TextView listDepositNama;
    @BindView(R.id.list_deposit_nis)
    TextView listDepositNis;
    @BindView(R.id.list_deposit_bank)
    TextView listDepositBank;
    @BindView(R.id.layout_deposit_body)
    LinearLayout layoutDepositBody;
    @BindView(R.id.layout_deposit)
    CardView layoutDeposit;
    @BindView(R.id.btn_laporandeposit)
    FloatingActionButton btnLaporandeposit;
    @BindView(R.id.deposit_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private BaseApiService mApiService;
    private Context context;
    private Preferences sp;
    private ArrayList<ModelDeposit> depositArrayList = new ArrayList<>();
    private DepositAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deposit, container, false);
        ButterKnife.bind(this, view);
        context = getContext();
        sp = new Preferences(context);
        mApiService = UtilsApi.getAPIService(context);
        initDeposit(sp.getUserLog(), sp.getKodePP(), sp.getLokasi());

        btnLaporandeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LaporanDepositFragment newFragment = new LaporanDepositFragment();

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

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                fm.popBackStack();
            }
        });
        return view;
    }

    private void initDeposit(String nik, String kode_pp, String lokasi) {
        progressBar.setVisibility(View.VISIBLE);
        depositArrayList.clear();
        mApiService.getDeposit(nik, kode_pp, lokasi)
                .enqueue(new Callback<Deposit>() {
                    @Override
                    public void onResponse(Call<Deposit> call, Response<Deposit> response) {
                        if (response.isSuccessful()) {
                            if (response.body().isStatus()) {
                                List<DepositItem> dataSiswa = response.body().getDaftar();
                                if (dataSiswa.size() > 0) {
                                    for (int i = 0; i < dataSiswa.size(); i++) {
                                        listDepositSaldo.setText("Rp. "+response.body().getSoAkhir());
                                        listDepositNama.setText(": "+dataSiswa.get(i).getNama());
                                        listDepositNis.setText(": " + dataSiswa.get(i).getNis());
                                        listDepositBank.setText(": " + dataSiswa.get(i).getIdBank());
                                    }
                                }
                                List<Deposit2Item> dataTransaksi = response.body().getDaftar2();
                                if (dataTransaksi.size() > 0) {
                                    for (int i = 0; i < dataTransaksi.size(); i++) { //3 = Limit data
                                        if (dataTransaksi.get(i).getDc().equals("C")){
                                            depositArrayList.add(new ModelDeposit(
                                                    "Pembayaran",
                                                    dataTransaksi.get(i).getTgl(),
                                                    dataTransaksi.get(i).getNoBukti(),
                                                    dataTransaksi.get(i).getKredit()
                                            ));
                                        }else{
                                            depositArrayList.add(new ModelDeposit(
                                                    "Deposit",
                                                    dataTransaksi.get(i).getTgl(),
                                                    dataTransaksi.get(i).getNoBukti(),
                                                    dataTransaksi.get(i).getDebet()
                                            ));
                                        }
                                    }
                                    adapter = new DepositAdapter(depositArrayList);
                                    adapter.notifyDataSetChanged();
                                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                                    recyclerView.setLayoutManager(layoutManager);
                                    recyclerView.setAdapter(adapter);
                                }
                            }else{
                                Toast.makeText(context,response.body().getMessage(),Toast.LENGTH_LONG).show();
                            }
                            progressBar.setVisibility(View.GONE);
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
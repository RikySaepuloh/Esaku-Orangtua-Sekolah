package com.saku.sekolah.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.MainActivity;
import com.saku.sekolah.R;
import com.saku.sekolah.model.keuangan.ModelLaporanDeposit;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.saku.sekolah.MainActivity.localeID;


public class LaporanDepositAdapter extends RecyclerView.Adapter<LaporanDepositAdapter.LaporanDepositViewHolder> {

    private ArrayList<ModelLaporanDeposit> dataList;
    private Context ctx;

    public LaporanDepositAdapter(ArrayList<ModelLaporanDeposit> dataList) {
        this.dataList = dataList;
    }

    @Override
    public LaporanDepositViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_piutang, parent, false);
        ctx = parent.getContext();
        return new LaporanDepositViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LaporanDepositViewHolder holder, int position) {
        holder.listPiutangTanggal.setText(dataList.get(position).getTanggal()+" | "+dataList.get(position).getKode());
        holder.listPiutangDeskripsi.setText(dataList.get(position).getDeskripsi());
        holder.listPiutangNilai.setText(NumberFormat.getNumberInstance(localeID).format(Integer.parseInt(dataList.get(position).getNilai())));
        if (dataList.get(position).getJenis().equals("D")){
            holder.listPiutangTransaksi.setText("+ "+NumberFormat.getNumberInstance(localeID).format(Integer.parseInt(dataList.get(position).getTransaksi())));
            holder.listPiutangTransaksi.setTextColor(Color.parseColor("#00C320"));
        }else{
            holder.listPiutangTransaksi.setTextColor(Color.parseColor("#007AFF"));
            holder.listPiutangTransaksi.setText("- "+NumberFormat.getNumberInstance(localeID).format(Integer.parseInt(dataList.get(position).getTransaksi())));
        }

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class LaporanDepositViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_piutang_tanggal)
        TextView listPiutangTanggal;
        @BindView(R.id.list_piutang_transaksi)
        TextView listPiutangTransaksi;
        @BindView(R.id.list_piutang_nilai)
        TextView listPiutangNilai;
        @BindView(R.id.list_piutang_deskripsi)
        TextView listPiutangDeskripsi;

        public LaporanDepositViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

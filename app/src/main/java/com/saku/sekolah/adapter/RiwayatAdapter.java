package com.saku.sekolah.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.keuangan.ModelRiwayat;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder> {



    private ArrayList<ModelRiwayat> dataList;
    private Context ctx;

    public RiwayatAdapter(ArrayList<ModelRiwayat> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RiwayatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_riwayat, parent, false);
        ctx = parent.getContext();
        return new RiwayatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RiwayatViewHolder holder, int position) {
        holder.riwayatListTanggalkode.setText(dataList.get(position).getTanggal() + " | " + dataList.get(position).getKode());
        holder.riwayatListDeskripsi.setText(dataList.get(position).getDeskripsi());
        holder.riwayatListJumlah.setText(dataList.get(position).getNilai());
//        if (dataList.get(position).getJenis().equals("BILL")) {
//            holder.listPiutangTransaksi.setText("- " + dataList.get(position).getTransaksi());
//            holder.listPiutangTransaksi.setTextColor(Color.parseColor("#00C320"));
//        } else {
//            holder.listPiutangTransaksi.setTextColor(Color.parseColor("#007AFF"));
//            holder.listPiutangTransaksi.setText("+ " + dataList.get(position).getTransaksi());
//        }

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class RiwayatViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.riwayat_list_tanggalkode)
        TextView riwayatListTanggalkode;
        @BindView(R.id.riwayat_list_jenis)
        TextView riwayatListJenis;
        @BindView(R.id.riwayat_list_deskripsi)
        TextView riwayatListDeskripsi;
        @BindView(R.id.riwayat_list_jumlah)
        TextView riwayatListJumlah;
        public RiwayatViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

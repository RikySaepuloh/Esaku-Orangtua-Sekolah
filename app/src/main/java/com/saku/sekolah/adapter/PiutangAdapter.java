package com.saku.sekolah.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.ModelPesan;
import com.saku.sekolah.model.keuangan.ModelPiutang;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PiutangAdapter extends RecyclerView.Adapter<PiutangAdapter.PiutangViewHolder> {


    private ArrayList<ModelPiutang> dataList;
    private Context ctx;

    public PiutangAdapter(ArrayList<ModelPiutang> dataList) {
        this.dataList = dataList;
    }

    @Override
    public PiutangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_piutang, parent, false);
        ctx = parent.getContext();
        return new PiutangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PiutangViewHolder holder, int position) {
        holder.listPiutangTanggal.setText(dataList.get(position).getTanggal()+" | "+dataList.get(position).getKode());
        holder.listPiutangDeskripsi.setText(dataList.get(position).getDeskripsi());
        holder.listPiutangNilai.setText(dataList.get(position).getNilai());
        if (dataList.get(position).getJenis().equals("BILL")){
            holder.listPiutangTransaksi.setText("- "+dataList.get(position).getTransaksi());
            holder.listPiutangTransaksi.setTextColor(Color.parseColor("#00C320"));
        }else{
            holder.listPiutangTransaksi.setTextColor(Color.parseColor("#007AFF"));
            holder.listPiutangTransaksi.setText("+ "+dataList.get(position).getTransaksi());
        }

//        holder.listPiutangDeskripsi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent= new Intent(ctx, DetailPengajuanActivity.class);
////                intent.putExtra("kd_asset",dataList.get(position).getKode());
////                intent.putExtra("mon_id",dataList.get(position).getMon_id());
////                ctx.startActivity(intent);
//                Toast.makeText(ctx, "testing", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class PiutangViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_piutang_tanggal)
        TextView listPiutangTanggal;
        @BindView(R.id.list_piutang_transaksi)
        TextView listPiutangTransaksi;
        @BindView(R.id.list_piutang_nilai)
        TextView listPiutangNilai;
        @BindView(R.id.list_piutang_deskripsi)
        TextView listPiutangDeskripsi;

        public PiutangViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

package com.saku.sekolah.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.ModelPesan;

import java.util.ArrayList;


public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.PesanViewHolder> {
    private ArrayList<ModelPesan> dataList;
    private Context ctx;

    public PesanAdapter(ArrayList<ModelPesan> dataList) {
        this.dataList = dataList;
    }

    @Override
    public PesanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_pesan, parent, false);
        ctx=parent.getContext();
        return new PesanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PesanViewHolder holder, int position) {
        holder.txtJudul.setText(dataList.get(position).getJudul());
        holder.txtIsi.setText(dataList.get(position).getIsi());
        if (dataList.get(position).getTanggal().equals("same")){
            holder.txtTanggal.setVisibility(View.GONE);
        }else{
            holder.txtTanggal.setText(dataList.get(position).getTanggal());
        }
//        if (dataList.size()>1){
//            if (!dataList.get(position).equals(0)){
//                if (dataList.get(position-1).getTanggal().equals(dataList.get(position).getTanggal())){
//                    holder.txtTanggal.setVisibility(View.GONE);
//                }
//            }
//        }
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent= new Intent(ctx, DetailPengajuanActivity.class);
//                intent.putExtra("kd_asset",dataList.get(position).getKode());
//                intent.putExtra("mon_id",dataList.get(position).getMon_id());
//                ctx.startActivity(intent);
                Toast.makeText(ctx,"testing",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class PesanViewHolder extends RecyclerView.ViewHolder{
        private TextView txtJudul, txtIsi,txtTanggal;
        private LinearLayout layout;

        public PesanViewHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.pesan_list);
            txtTanggal = itemView.findViewById(R.id.pesan_list_tanggal);
            txtJudul= itemView.findViewById(R.id.pesan_list_judul);
            txtIsi = itemView.findViewById(R.id.pesan_list_isi);
        }
    }
}

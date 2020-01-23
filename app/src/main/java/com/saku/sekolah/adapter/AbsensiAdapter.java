package com.saku.sekolah.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.absensi.ModelAbsensi;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AbsensiAdapter extends RecyclerView.Adapter<AbsensiAdapter.AbsensiViewHolder> {
    private ArrayList<ModelAbsensi> mList;
    @NonNull
    @Override
    public AbsensiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_absensi,parent,false);
        AbsensiViewHolder Aa =  new AbsensiViewHolder(view);
        return Aa;
    }

    @Override
    public void onBindViewHolder(@NonNull AbsensiViewHolder holder, int position) {
        holder.status.setText(mList.get(position).getStatus());
        holder.tgl.setText(mList.get(position).getTgl());
        holder.jam.setText(mList.get(position).getJam());
        holder.jam.setTextColor(Color.parseColor("#007AFF"));
        if(mList.get(position).getStatus()=="Alpha"){
            holder.card.setBackgroundColor(Color.parseColor("#FF3B30"));
            holder.jam.setTextColor(Color.parseColor("#FF3B30"));
        }else if(mList.get(position).getStatus()=="Ijin"){
            holder.card.setBackgroundColor(Color.parseColor("#FFCC00"));
            holder.jam.setTextColor(Color.parseColor("#FFCC00"));
        }else if(mList.get(position).getStatus()=="Sakit"){
            holder.card.setBackgroundColor(Color.parseColor("#4CD964"));
            holder.jam.setTextColor(Color.parseColor("#4CD964"));
        }else{

        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class AbsensiViewHolder extends RecyclerView.ViewHolder {
        public TextView status;
        public TextView tgl;
        public TextView jam;
        public FrameLayout card;
        public AbsensiViewHolder(@NonNull View itemView) {
            super(itemView);
            status = itemView.findViewById(R.id.list_absensi_jenis);
            tgl = itemView.findViewById(R.id.list_absensi_tgl);
            jam = itemView.findViewById(R.id.list_absensi_jam);
            card = itemView.findViewById(R.id.list_absensi_card);
        }
    }
    public AbsensiAdapter (ArrayList<ModelAbsensi> list){
        mList=list;
    }




}

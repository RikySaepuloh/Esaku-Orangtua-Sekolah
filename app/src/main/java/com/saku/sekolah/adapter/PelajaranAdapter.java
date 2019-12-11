package com.saku.sekolah.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.beranda.ModelPelajaran;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PelajaranAdapter extends RecyclerView.Adapter<PelajaranAdapter.PelajaranViewHolder> {



    private ArrayList<ModelPelajaran> dataList;
    private Context ctx;

    public PelajaranAdapter(Context c) {
        ctx = c;
    }

    @Override
    public PelajaranViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_pelajaran, parent, false);
        return new PelajaranViewHolder(view);
    }

    public void addData(ArrayList<ModelPelajaran> items) {
        dataList = items;
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(final PelajaranViewHolder holder, int position) {

        holder.listPelajaranMapel.setText(dataList.get(position).getMapel());
        holder.listPelajaranGuru.setText(dataList.get(position).getGuru());
        holder.listPelajaranStatushadir.setText(dataList.get(position).getKehadiran());
        holder.listPelajaranMulai.setText(dataList.get(position).getMasuk());
        holder.listPelajaranBerakhir.setText(dataList.get(position).getBerakhir());
        if (dataList.get(position).getKehadiran().equals("Hadir")){
            holder.ivStatuskehadiran.setImageResource(R.drawable.ic_listbiru);
            holder.listPelajaranStatushadir.setTextColor(Color.parseColor("#007AFF"));
        }else if(dataList.get(position).getKehadiran().equals("Alpha")){
            holder.ivStatuskehadiran.setImageResource(R.drawable.ic_listmerah);
            holder.listPelajaranStatushadir.setTextColor(Color.parseColor("#FF3B30"));
        }else if(dataList.get(position).getKehadiran().equals("Ijin")){
            holder.ivStatuskehadiran.setImageResource(R.drawable.ic_listkuning);
            holder.listPelajaranStatushadir.setTextColor(Color.parseColor("#FFCC00"));
        }else if(dataList.get(position).getKehadiran().equals("Sakit")){
            holder.ivStatuskehadiran.setImageResource(R.drawable.ic_listhijau);
            holder.listPelajaranStatushadir.setTextColor(Color.parseColor("#4bda64"));
        }else{
            holder.ivStatuskehadiran.setImageResource(R.drawable.ic_listabu);
        }

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class PelajaranViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_statuskehadiran)
        ImageView ivStatuskehadiran;
        @BindView(R.id.list_pelajaran_mapel)
        TextView listPelajaranMapel;
        @BindView(R.id.list_pelajaran_guru)
        TextView listPelajaranGuru;
        @BindView(R.id.list_pelajaran_statushadir)
        TextView listPelajaranStatushadir;
        @BindView(R.id.list_pelajaran_mulai)
        TextView listPelajaranMulai;
        @BindView(R.id.list_pelajaran_berakhir)
        TextView listPelajaranBerakhir;

        public PelajaranViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

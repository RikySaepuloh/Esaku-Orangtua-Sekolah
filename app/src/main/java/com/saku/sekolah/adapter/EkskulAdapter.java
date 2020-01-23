package com.saku.sekolah.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.ModelEkskul;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class EkskulAdapter extends RecyclerView.Adapter<EkskulAdapter.EkskulViewHolder> {
    private ArrayList<ModelEkskul> mList;
    @NonNull
    @Override
    public EkskulViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ekskul,parent,false);
        EkskulViewHolder EVH = new EkskulViewHolder(v);
        return EVH;
    }

    @Override
    public void onBindViewHolder(@NonNull EkskulViewHolder holder, int position) {
        holder.nama_guru.setText(mList.get(position).getNama_guru());
        holder.nama_ekskul.setText(mList.get(position).getNama_ekskul());
        holder.masuk.setText(mList.get(position).getMasuk());
        holder.berakhir.setText(mList.get(position).getMasuk());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class EkskulViewHolder extends RecyclerView.ViewHolder {
        private TextView nama_ekskul,nama_guru,masuk,berakhir;
        public EkskulViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_ekskul = (TextView)itemView.findViewById(R.id.list_ekskul_nama);
            nama_guru = itemView.findViewById(R.id.list_ekskul_guru);
            masuk = itemView.findViewById(R.id.list_ekskul_mulai);
            berakhir = itemView.findViewById(R.id.list_ekskul_berakhir);
        }
    }
    public EkskulAdapter(ArrayList<ModelEkskul> list){
        mList = list;
    }
}

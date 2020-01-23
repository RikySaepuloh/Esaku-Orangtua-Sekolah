package com.saku.sekolah.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.ModalAkademik;

import java.util.ArrayList;

public class AkademikAdapter extends RecyclerView.Adapter<AkademikAdapter.AkademikViewHolder> {
    ArrayList<ModalAkademik> mList;
    @NonNull
    @Override
    public AkademikViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_akademik,parent,false);
        AkademikViewHolder AKH = new AkademikViewHolder(view);
        return AKH;
    }

    @Override
    public void onBindViewHolder(@NonNull AkademikViewHolder holder, int position) {
        holder.tgl.setText(mList.get(position).getTanggal_mulai());
        holder.jadwal.setText(mList.get(position).getJadwal());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class AkademikViewHolder extends RecyclerView.ViewHolder{
            private TextView tgl;
            private TextView jadwal;
            public AkademikViewHolder(View Itemview){
                super(Itemview);
                tgl = Itemview.findViewById(R.id.list_akademik_tgl);
                jadwal = Itemview.findViewById(R.id.list_akademik_jadwal);
          }

    }
    public AkademikAdapter (ArrayList<ModalAkademik> list){
        mList = list;
    }
}

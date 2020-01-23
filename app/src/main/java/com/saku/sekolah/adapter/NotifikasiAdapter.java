package com.saku.sekolah.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.LihatNotifikasiActivity;
import com.saku.sekolah.R;
import com.saku.sekolah.model.ModalNotifikasi;

import java.util.ArrayList;

public class NotifikasiAdapter extends RecyclerView.Adapter<NotifikasiAdapter.NotifikasiViewHolder> {
    private ArrayList<ModalNotifikasi> mItemNotifikasi;
    private String tanggal = "";
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void OnItemClick(int position);
    }

    public void SetOnItemClickListener(OnItemClickListener listener){
        mListener =listener;
    }

    @NonNull
    @Override
    public NotifikasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_notifikasi,parent,false);
        NotifikasiViewHolder NVH = new NotifikasiViewHolder(view,mListener);
        return NVH;
    }

    @Override
    public void onBindViewHolder(@NonNull NotifikasiViewHolder holder, int position) {
        ModalNotifikasi item = mItemNotifikasi.get(position);
        holder.tgl_notifikasi.setText(item.getTgl_notifikasi());
        ForegroundColorSpan fcsBlue = new ForegroundColorSpan(Color.parseColor("#007AFF"));
        ForegroundColorSpan fcsGray = new ForegroundColorSpan(Color.parseColor("#919191"));
        ForegroundColorSpan fcsBlack = new ForegroundColorSpan(Color.BLACK);
        StyleSpan bold = new StyleSpan(Typeface.BOLD);
        String isi = item.getIsi_notifikasi();
        SpannableString ssJudul = new SpannableString(item.getJudul_notifikasi());
        if(isi.length() <= 78){
            if (item.getStatus() == "Dibaca"){
                SpannableString ssIsi = new SpannableString(isi);
                ssJudul.setSpan(fcsGray,0,item.getJudul_notifikasi().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssIsi.setSpan(fcsGray,0,isi.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.notifikasi_teks.setText(ssIsi);
            }else{
                holder.notifikasi_teks.setText(isi);
            }

        }else{
            isi = isi.substring(0,78);
            isi = isi+"...Selengkapnya";

            if(item.getStatus() == "Dibaca"){
                SpannableString ssIsi = new SpannableString(isi);
                ssJudul.setSpan(fcsGray,0,item.getJudul_notifikasi().length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssIsi.setSpan(fcsBlack,81,isi.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssIsi.setSpan(bold,81,isi.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssIsi.setSpan(fcsGray,0,81,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.notifikasi_teks.setText(ssIsi);
            }else{
                SpannableString ssIsi = new SpannableString(isi);
                ssIsi.setSpan(bold,81,isi.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssIsi.setSpan(fcsBlue,81,isi.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.notifikasi_teks.setText(ssIsi);
            }

        }

        holder.judul_notifikasi.setText(ssJudul);
        if(item.getTgl_notifikasi() == tanggal){
            holder.tgl_notifikasi.setVisibility(View.GONE);
        }else {

        }
        tanggal = item.getTgl_notifikasi();

        //Clicked Item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), LihatNotifikasiActivity.class);
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemNotifikasi.size();
    }

    public static class NotifikasiViewHolder extends RecyclerView.ViewHolder{
        public TextView tgl_notifikasi;
        public TextView judul_notifikasi;
        public TextView notifikasi_teks;
        public NotifikasiViewHolder(@NonNull final View itemView, final OnItemClickListener listener) {
            super(itemView);
            tgl_notifikasi = itemView.findViewById(R.id.tgl_notif);
            judul_notifikasi = itemView.findViewById(R.id.judul_notifikasi);
            notifikasi_teks = itemView.findViewById(R.id.notifikasi_teks);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public NotifikasiAdapter(ArrayList<ModalNotifikasi> item_notifikasi){
        mItemNotifikasi = item_notifikasi;
    }
}

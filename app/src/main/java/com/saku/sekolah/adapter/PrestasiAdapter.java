package com.saku.sekolah.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.beranda.prestasi.ModelPrestasi;

import java.text.NumberFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.saku.sekolah.MainActivity.localeID;


public class PrestasiAdapter extends RecyclerView.Adapter<PrestasiAdapter.PrestasiViewHolder> {

    private ArrayList<ModelPrestasi> dataList;
    private Context ctx;

    public PrestasiAdapter(Context context) {
        ctx = context;
    }

    @Override
    public PrestasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_prestasi, parent, false);
        return new PrestasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PrestasiViewHolder holder, int position) {
        holder.listPrestasiTanggal.setText(dataList.get(position).getTanggal());
        holder.listPrestasiKeterangan.setText(dataList.get(position).getKeterangan());
        holder.listPrestasiTempat.setText(dataList.get(position).getTempat());
        holder.listPrestasiJenis.setText(dataList.get(position).getJenis());
    }

    public void addData(ArrayList<ModelPrestasi> items) {
        dataList = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class PrestasiViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_prestasi_tanggal)
        TextView listPrestasiTanggal;
        @BindView(R.id.list_prestasi_keterangan)
        TextView listPrestasiKeterangan;
        @BindView(R.id.list_prestasi_tempat)
        TextView listPrestasiTempat;
        @BindView(R.id.list_prestasi_jenis)
        TextView listPrestasiJenis;

        public PrestasiViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

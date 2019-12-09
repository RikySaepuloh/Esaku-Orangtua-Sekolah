package com.saku.sekolah.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.keuangan.ModelDeposit;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DepositAdapter extends RecyclerView.Adapter<DepositAdapter.DepositViewHolder> {



    private ArrayList<ModelDeposit> dataList;
    private Context ctx;

    public DepositAdapter(ArrayList<ModelDeposit> dataList) {
        this.dataList = dataList;
    }

    @Override
    public DepositViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_deposit, parent, false);
        ctx = parent.getContext();
        return new DepositViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DepositViewHolder holder, int position) {
        holder.listDepositTanggalkode.setText(dataList.get(position).getTanggal()+" | "+dataList.get(position).getKode());
        holder.listDepositJenis.setText(dataList.get(position).getJenis());
        if (dataList.get(position).getJenis().equals("Deposit")){
            holder.listDepositJumlah.setText("+ "+dataList.get(position).getNilai());
            holder.listDepositJenisgambar.setImageResource(R.drawable.ic_trans_deposit);
        }else{
            holder.listDepositJumlah.setText("- "+dataList.get(position).getNilai());
            holder.listDepositJenisgambar.setImageResource(R.drawable.ic_trans_pembayaran);
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class DepositViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_deposit_jenisgambar)
        ImageView listDepositJenisgambar;
        @BindView(R.id.list_deposit_jenis)
        TextView listDepositJenis;
        @BindView(R.id.list_deposit_tanggalkode)
        TextView listDepositTanggalkode;
        @BindView(R.id.list_deposit_jumlah)
        TextView listDepositJumlah;
        public DepositViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

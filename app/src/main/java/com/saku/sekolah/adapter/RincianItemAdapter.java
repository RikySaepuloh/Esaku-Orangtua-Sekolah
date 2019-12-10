package com.saku.sekolah.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.keuangan.ModelRincianItem;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;


public class RincianItemAdapter extends RecyclerView.Adapter<RincianItemAdapter.RincianItemViewHolder> {


    RincianItemDataAdapter adapter;
    private ArrayList<ModelRincianItem> dataList;
    private Context ctx;

    public RincianItemAdapter(ArrayList<ModelRincianItem> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RincianItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_rincian_item, parent, false);
        ctx = parent.getContext();
        return new RincianItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RincianItemViewHolder holder, int position) {
        holder.listRincianTgl.setText(dataList.get(position).getTanggal());
        holder.listRincianTotalparameter.setText(dataList.get(position).getTotal_param()+" Parameter");
        holder.listRincianKode.setText(dataList.get(position).getKode());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ctx);
        adapter = new RincianItemDataAdapter(ctx);
        holder.listRincianRecyclerviewItem.setLayoutManager(layoutManager);
        holder.listRincianRecyclerviewItem.setAdapter(adapter);
        adapter.addData(dataList.get(position).getItemData());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
//        return (dataList != null) ? dataList.size() : 0;
    }

    public class RincianItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_rincian_tgl)
        TextView listRincianTgl;
        @BindView(R.id.list_rincian_totalparameter)
        TextView listRincianTotalparameter;
        @BindView(R.id.list_rincian_kode)
        TextView listRincianKode;
        @BindView(R.id.list_rincian_recyclerview_item)
        RecyclerView listRincianRecyclerviewItem;

        public RincianItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

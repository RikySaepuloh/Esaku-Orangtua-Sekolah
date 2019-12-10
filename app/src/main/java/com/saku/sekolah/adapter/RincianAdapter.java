package com.saku.sekolah.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.keuangan.ModelRincian;

import java.text.NumberFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.saku.sekolah.MainActivity.localeID;


public class RincianAdapter extends RecyclerView.Adapter<RincianAdapter.PiutangViewHolder> {


    RincianItemAdapter adapter;
    private ArrayList<ModelRincian> dataList;
    private Context ctx;

    public RincianAdapter(ArrayList<ModelRincian> dataList) {
        this.dataList = dataList;
    }

    @Override
    public PiutangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_rincian, parent, false);
        ctx = parent.getContext();
        return new PiutangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PiutangViewHolder holder, int position) {
        holder.rincianListPeriode.setText(dataList.get(position).getPeriode());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ctx);
        adapter = new RincianItemAdapter(dataList.get(position).getRincianItems());
        holder.listRincianRecyclerview.setLayoutManager(layoutManager);
        holder.listRincianRecyclerview.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
//        return (dataList != null) ? dataList.size() : 0;
    }

    public class PiutangViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rincian_list_periode)
        TextView rincianListPeriode;
        @BindView(R.id.list_rincian_recyclerview)
        RecyclerView listRincianRecyclerview;

        public PiutangViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

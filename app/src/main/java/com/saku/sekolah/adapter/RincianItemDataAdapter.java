package com.saku.sekolah.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.saku.sekolah.R;
import com.saku.sekolah.model.keuangan.ModelRincianItemData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RincianItemDataAdapter extends RecyclerView.Adapter<RincianItemDataAdapter.RincianItemDataViewHolder> {

    private ArrayList<ModelRincianItemData> dataList;
    private Context ctx;

    public RincianItemDataAdapter(Context c) {
        ctx=c;
//        this.dataList = dataList;
    }

    @Override
    public RincianItemDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_rincian_item_data, parent, false);
//        ctx = parent.getContext();
        return new RincianItemDataViewHolder(view);
    }

    public void addData(ArrayList<ModelRincianItemData> items){
        dataList= items;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final RincianItemDataViewHolder holder, int position) {
        holder.listRincianItemKodeparam.setText(dataList.get(position).getKode_param());
        holder.listRincianItemNilai.setText(dataList.get(position).getSaldo());
    }

    @Override
    public int getItemCount() {
        return dataList.size();

//        return (dataList != null) ? dataList.size() : 0;
    }

    public class RincianItemDataViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_rincian_item_kodeparam)
        TextView listRincianItemKodeparam;
        @BindView(R.id.list_rincian_item_nilai)
        TextView listRincianItemNilai;
        public RincianItemDataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}

package com.saku.sekolah.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.saku.sekolah.R;
import com.saku.sekolah.preferences.LoadImage;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class CostumeAdapter extends ArrayAdapter<String> {
    String[] orangtua;
    String[] gambar;
    String[] email;
    String[] nohp;
    LoadImage loadImage;

    public CostumeAdapter(@NonNull Context context, String[] orangtua, String[] gambar, String[] email, String[] nohp) {
        super(context,R.layout.pengguna_items,orangtua);
        this.orangtua = orangtua;
        this.gambar = gambar;
        this.email = email;
        this.nohp = nohp;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.pengguna_items,null);
        TextView  item_orgtua = row.findViewById(R.id.pengguna_items_orangtua);
        TextView item_email = row.findViewById(R.id.pengguna_items_email);
        TextView item_nohp = row.findViewById(R.id.pengguna_items_notelp);
        CircleImageView avatar = row.findViewById(R.id.pengguna_items_profile);

        if(email[position] == "Tambah Akun"){
            item_email.setText(email[position]);
            item_email.setTextSize(18);
            avatar.setImageResource(R.drawable.ic_add_circle);
            item_nohp.setVisibility(View.INVISIBLE);
            item_orgtua.setVisibility(View.INVISIBLE);
        }else{
            item_orgtua.setText(orangtua[position]);
            item_email.setText(email[position]);
            item_nohp.setText(nohp[position]);
            loadImage = new LoadImage(avatar,gambar[position]);
        }

        return row;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.pengguna_items,null);
        TextView  item_orgtua = row.findViewById(R.id.pengguna_items_orangtua);
        TextView item_email = row.findViewById(R.id.pengguna_items_email);
        TextView item_nohp = row.findViewById(R.id.pengguna_items_notelp);
        CircleImageView avatar = row.findViewById(R.id.pengguna_items_profile);
        if(email[position] == "Tambah Akun"){
            item_email.setText(email[position]);
            avatar.setImageResource(R.drawable.ic_add_circle);
        }else{
            item_orgtua.setText(orangtua[position]);
            item_email.setText(email[position]);
            item_nohp.setText(nohp[position]);
            loadImage = new LoadImage(avatar,gambar[position]);
        }

        return row;
    }
}

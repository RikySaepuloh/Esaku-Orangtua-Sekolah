package com.saku.sekolah.preferences;

import android.util.Log;
import android.widget.ImageView;

import com.saku.sekolah.R;
import com.squareup.picasso.Picasso;

public class LoadImage {
    String imgURL = "http://saiweb.simkug.com/upload/";

    public LoadImage(ImageView iv, String url) {
        Picasso.get().load(imgURL + url).placeholder(R.drawable.img_loading)
                .error(R.drawable.no_image)
                .into(iv, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e("Error on ImageLoad:", e.toString());
                    }
                });
    }

//    public void LoadImageData(ImageView im, String url) {
//        Picasso.get().load(imgURL + url).placeholder(R.drawable.img_loading)
//                .error(R.drawable.no_image)
//                .into(im, new com.squareup.picasso.Callback() {
//                    @Override
//                    public void onSuccess() {
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        Log.e("Error on ImageLoad:", e.toString());
//                    }
//                });
//    }
}

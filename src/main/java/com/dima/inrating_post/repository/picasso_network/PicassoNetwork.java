package com.dima.inrating_post.repository.picasso_network;

import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class PicassoNetwork {
    public static void imageDownload(String url,ImageView image){
        Picasso.get().load(url).transform(new CropCircleTransformation()).into(image, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}

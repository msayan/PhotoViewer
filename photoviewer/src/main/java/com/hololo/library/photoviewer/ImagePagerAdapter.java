package com.hololo.library.photoviewer;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class ImagePagerAdapter<T> extends PagerAdapter {

    private ArrayList<T> list;
    private Picasso picasso;
    private int placeHolder = R.drawable.ic_image_black_24dp;

    public ImagePagerAdapter(ArrayList<T> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object item = list.get(position);
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo, container, false);

        TouchImageViewer imageViewer = view.findViewById(R.id.photo);
        container.addView(view);

        if (item instanceof Uri) {
            getPicasso(container.getContext()).load((Uri) item).fit().centerInside().placeholder(placeHolder).error(placeHolder).into(imageViewer);
        } else if (item instanceof File) {
            getPicasso(container.getContext()).load((File) item).fit().centerInside().placeholder(placeHolder).error(placeHolder).into(imageViewer);
        } else if (item instanceof String) {
            getPicasso(container.getContext()).load((String) item).fit().centerInside().placeholder(placeHolder).error(placeHolder).into(imageViewer);
        }


        return view;
    }

    private Picasso getPicasso(Context context) {
        if (picasso == null)
            picasso = new Picasso.Builder(context).build();

        return picasso;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setPlaceHolder(int placeHolder) {
        this.placeHolder = placeHolder;
    }
}

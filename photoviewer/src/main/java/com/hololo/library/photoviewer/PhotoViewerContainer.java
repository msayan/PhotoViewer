package com.hololo.library.photoviewer;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import java.io.File;
import java.util.ArrayList;

public class PhotoViewerContainer extends RelativeLayout {

    private ViewPager imageViewPager;
    private ArrayList<Uri> uri;
    private ArrayList<File> file;
    private ArrayList<String> url;
    private int position;

    public PhotoViewerContainer(Context context) {
        super(context);
        init();
    }

    public PhotoViewerContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PhotoViewerContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.photo_viewer, this);
        imageViewPager = findViewById(R.id.image_view_pager);
    }

    public void setUri(ArrayList<Uri> uri) {
        this.uri = uri;
        if (this.uri != null) {
            imageViewPager.setAdapter(new ImagePagerAdapter<>(uri));
        }
    }

    public void setFile(ArrayList<File> file) {
        this.file = file;
        if (this.file != null)
            imageViewPager.setAdapter(new ImagePagerAdapter<>(file));
    }

    public void setUrl(ArrayList<String> url) {
        this.url = url;
        if (this.url != null)
            imageViewPager.setAdapter(new ImagePagerAdapter<>(url));
    }

    public void setPosition(int position) {
        this.position = position;
        imageViewPager.setCurrentItem(position);
    }

    public void setPlaceHolder(int placeHolder) {
        ((ImagePagerAdapter) imageViewPager.getAdapter()).setPlaceHolder(placeHolder);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        imageViewPager.setOnPageChangeListener(listener);
    }
}

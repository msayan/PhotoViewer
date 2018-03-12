package com.hololo.library.photoviewer;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;

import java.io.File;
import java.util.ArrayList;

public class PhotoViewer {

    private Context context;
    private PhotoViewerContainer view;

    private PhotoViewer(Builder builder) {
        this.context = builder.context;
        view = new PhotoViewerContainer(builder.context);
        view.setUri(builder.uri);
        view.setFile(builder.file);
        view.setUrl(builder.url);
        view.setPosition(builder.position);
        view.setOnPageChangeListener(builder.pageListener);
        if (builder.placeHolder > -1)
            view.setPlaceHolder(builder.placeHolder);
    }

    public void show() {
        AlertDialog dialog = new AlertDialog.Builder(context, getDialogStyle())
                .setView(view)
                .setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        return false;
                    }
                })
                .create();
        dialog.show();
    }


    private @StyleRes
    int getDialogStyle() {
        return android.R.style.Theme_Translucent_NoTitleBar_Fullscreen;
    }


    /**
     * {@code PhotoViewer} builder static inner class.
     */
    public static final class Builder {
        private ArrayList<Uri> uri;
        private ArrayList<File> file;
        private ArrayList<String> url;
        private Context context;
        private int placeHolder = -1;
        private int position = 0;
        private ViewPager.OnPageChangeListener pageListener;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        /**
         * Sets the {@code uri} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code uri} to set
         * @return a reference to this Builder
         */
        public Builder uri(ArrayList<Uri> val) {
            uri = val;
            return this;
        }

        /**
         * Sets the {@code placeHolder} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code placeHolder} to set
         * @return a reference to this Builder
         */
        public Builder placeHolder(int val) {
            placeHolder = val;
            return this;
        }

        /**
         * Sets the {@code pageListener} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code pageListener} to set
         * @return a reference to this Builder
         */
        public Builder pageChangeListener(ViewPager.OnPageChangeListener val) {
            pageListener = val;
            return this;
        }

        /**
         * Sets the {@code position} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code position} to set
         * @return a reference to this Builder
         */
        public Builder position(int val) {
            position = val;
            return this;
        }

        /**
         * Sets the {@code file} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code file} to set
         * @return a reference to this Builder
         */
        public Builder file(ArrayList<File> val) {
            file = val;
            return this;
        }

        /**
         * Sets the {@code url} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param val the {@code url} to set
         * @return a reference to this Builder
         */
        public Builder url(ArrayList<String> val) {
            url = val;
            return this;
        }


        /**
         * Returns a {@code PhotoViewer} built from the parameters previously set.
         *
         * @return a {@code PhotoViewer} built with parameters of this {@code PhotoViewer.Builder}
         */
        public PhotoViewer build() {
            if (uri == null && file == null && url == null) {
                throw new IllegalArgumentException("For Showing the image you should fill Uri or File or Url.");
            }

            return new PhotoViewer(this);
        }
    }
}

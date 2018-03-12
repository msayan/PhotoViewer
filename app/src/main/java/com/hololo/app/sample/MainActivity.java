package com.hololo.app.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hololo.library.photoviewer.PhotoViewer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> images = new ArrayList<>();
        images.add("https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        images.add("https://www.telegraph.co.uk/content/dam/Travel/2017/April/view-stonehange.jpg?imwidth=1400");
        images.add("https://r.hswstatic.com/w_907/gif/10-breathtaking-views-1-622x415.jpg");
        images.add("https://images.pexels.com/photos/248797/pexels-photo-248797.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb");
        images.add("https://www.telegraph.co.uk/content/dam/Travel/2017/April/view-stonehange.jpg?imwidth=1400");
        images.add("https://r.hswstatic.com/w_907/gif/10-breathtaking-views-1-622x415.jpg");

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PhotoViewer.Builder(MainActivity.this)
                        .url(images)
                        .placeHolder(R.drawable.ic_launcher_background)
                        .position(2)
                        .build()
                        .show();
            }
        });

    }
}

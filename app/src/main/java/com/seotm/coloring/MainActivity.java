package com.seotm.coloring;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.seotm.coloringview.ColoringView;

public class MainActivity extends AppCompatActivity {

    private ColoringView coloringView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coloringView = (ColoringView) findViewById(R.id.coloringView);
        Drawable image = ContextCompat.getDrawable(this, R.drawable.girls);
        coloringView.setImage(image);
    }
}

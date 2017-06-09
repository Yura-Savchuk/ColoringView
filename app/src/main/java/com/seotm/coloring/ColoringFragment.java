package com.seotm.coloring;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seotm.coloringview.ColoringView;

/**
 * Created by seotm on 09.06.17.
 */

public class ColoringFragment extends Fragment {

    private ColoringView coloringView;
    private Bitmap coloringImage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.coloring_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupColoringView(view);
    }

    private void setupColoringView(View view) {
        coloringView = (ColoringView) view.findViewById(R.id.coloringView);
        if (coloringImage != null) {
            coloringView.setImageBitmap(coloringImage);
            return;
        }
        Drawable image = ContextCompat.getDrawable(getContext(), R.drawable.girls);
        coloringView.setImage(image);
    }

    @Override
    public void onDestroyView() {
        coloringImage = coloringView.getImageBitmap();
        super.onDestroyView();
    }

}

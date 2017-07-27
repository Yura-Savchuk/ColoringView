package com.seotm.coloringview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

/**
 * Created by seotm on 12.06.17.
 */

class SetupResources {

    private final Context context;
    private final AttributeSet attrs;
    private final int defStyleAttr;

    SetupResources(Context context, AttributeSet attrs, int defStyleAttr) {
        this.context = context;
        this.attrs = attrs;
        this.defStyleAttr = defStyleAttr;
    }

    void setup(@NonNull ColoringView view) {
        if (attrs == null) return;

        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ColoringView, defStyleAttr, 0);
        setImage(view, array);
        setPaintColor(view, array);
        setEnableColoringBlackColor(view, array);
        array.recycle();
    }

    private void setImage(@NonNull ColoringView view, TypedArray array) {
        Drawable image = array.getDrawable(R.styleable.ColoringView_imageSrc);
        if (image != null) view.drawImage.setImage(image);
    }

    private void setPaintColor(@NonNull ColoringView view, TypedArray array) {
        int defColor = ContextCompat.getColor(context, R.color.defaultPaintColor);
        view.paintColor = array.getColor(R.styleable.ColoringView_paintColor, defColor);
    }

    private void setEnableColoringBlackColor(@NonNull ColoringView view, TypedArray array) {
        view.enableColoringBlackColor = array.getBoolean(R.styleable.ColoringView_enableColoringBlackColor, true);
    }

}

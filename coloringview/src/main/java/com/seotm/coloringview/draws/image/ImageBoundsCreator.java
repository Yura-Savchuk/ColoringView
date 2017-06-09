package com.seotm.coloringview.draws.image;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/**
 * Created by seotm on 09.06.17.
 */

class ImageBoundsCreator {

    static Rect create(@NonNull Drawable image, int viewWidth, int viewHeight) {
        float imageWidth = image.getIntrinsicWidth();
        float imageHeight = image.getIntrinsicHeight();
        return getRect(viewWidth, viewHeight, imageWidth, imageHeight);
    }

    static Rect create(@NonNull Bitmap image, int viewWidth, int viewHeight) {
        float imageWidth = image.getWidth();
        float imageHeight = image.getHeight();
        return getRect(viewWidth, viewHeight, imageWidth, imageHeight);
    }

    @NonNull
    private static Rect getRect(int viewWidth, int viewHeight, float imageWidth, float imageHeight) {
        int left;
        int top;
        int right;
        int bottom;
        if (imageWidth > viewWidth || imageHeight > viewHeight) {
            float ratio = Math.min(viewWidth/imageWidth, viewHeight/imageHeight);
            left = (int) ((viewWidth - ratio*imageWidth)/2);
            top = (int) ((viewHeight - ratio*imageHeight)/2);
            right = viewWidth - left;
            bottom = viewHeight - top;
        } else {
            left = (int) ((viewWidth - imageWidth)/2);
            top = (int) ((viewHeight - imageHeight)/2);
            right = viewWidth - left;
            bottom = viewHeight - top;
        }
        return new Rect(left, top, right, bottom);
    }

}

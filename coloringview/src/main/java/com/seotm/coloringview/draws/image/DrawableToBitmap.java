package com.seotm.coloringview.draws.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

/**
 * Created by seotm on 09.06.17.
 */

public class DrawableToBitmap {

    private Drawable drawable;

    public DrawableToBitmap(Drawable drawable) {
        this.drawable = drawable;
    }

    public Bitmap convertToBitmap(@NonNull Rect bounds) {
        Bitmap bitmap = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }


}

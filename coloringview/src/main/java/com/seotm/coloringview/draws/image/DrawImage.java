package com.seotm.coloringview.draws.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

import com.seotm.coloringview.draws.DrawComponent;
import com.seotm.coloringview.draws.Position;

/**
 * Created by seotm on 09.06.17.
 */

public interface DrawImage extends DrawComponent {

    void setImage(@Nullable Drawable image);
    void setImage(@Nullable Bitmap image);
    void setStateImage(@Nullable Bitmap image);

    @Nullable
    Bitmap getImage();

    Position toBitmapPosition(int x, int y);

}

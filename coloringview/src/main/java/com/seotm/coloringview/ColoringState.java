package com.seotm.coloringview;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

/**
 * Created by seotm on 12.06.17.
 */

public class ColoringState {

    final Bitmap bitmap;

    ColoringState(@NonNull ColoringView view) {
        this.bitmap = view.drawImage.getImage();
    }

    void restoreState(@NonNull ColoringView view) {
        if (bitmap != null) {
            view.drawImage.setImage(bitmap);
        }
    }
}

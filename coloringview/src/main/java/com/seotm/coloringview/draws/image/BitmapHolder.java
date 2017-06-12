package com.seotm.coloringview.draws.image;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

/**
 * Created by seotm on 12.06.17.
 */

class BitmapHolder {

    final Bitmap bitmap;
    final boolean allowGrown;

    BitmapHolder(@NonNull Bitmap bitmap, boolean allowGrown) {
        this.bitmap = bitmap;
        this.allowGrown = allowGrown;
    }
}

package com.seotm.coloringview;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.seotm.coloringview.draws.Position;

/**
 * Created by seotm on 27.07.17.
 */

class ColorValidation {

    private static final int MAX_BLACK_TONE_COLOR = 0x22;

    private final boolean enableColoringBlackColor;

    ColorValidation(boolean enableColoringBlackColor) {
        this.enableColoringBlackColor = enableColoringBlackColor;
    }

    boolean isValidPosition(@NonNull Position position, @Nullable Bitmap image) {
        if (image == null || !position.valid) {
            return false;
        }

        if (enableColoringBlackColor) return true;

        int pixelColor = image.getPixel(position.x, position.y);
        int r = (pixelColor >> 16) & 0xFF;
        int g = (pixelColor >> 8) & 0xFF;
        int b = (pixelColor) & 0xFF;
        return r > MAX_BLACK_TONE_COLOR || g > MAX_BLACK_TONE_COLOR || b > MAX_BLACK_TONE_COLOR;
    }

}

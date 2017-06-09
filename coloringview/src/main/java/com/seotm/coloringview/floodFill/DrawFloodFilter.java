package com.seotm.coloringview.floodFill;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;

import com.seotm.coloringview.draws.Position;

/**
 * Created by seotm on 09.06.17.
 */

public class DrawFloodFilter {

    private static final int TOLERANCE = 200;

    private final Position position;

    public DrawFloodFilter(@NonNull Position position) {
        this.position = position;
    }

    public void draw(int newColor, @NonNull Bitmap bitmap) {
        if (!position.valid) return;
        int targetColor = getTargetColor(bitmap);
        QueueLinearFloodFiller floodFiller = new QueueLinearFloodFiller(bitmap, targetColor, newColor);
        floodFiller.setTolerance(TOLERANCE);
        floodFiller.floodFill(position.x, position.y);
    }

    private int getTargetColor(@NonNull Bitmap bitmap) {
        int pixel = bitmap.getPixel(position.x, position.y);
        int redValue = Color.red(pixel);
        int blueValue = Color.blue(pixel);
        int greenValue = Color.green(pixel);
        return Color.rgb(redValue, greenValue, blueValue);
    }

}

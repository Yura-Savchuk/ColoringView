package com.seotm.coloringview.draws.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.seotm.coloringview.draws.Position;
import com.seotm.coloringview.draws.ViewSize;

/**
 * Created by seotm on 08.06.17.
 */

public class DrawImageImpl implements DrawImage {

    Drawable drawableImg;
    Bitmap bitmapImg;
    Rect bounds;
    private final ViewSize viewSize = new ViewSize();

    @Override
    public void setImage(@Nullable Drawable image) {
        this.drawableImg = image;
        setupImageBounds();
    }

    private void setupImageBounds() {
        SetupImageBounds setupBounds = new SetupImageBounds(this);
        setupBounds.setupImageBounds(viewSize);
    }

    @Override
    public void setImage(@NonNull Bitmap image) {
        this.bitmapImg = image;
        drawableImg = null;
        setupImageBounds();
    }

    @Nullable
    @Override
    public Bitmap getImage() {
        return bitmapImg;
    }

    @Override
    public Position toBitmapPosition(int x, int y) {
        if (bitmapImg == null) return Position.invalid();

        int imageX = x - bounds.left;
        int imageY = y - bounds.top;
        if (imageX > bounds.width() || imageY > bounds.height()) {
            return Position.invalid();
        }

        return new  Position(imageX, imageY);
    }

    @Override
    public void updateSize(int w, int h, int oldw, int oldh) {
        viewSize.setSize(w, h);
        setupImageBounds();
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        if (bitmapImg != null && bounds != null) {
            canvas.drawBitmap(bitmapImg, bounds.left, bounds.top, null);
        }
    }

}

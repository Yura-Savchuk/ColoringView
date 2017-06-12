package com.seotm.coloringview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.seotm.coloringview.draws.Position;
import com.seotm.coloringview.draws.image.DrawImage;
import com.seotm.coloringview.draws.image.DrawImageImpl;
import com.seotm.coloringview.floodFill.DrawFloodFilter;

/**
 * Created by seotm on 08.06.17.
 */

public class ColoringView extends View {

    final DrawImage drawImage;

    public ColoringView(Context context) {
        this(context, null);
    }

    public ColoringView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColoringView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        drawImage = new DrawImageImpl();
        new SetupResources(context, attrs, defStyleAttr).setup(this);
    }

    public void setImage(@Nullable Drawable image) {
        drawImage.setImage(image);
    }

    public void setState(@Nullable ColoringState state) {
        if (state != null) {
            state.restoreState(this);
        }
    }

    public ColoringState getState() {
        return new ColoringState(this);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        drawImage.updateSize(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawImage.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            Position bitmapPosition = drawImage.toBitmapPosition(x, y);
            Bitmap image = drawImage.getImage();
            new DrawFloodFilter(bitmapPosition).draw(Color.RED, image);
            invalidate();
        }
        return true;
    }
}

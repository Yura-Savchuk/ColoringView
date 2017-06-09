package com.seotm.coloringview.draws;

/**
 * Created by seotm on 09.06.17.
 */

public class ViewSize {

    private int width;
    private int height;
    private boolean established = false;

    public ViewSize() {
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        established = true;
    }

    public boolean isEstablished() {
        return established;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

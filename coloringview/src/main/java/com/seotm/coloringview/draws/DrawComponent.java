package com.seotm.coloringview.draws;

import android.graphics.Canvas;
import android.support.annotation.NonNull;

/**
 * Created by seotm on 08.06.17.
 */

public interface DrawComponent {

    void updateSize(int w, int h, int oldw, int oldh);
    void draw(@NonNull Canvas canvas);

}

package com.seotm.coloringview.draws;

/**
 * Created by seotm on 09.06.17.
 */

public class Position {

    public final int x;
    public final int y;
    public final boolean valid;

    public Position(int x, int y) {
        this(x, y, true);
    }

    private Position(int x, int y, boolean valid) {
        this.x = x;
        this.y = y;
        this.valid = valid;
    }

    public static Position invalid() {
        return new Position(-1, -1, false);
    }

}

package com.badlogic.gdx;

import com.badlogic.gdx.utils.IntSet;

public abstract class AbstractInput implements Input {
    public final boolean[] justPressedKeys = new boolean[256];
    public boolean keyJustPressed;
    public final IntSet keysToCatch = new IntSet();
    public int pressedKeyCount;
    public final boolean[] pressedKeys = new boolean[256];

    public boolean isCatchKey(int i) {
        IntSet intSet = this.keysToCatch;
        if (i == 0) {
            return intSet.hasZeroValue;
        }
        return intSet.locateKey(i) >= 0;
    }
}

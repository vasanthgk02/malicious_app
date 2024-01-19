package com.badlogic.gdx.backends.android;

public interface AndroidWallpaperListener {
    void iconDropped(int i, int i2);

    void offsetChange(float f2, float f3, float f4, float f5, int i, int i2);

    void previewStateChange(boolean z);
}

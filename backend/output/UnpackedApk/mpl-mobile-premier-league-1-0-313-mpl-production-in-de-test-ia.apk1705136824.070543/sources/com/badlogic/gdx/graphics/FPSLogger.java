package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.backends.android.AndroidGraphics;

public class FPSLogger {
    public int bound;
    public long startTime;

    public FPSLogger() {
        this(Integer.MAX_VALUE);
    }

    public void log() {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.startTime > 1000000000) {
            int i = ((AndroidGraphics) k.graphics).fps;
            if (i < this.bound) {
                Application application = k.app;
                application.log("FPSLogger", "fps: " + i);
                this.startTime = nanoTime;
            }
        }
    }

    public FPSLogger(int i) {
        this.bound = i;
        this.startTime = System.nanoTime();
    }
}

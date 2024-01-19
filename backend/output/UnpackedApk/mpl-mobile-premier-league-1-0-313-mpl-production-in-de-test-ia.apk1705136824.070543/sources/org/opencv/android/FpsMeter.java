package org.opencv.android;

import android.graphics.Paint;
import java.text.DecimalFormat;

public class FpsMeter {
    public static final DecimalFormat FPS_FORMAT = new DecimalFormat("0.00");
    public int mFramesCouner;
    public double mFrequency;
    public int mHeight = 0;
    public boolean mIsInitialized = false;
    public Paint mPaint;
    public String mStrfps;
    public int mWidth = 0;
    public long mprevFrameTime;
}

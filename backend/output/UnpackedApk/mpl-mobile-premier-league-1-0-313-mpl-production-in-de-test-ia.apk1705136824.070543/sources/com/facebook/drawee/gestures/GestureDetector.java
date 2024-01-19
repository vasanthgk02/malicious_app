package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.ViewConfiguration;

public class GestureDetector {
    public long mActionDownTime;
    public float mActionDownX;
    public float mActionDownY;
    public ClickListener mClickListener = null;
    public boolean mIsCapturingGesture = false;
    public boolean mIsClickCandidate = false;
    public final float mSingleTapSlopPx;

    public interface ClickListener {
    }

    public GestureDetector(Context context) {
        this.mSingleTapSlopPx = (float) ViewConfiguration.get(context).getScaledTouchSlop();
    }
}

package com.facebook.react.views.progressbar;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

public class ProgressBarContainerView extends FrameLayout {
    public boolean mAnimating = true;
    public Integer mColor;
    public boolean mIndeterminate = true;
    public double mProgress;
    public ProgressBar mProgressBar;

    public ProgressBarContainerView(Context context) {
        super(context);
    }
}

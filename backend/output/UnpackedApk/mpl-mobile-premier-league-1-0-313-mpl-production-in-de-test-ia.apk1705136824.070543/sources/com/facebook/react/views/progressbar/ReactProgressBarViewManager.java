package com.facebook.react.views.progressbar;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerDelegate;
import com.mpl.androidapp.miniprofile.ct.C.SegmentationChapterSelectionFromChapterList;

@ReactModule(name = "AndroidProgressBar")
public class ReactProgressBarViewManager extends BaseViewManager<ProgressBarContainerView, ProgressBarShadowNode> {
    public static final String DEFAULT_STYLE = "Normal";
    public static final String PROP_ANIMATING = "animating";
    public static final String PROP_INDETERMINATE = "indeterminate";
    public static final String PROP_PROGRESS = "progress";
    public static final String PROP_STYLE = "styleAttr";
    public static final String REACT_CLASS = "AndroidProgressBar";
    public static Object sProgressBarCtorLock = new Object();
    public final ViewManagerDelegate<ProgressBarContainerView> mDelegate = new AndroidProgressBarManagerDelegate(this);

    public static ProgressBar createProgressBar(Context context, int i) {
        ProgressBar progressBar;
        synchronized (sProgressBarCtorLock) {
            progressBar = new ProgressBar(context, null, i);
        }
        return progressBar;
    }

    public static int getStyleFromString(String str) {
        if (str == null) {
            throw new JSApplicationIllegalArgumentException("ProgressBar needs to have a style, null received");
        } else if (str.equals(SegmentationChapterSelectionFromChapterList.HORIZONTAL)) {
            return 16842872;
        } else {
            if (str.equals("Small")) {
                return 16842873;
            }
            if (str.equals("Large")) {
                return 16842874;
            }
            if (str.equals("Inverse")) {
                return 16843399;
            }
            if (str.equals("SmallInverse")) {
                return 16843400;
            }
            if (str.equals("LargeInverse")) {
                return 16843401;
            }
            if (str.equals("Normal")) {
                return 16842871;
            }
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Unknown ProgressBar style: ", str));
        }
    }

    public ViewManagerDelegate<ProgressBarContainerView> getDelegate() {
        return this.mDelegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<ProgressBarShadowNode> getShadowNodeClass() {
        return ProgressBarShadowNode.class;
    }

    public void setTypeAttr(ProgressBarContainerView progressBarContainerView, String str) {
    }

    public void updateExtraData(ProgressBarContainerView progressBarContainerView, Object obj) {
    }

    public ProgressBarShadowNode createShadowNodeInstance() {
        return new ProgressBarShadowNode();
    }

    public ProgressBarContainerView createViewInstance(ThemedReactContext themedReactContext) {
        return new ProgressBarContainerView(themedReactContext);
    }

    public void onAfterUpdateTransaction(ProgressBarContainerView progressBarContainerView) {
        Drawable drawable;
        ProgressBar progressBar = progressBarContainerView.mProgressBar;
        if (progressBar != null) {
            progressBar.setIndeterminate(progressBarContainerView.mIndeterminate);
            ProgressBar progressBar2 = progressBarContainerView.mProgressBar;
            if (progressBar2.isIndeterminate()) {
                drawable = progressBar2.getIndeterminateDrawable();
            } else {
                drawable = progressBar2.getProgressDrawable();
            }
            if (drawable != null) {
                Integer num = progressBarContainerView.mColor;
                if (num != null) {
                    drawable.setColorFilter(num.intValue(), Mode.SRC_IN);
                } else {
                    drawable.clearColorFilter();
                }
            }
            progressBarContainerView.mProgressBar.setProgress((int) (progressBarContainerView.mProgress * 1000.0d));
            if (progressBarContainerView.mAnimating) {
                progressBarContainerView.mProgressBar.setVisibility(0);
            } else {
                progressBarContainerView.mProgressBar.setVisibility(4);
            }
        } else {
            throw new JSApplicationIllegalArgumentException("setStyle() not called");
        }
    }

    @ReactProp(name = "animating")
    public void setAnimating(ProgressBarContainerView progressBarContainerView, boolean z) {
        progressBarContainerView.mAnimating = z;
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ProgressBarContainerView progressBarContainerView, Integer num) {
        progressBarContainerView.mColor = num;
    }

    @ReactProp(name = "indeterminate")
    public void setIndeterminate(ProgressBarContainerView progressBarContainerView, boolean z) {
        progressBarContainerView.mIndeterminate = z;
    }

    @ReactProp(name = "progress")
    public void setProgress(ProgressBarContainerView progressBarContainerView, double d2) {
        progressBarContainerView.mProgress = d2;
    }

    @ReactProp(name = "styleAttr")
    public void setStyleAttr(ProgressBarContainerView progressBarContainerView, String str) {
        if (progressBarContainerView != null) {
            ProgressBar createProgressBar = createProgressBar(progressBarContainerView.getContext(), getStyleFromString(str));
            progressBarContainerView.mProgressBar = createProgressBar;
            createProgressBar.setMax(1000);
            progressBarContainerView.removeAllViews();
            progressBarContainerView.addView(progressBarContainerView.mProgressBar, new LayoutParams(-1, -1));
            return;
        }
        throw null;
    }

    public void setTestID(ProgressBarContainerView progressBarContainerView, String str) {
        super.setTestId(progressBarContainerView, str);
    }
}

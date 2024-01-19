package com.mpl.androidapp;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import com.facebook.react.ReactRootView;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;

public class MPLReactRootView extends ReactRootView {
    public static final String TAG = "MPLReactRootView";
    public boolean isKeyBoardOpen;
    public OverlayDetectionListener overlayDetectionListener;

    public interface OverlayDetectionListener {
        void onOverlayDetected();
    }

    public MPLReactRootView(Context context) {
        super(context);
        boolean isOverlayDetectionRequiredInReact = MSharedPreferencesUtils.isOverlayDetectionRequiredInReact();
        if (isOverlayDetectionRequiredInReact) {
            setFilterTouchesWhenObscured(isOverlayDetectionRequiredInReact);
        }
        if (context instanceof OverlayDetectionListener) {
            this.overlayDetectionListener = (OverlayDetectionListener) context;
        }
    }

    public boolean isKeyBoardOpen() {
        return this.isKeyBoardOpen;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        boolean isOverlayDetectionRequiredInReact = MSharedPreferencesUtils.isOverlayDetectionRequiredInReact();
        if (isOverlayDetectionRequiredInReact) {
            setFilterTouchesWhenObscured(isOverlayDetectionRequiredInReact);
        }
        MLogger.d(TAG, "onAttachedToWindow: ", Boolean.valueOf(isOverlayDetectionRequiredInReact));
    }

    public boolean onFilterTouchEventForSecurity(MotionEvent motionEvent) {
        boolean isOverlayDetectionRequiredInReact = MSharedPreferencesUtils.isOverlayDetectionRequiredInReact();
        MLogger.d(TAG, "onFilterTouchEventForSecurity: ", motionEvent);
        MLogger.d(TAG, "onFilterTouchEventForSecurity: ", Boolean.valueOf(isOverlayDetectionRequiredInReact));
        MLogger.d(TAG, "onFilterTouchEventForSecurity: ", Integer.valueOf(motionEvent.getToolType(0)));
        MLogger.d(TAG, "onFilterTouchEventForSecurity: ", Integer.valueOf(motionEvent.getSource()));
        if (VERSION.SDK_INT >= 23) {
            MLogger.d(TAG, "onFilterTouchEventForSecurity: ", Integer.valueOf(motionEvent.getActionButton()));
        }
        if (isOverlayDetectionRequiredInReact && !isKeyBoardOpen()) {
            if ((motionEvent.getFlags() & 1) == 1 || (motionEvent.getFlags() & 2) == 2) {
                OverlayDetectionListener overlayDetectionListener2 = this.overlayDetectionListener;
                if (overlayDetectionListener2 != null) {
                    overlayDetectionListener2.onOverlayDetected();
                }
                MLogger.d(TAG, "onFilterTouchEventForSecurity: overlay detected 1");
                return false;
            } else if (motionEvent.getDeviceId() == 0) {
                OverlayDetectionListener overlayDetectionListener3 = this.overlayDetectionListener;
                if (overlayDetectionListener3 != null) {
                    overlayDetectionListener3.onOverlayDetected();
                }
                MLogger.d(TAG, "onFilterTouchEventForSecurity: overlay detected 2");
                return false;
            } else if (motionEvent.getToolType(0) == 0) {
                OverlayDetectionListener overlayDetectionListener4 = this.overlayDetectionListener;
                if (overlayDetectionListener4 != null) {
                    overlayDetectionListener4.onOverlayDetected();
                }
                MLogger.d(TAG, "onFilterTouchEventForSecurity: overlay detected 3");
                return false;
            }
        }
        return super.onFilterTouchEventForSecurity(motionEvent);
    }

    public void setKeyBoardOpen(boolean z) {
        this.isKeyBoardOpen = z;
    }
}

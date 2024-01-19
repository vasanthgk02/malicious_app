package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$bool;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.customviews.CloseImageView;
import java.lang.ref.WeakReference;

public abstract class CTInAppBaseFullFragment extends CTInAppBaseFragment {
    public void addCloseImageView(final RelativeLayout relativeLayout, final CloseImageView closeImageView) {
        new Handler().post(new Runnable() {
            public void run() {
                int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                closeImageView.setX((float) (relativeLayout.getRight() - measuredWidth));
                closeImageView.setY((float) (relativeLayout.getTop() - measuredWidth));
            }
        });
    }

    public void cleanup() {
    }

    public void generateListener() {
        Context context = this.context;
        if (context instanceof InAppNotificationActivity) {
            this.listenerWeakReference = new WeakReference<>((InAppListener) context);
        }
    }

    public boolean isTablet() {
        if (Utils.isActivityDead(getActivity())) {
            return false;
        }
        try {
            return getResources().getBoolean(R$bool.ctIsTablet);
        } catch (Exception e2) {
            Logger.d("Failed to decide whether device is a smart phone or tablet!");
            e2.printStackTrace();
            return false;
        }
    }

    public void redrawHalfInterstitialInApp(RelativeLayout relativeLayout, LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.height = (int) (((float) relativeLayout.getMeasuredWidth()) * 1.3f);
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public void redrawHalfInterstitialMobileInAppOnTablet(RelativeLayout relativeLayout, LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.setMargins(getScaledPixels(140), getScaledPixels(140), getScaledPixels(140), getScaledPixels(140));
        int measuredWidth = relativeLayout.getMeasuredWidth() - getScaledPixels(210);
        layoutParams.width = measuredWidth;
        layoutParams.height = (int) (((float) measuredWidth) * 1.3f);
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public void redrawInterstitialMobileInAppOnTablet(RelativeLayout relativeLayout, LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredWidth = (int) (((float) (relativeLayout.getMeasuredWidth() - getScaledPixels(200))) * 1.78f);
        int measuredHeight = frameLayout.getMeasuredHeight() - getScaledPixels(280);
        if (measuredWidth > measuredHeight) {
            layoutParams.height = measuredHeight;
            layoutParams.width = (int) (((float) measuredHeight) / 1.78f);
        } else {
            layoutParams.height = measuredWidth;
            layoutParams.width = relativeLayout.getMeasuredWidth() - getScaledPixels(200);
        }
        layoutParams.setMargins(getScaledPixels(140), getScaledPixels(140), getScaledPixels(140), getScaledPixels(140));
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public void redrawInterstitialTabletInApp(RelativeLayout relativeLayout, LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredWidth = (int) (((float) relativeLayout.getMeasuredWidth()) * 1.78f);
        int measuredHeight = frameLayout.getMeasuredHeight() - getScaledPixels(80);
        if (measuredWidth > measuredHeight) {
            layoutParams.height = measuredHeight;
            layoutParams.width = (int) (((float) measuredHeight) / 1.78f);
        } else {
            layoutParams.height = measuredWidth;
        }
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public void redrawLandscapeInterstitialInApp(RelativeLayout relativeLayout, LayoutParams layoutParams, CloseImageView closeImageView) {
        layoutParams.width = (int) (((float) relativeLayout.getMeasuredHeight()) * 1.78f);
        layoutParams.gravity = 1;
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public void redrawLandscapeInterstitialMobileInAppOnTablet(RelativeLayout relativeLayout, LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredHeight = (int) (((float) (relativeLayout.getMeasuredHeight() - getScaledPixels(120))) * 1.78f);
        int measuredWidth = frameLayout.getMeasuredWidth() - getScaledPixels(280);
        if (measuredHeight > measuredWidth) {
            layoutParams.width = measuredWidth;
            layoutParams.height = (int) (((float) measuredWidth) / 1.78f);
        } else {
            layoutParams.width = measuredHeight;
            layoutParams.height = relativeLayout.getMeasuredHeight() - getScaledPixels(120);
        }
        layoutParams.setMargins(getScaledPixels(140), getScaledPixels(100), getScaledPixels(140), getScaledPixels(100));
        layoutParams.gravity = 17;
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public void redrawLandscapeInterstitialTabletInApp(RelativeLayout relativeLayout, LayoutParams layoutParams, FrameLayout frameLayout, CloseImageView closeImageView) {
        int measuredHeight = (int) (((float) relativeLayout.getMeasuredHeight()) * 1.78f);
        int measuredWidth = frameLayout.getMeasuredWidth() - getScaledPixels(80);
        if (measuredHeight > measuredWidth) {
            layoutParams.width = measuredWidth;
            layoutParams.height = (int) (((float) measuredWidth) / 1.78f);
        } else {
            layoutParams.width = measuredHeight;
        }
        layoutParams.gravity = 17;
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }
}

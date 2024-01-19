package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppBaseFragment.CTInAppNativeButtonClickListener;

public class CTInAppNativeInterstitialImageFragment extends CTInAppBaseFullFragment {
    public RelativeLayout relativeLayout;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (!this.inAppNotification.isTablet || !isTablet()) {
            view = layoutInflater.inflate(R$layout.inapp_interstitial_image, viewGroup, false);
        } else {
            view = layoutInflater.inflate(R$layout.tab_inapp_interstitial_image, viewGroup, false);
        }
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.inapp_interstitial_image_frame_layout);
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        RelativeLayout relativeLayout2 = (RelativeLayout) frameLayout.findViewById(R$id.interstitial_image_relative_layout);
        this.relativeLayout = relativeLayout2;
        relativeLayout2.setBackgroundColor(Color.parseColor(this.inAppNotification.backgroundColor));
        ImageView imageView = (ImageView) this.relativeLayout.findViewById(R$id.interstitial_image);
        int i = this.currentOrientation;
        if (i == 1) {
            this.relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    LayoutParams layoutParams = (LayoutParams) CTInAppNativeInterstitialImageFragment.this.relativeLayout.getLayoutParams();
                    CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment = CTInAppNativeInterstitialImageFragment.this;
                    if (cTInAppNativeInterstitialImageFragment.inAppNotification.isTablet && cTInAppNativeInterstitialImageFragment.isTablet()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment2 = CTInAppNativeInterstitialImageFragment.this;
                        cTInAppNativeInterstitialImageFragment2.redrawInterstitialTabletInApp(cTInAppNativeInterstitialImageFragment2.relativeLayout, layoutParams, frameLayout, closeImageView);
                    } else if (CTInAppNativeInterstitialImageFragment.this.isTablet()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment3 = CTInAppNativeInterstitialImageFragment.this;
                        cTInAppNativeInterstitialImageFragment3.redrawInterstitialMobileInAppOnTablet(cTInAppNativeInterstitialImageFragment3.relativeLayout, layoutParams, frameLayout, closeImageView);
                    } else {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment4 = CTInAppNativeInterstitialImageFragment.this;
                        RelativeLayout relativeLayout = cTInAppNativeInterstitialImageFragment4.relativeLayout;
                        CloseImageView closeImageView = closeImageView;
                        layoutParams.height = (int) (((float) relativeLayout.getMeasuredWidth()) * 1.78f);
                        relativeLayout.setLayoutParams(layoutParams);
                        cTInAppNativeInterstitialImageFragment4.addCloseImageView(relativeLayout, closeImageView);
                    }
                    CTInAppNativeInterstitialImageFragment.this.relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else if (i == 2) {
            this.relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    LayoutParams layoutParams = (LayoutParams) CTInAppNativeInterstitialImageFragment.this.relativeLayout.getLayoutParams();
                    CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment = CTInAppNativeInterstitialImageFragment.this;
                    if (cTInAppNativeInterstitialImageFragment.inAppNotification.isTablet && cTInAppNativeInterstitialImageFragment.isTablet()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment2 = CTInAppNativeInterstitialImageFragment.this;
                        cTInAppNativeInterstitialImageFragment2.redrawLandscapeInterstitialTabletInApp(cTInAppNativeInterstitialImageFragment2.relativeLayout, layoutParams, frameLayout, closeImageView);
                    } else if (CTInAppNativeInterstitialImageFragment.this.isTablet()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment3 = CTInAppNativeInterstitialImageFragment.this;
                        cTInAppNativeInterstitialImageFragment3.redrawLandscapeInterstitialMobileInAppOnTablet(cTInAppNativeInterstitialImageFragment3.relativeLayout, layoutParams, frameLayout, closeImageView);
                    } else {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment4 = CTInAppNativeInterstitialImageFragment.this;
                        cTInAppNativeInterstitialImageFragment4.redrawLandscapeInterstitialInApp(cTInAppNativeInterstitialImageFragment4.relativeLayout, layoutParams, closeImageView);
                    }
                    CTInAppNativeInterstitialImageFragment.this.relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
        if (this.inAppNotification.getInAppMediaForOrientation(this.currentOrientation) != null) {
            CTInAppNotification cTInAppNotification = this.inAppNotification;
            if (cTInAppNotification.getImage(cTInAppNotification.getInAppMediaForOrientation(this.currentOrientation)) != null) {
                CTInAppNotification cTInAppNotification2 = this.inAppNotification;
                imageView.setImageBitmap(cTInAppNotification2.getImage(cTInAppNotification2.getInAppMediaForOrientation(this.currentOrientation)));
                imageView.setTag(Integer.valueOf(0));
                imageView.setOnClickListener(new CTInAppNativeButtonClickListener());
            }
        }
        closeImageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CTInAppNativeInterstitialImageFragment.this.didDismiss(null);
                CTInAppNativeInterstitialImageFragment.this.getActivity().finish();
            }
        });
        if (!this.inAppNotification.hideCloseButton) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return view;
    }
}

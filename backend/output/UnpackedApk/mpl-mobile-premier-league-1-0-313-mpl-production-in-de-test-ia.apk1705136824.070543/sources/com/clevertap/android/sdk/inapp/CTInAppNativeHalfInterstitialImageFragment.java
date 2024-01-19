package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
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

public class CTInAppNativeHalfInterstitialImageFragment extends CTInAppBaseFullFragment {
    public RelativeLayout relativeLayout;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        if (!this.inAppNotification.isTablet || !isTablet()) {
            view = layoutInflater.inflate(R$layout.inapp_half_interstitial_image, viewGroup, false);
        } else {
            view = layoutInflater.inflate(R$layout.tab_inapp_half_interstitial_image, viewGroup, false);
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.inapp_half_interstitial_image_frame_layout);
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        RelativeLayout relativeLayout2 = (RelativeLayout) frameLayout.findViewById(R$id.half_interstitial_image_relative_layout);
        this.relativeLayout = relativeLayout2;
        relativeLayout2.setBackgroundColor(Color.parseColor(this.inAppNotification.backgroundColor));
        ImageView imageView = (ImageView) this.relativeLayout.findViewById(R$id.half_interstitial_image);
        int i = this.currentOrientation;
        if (i == 1) {
            this.relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    LayoutParams layoutParams = (LayoutParams) CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getLayoutParams();
                    CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment = CTInAppNativeHalfInterstitialImageFragment.this;
                    if (cTInAppNativeHalfInterstitialImageFragment.inAppNotification.isTablet && cTInAppNativeHalfInterstitialImageFragment.isTablet()) {
                        CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment2 = CTInAppNativeHalfInterstitialImageFragment.this;
                        cTInAppNativeHalfInterstitialImageFragment2.redrawHalfInterstitialInApp(cTInAppNativeHalfInterstitialImageFragment2.relativeLayout, layoutParams, closeImageView);
                    } else if (CTInAppNativeHalfInterstitialImageFragment.this.isTablet()) {
                        CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment3 = CTInAppNativeHalfInterstitialImageFragment.this;
                        cTInAppNativeHalfInterstitialImageFragment3.redrawHalfInterstitialMobileInAppOnTablet(cTInAppNativeHalfInterstitialImageFragment3.relativeLayout, layoutParams, closeImageView);
                    } else {
                        CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment4 = CTInAppNativeHalfInterstitialImageFragment.this;
                        cTInAppNativeHalfInterstitialImageFragment4.redrawHalfInterstitialInApp(cTInAppNativeHalfInterstitialImageFragment4.relativeLayout, layoutParams, closeImageView);
                    }
                    CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else if (i == 2) {
            this.relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    LayoutParams layoutParams = (LayoutParams) CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getLayoutParams();
                    CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment = CTInAppNativeHalfInterstitialImageFragment.this;
                    if (cTInAppNativeHalfInterstitialImageFragment.inAppNotification.isTablet && cTInAppNativeHalfInterstitialImageFragment.isTablet()) {
                        layoutParams.width = (int) (((float) CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getMeasuredHeight()) * 1.3f);
                        layoutParams.gravity = 17;
                        CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.setLayoutParams(layoutParams);
                        new Handler().post(new Runnable() {
                            public void run() {
                                int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                AnonymousClass2 r1 = AnonymousClass2.this;
                                closeImageView.setX((float) (CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getRight() - measuredWidth));
                                AnonymousClass2 r12 = AnonymousClass2.this;
                                closeImageView.setY((float) (CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getTop() - measuredWidth));
                            }
                        });
                    } else if (CTInAppNativeHalfInterstitialImageFragment.this.isTablet()) {
                        layoutParams.setMargins(CTInAppNativeHalfInterstitialImageFragment.this.getScaledPixels(140), CTInAppNativeHalfInterstitialImageFragment.this.getScaledPixels(100), CTInAppNativeHalfInterstitialImageFragment.this.getScaledPixels(140), CTInAppNativeHalfInterstitialImageFragment.this.getScaledPixels(100));
                        int measuredHeight = CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getMeasuredHeight() - CTInAppNativeHalfInterstitialImageFragment.this.getScaledPixels(130);
                        layoutParams.height = measuredHeight;
                        layoutParams.width = (int) (((float) measuredHeight) * 1.3f);
                        layoutParams.gravity = 17;
                        CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.setLayoutParams(layoutParams);
                        new Handler().post(new Runnable() {
                            public void run() {
                                int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                AnonymousClass2 r1 = AnonymousClass2.this;
                                closeImageView.setX((float) (CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getRight() - measuredWidth));
                                AnonymousClass2 r12 = AnonymousClass2.this;
                                closeImageView.setY((float) (CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getTop() - measuredWidth));
                            }
                        });
                    } else {
                        layoutParams.width = (int) (((float) CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getMeasuredHeight()) * 1.3f);
                        layoutParams.gravity = 1;
                        CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.setLayoutParams(layoutParams);
                        new Handler().post(new Runnable() {
                            public void run() {
                                int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                AnonymousClass2 r1 = AnonymousClass2.this;
                                closeImageView.setX((float) (CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getRight() - measuredWidth));
                                AnonymousClass2 r12 = AnonymousClass2.this;
                                closeImageView.setY((float) (CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getTop() - measuredWidth));
                            }
                        });
                    }
                    CTInAppNativeHalfInterstitialImageFragment.this.relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
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
                CTInAppNativeHalfInterstitialImageFragment.this.didDismiss(null);
                CTInAppNativeHalfInterstitialImageFragment.this.getActivity().finish();
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

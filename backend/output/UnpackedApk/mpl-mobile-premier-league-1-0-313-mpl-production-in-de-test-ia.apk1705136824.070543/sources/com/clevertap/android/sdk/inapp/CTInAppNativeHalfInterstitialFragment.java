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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import java.util.ArrayList;

public class CTInAppNativeHalfInterstitialFragment extends CTInAppBaseFullNativeFragment {
    public RelativeLayout relativeLayout;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        ArrayList arrayList = new ArrayList();
        if (!this.inAppNotification.isTablet || !isTablet()) {
            view = layoutInflater.inflate(R$layout.inapp_half_interstitial, viewGroup, false);
        } else {
            view = layoutInflater.inflate(R$layout.tab_inapp_half_interstitial, viewGroup, false);
        }
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.inapp_half_interstitial_frame_layout);
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        RelativeLayout relativeLayout2 = (RelativeLayout) frameLayout.findViewById(R$id.half_interstitial_relative_layout);
        this.relativeLayout = relativeLayout2;
        relativeLayout2.setBackgroundColor(Color.parseColor(this.inAppNotification.backgroundColor));
        int i = this.currentOrientation;
        if (i == 1) {
            this.relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    LayoutParams layoutParams = (LayoutParams) CTInAppNativeHalfInterstitialFragment.this.relativeLayout.getLayoutParams();
                    CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment = CTInAppNativeHalfInterstitialFragment.this;
                    if (cTInAppNativeHalfInterstitialFragment.inAppNotification.isTablet && cTInAppNativeHalfInterstitialFragment.isTablet()) {
                        CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment2 = CTInAppNativeHalfInterstitialFragment.this;
                        cTInAppNativeHalfInterstitialFragment2.redrawHalfInterstitialInApp(cTInAppNativeHalfInterstitialFragment2.relativeLayout, layoutParams, closeImageView);
                    } else if (CTInAppNativeHalfInterstitialFragment.this.isTablet()) {
                        CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment3 = CTInAppNativeHalfInterstitialFragment.this;
                        cTInAppNativeHalfInterstitialFragment3.redrawHalfInterstitialMobileInAppOnTablet(cTInAppNativeHalfInterstitialFragment3.relativeLayout, layoutParams, closeImageView);
                    } else {
                        CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment4 = CTInAppNativeHalfInterstitialFragment.this;
                        cTInAppNativeHalfInterstitialFragment4.redrawHalfInterstitialInApp(cTInAppNativeHalfInterstitialFragment4.relativeLayout, layoutParams, closeImageView);
                    }
                    CTInAppNativeHalfInterstitialFragment.this.relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else if (i == 2) {
            this.relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R$id.half_interstitial_relative_layout);
                    LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
                    CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment = CTInAppNativeHalfInterstitialFragment.this;
                    if (cTInAppNativeHalfInterstitialFragment.inAppNotification.isTablet && cTInAppNativeHalfInterstitialFragment.isTablet()) {
                        layoutParams.width = (int) (((float) relativeLayout.getMeasuredHeight()) * 1.3f);
                        layoutParams.gravity = 17;
                        relativeLayout.setLayoutParams(layoutParams);
                        new Handler().post(new Runnable() {
                            public void run() {
                                int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                AnonymousClass2 r1 = AnonymousClass2.this;
                                closeImageView.setX((float) (CTInAppNativeHalfInterstitialFragment.this.relativeLayout.getRight() - measuredWidth));
                                AnonymousClass2 r12 = AnonymousClass2.this;
                                closeImageView.setY((float) (CTInAppNativeHalfInterstitialFragment.this.relativeLayout.getTop() - measuredWidth));
                            }
                        });
                    } else if (CTInAppNativeHalfInterstitialFragment.this.isTablet()) {
                        layoutParams.setMargins(CTInAppNativeHalfInterstitialFragment.this.getScaledPixels(140), CTInAppNativeHalfInterstitialFragment.this.getScaledPixels(100), CTInAppNativeHalfInterstitialFragment.this.getScaledPixels(140), CTInAppNativeHalfInterstitialFragment.this.getScaledPixels(100));
                        int measuredHeight = relativeLayout.getMeasuredHeight() - CTInAppNativeHalfInterstitialFragment.this.getScaledPixels(130);
                        layoutParams.height = measuredHeight;
                        layoutParams.width = (int) (((float) measuredHeight) * 1.3f);
                        layoutParams.gravity = 17;
                        relativeLayout.setLayoutParams(layoutParams);
                        new Handler().post(new Runnable() {
                            public void run() {
                                int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                AnonymousClass2 r1 = AnonymousClass2.this;
                                closeImageView.setX((float) (CTInAppNativeHalfInterstitialFragment.this.relativeLayout.getRight() - measuredWidth));
                                AnonymousClass2 r12 = AnonymousClass2.this;
                                closeImageView.setY((float) (CTInAppNativeHalfInterstitialFragment.this.relativeLayout.getTop() - measuredWidth));
                            }
                        });
                    } else {
                        layoutParams.width = (int) (((float) relativeLayout.getMeasuredHeight()) * 1.3f);
                        layoutParams.gravity = 1;
                        relativeLayout.setLayoutParams(layoutParams);
                        new Handler().post(new Runnable() {
                            public void run() {
                                int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                                AnonymousClass2 r1 = AnonymousClass2.this;
                                closeImageView.setX((float) (CTInAppNativeHalfInterstitialFragment.this.relativeLayout.getRight() - measuredWidth));
                                AnonymousClass2 r12 = AnonymousClass2.this;
                                closeImageView.setY((float) (CTInAppNativeHalfInterstitialFragment.this.relativeLayout.getTop() - measuredWidth));
                            }
                        });
                    }
                    CTInAppNativeHalfInterstitialFragment.this.relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
        if (this.inAppNotification.getInAppMediaForOrientation(this.currentOrientation) != null) {
            CTInAppNotification cTInAppNotification = this.inAppNotification;
            if (cTInAppNotification.getImage(cTInAppNotification.getInAppMediaForOrientation(this.currentOrientation)) != null) {
                CTInAppNotification cTInAppNotification2 = this.inAppNotification;
                ((ImageView) this.relativeLayout.findViewById(R$id.backgroundImage)).setImageBitmap(cTInAppNotification2.getImage(cTInAppNotification2.getInAppMediaForOrientation(this.currentOrientation)));
            }
        }
        LinearLayout linearLayout = (LinearLayout) this.relativeLayout.findViewById(R$id.half_interstitial_linear_layout);
        Button button = (Button) linearLayout.findViewById(R$id.half_interstitial_button1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(R$id.half_interstitial_button2);
        arrayList.add(button2);
        TextView textView = (TextView) this.relativeLayout.findViewById(R$id.half_interstitial_title);
        textView.setText(this.inAppNotification.title);
        textView.setTextColor(Color.parseColor(this.inAppNotification.titleColor));
        TextView textView2 = (TextView) this.relativeLayout.findViewById(R$id.half_interstitial_message);
        textView2.setText(this.inAppNotification.message);
        textView2.setTextColor(Color.parseColor(this.inAppNotification.messageColor));
        ArrayList<CTInAppNotificationButton> arrayList2 = this.inAppNotification.buttons;
        if (arrayList2.size() == 1) {
            int i2 = this.currentOrientation;
            if (i2 == 2) {
                button.setVisibility(8);
            } else if (i2 == 1) {
                button.setVisibility(4);
            }
            setupInAppButton(button2, arrayList2.get(0), 0);
        } else if (!arrayList2.isEmpty()) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (i3 < 2) {
                    setupInAppButton((Button) arrayList.get(i3), arrayList2.get(i3), i3);
                }
            }
        }
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        closeImageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CTInAppNativeHalfInterstitialFragment.this.didDismiss(null);
                CTInAppNativeHalfInterstitialFragment.this.getActivity().finish();
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

package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppBaseFragment.CTInAppNativeButtonClickListener;

public class CTInAppNativeCoverImageFragment extends CTInAppBaseFullFragment {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.inapp_cover_image, viewGroup, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.inapp_cover_image_frame_layout);
        frameLayout.setBackgroundColor(Color.parseColor(this.inAppNotification.backgroundColor));
        ImageView imageView = (ImageView) ((RelativeLayout) frameLayout.findViewById(R$id.cover_image_relative_layout)).findViewById(R$id.cover_image);
        if (this.inAppNotification.getInAppMediaForOrientation(this.currentOrientation) != null) {
            CTInAppNotification cTInAppNotification = this.inAppNotification;
            if (cTInAppNotification.getImage(cTInAppNotification.getInAppMediaForOrientation(this.currentOrientation)) != null) {
                CTInAppNotification cTInAppNotification2 = this.inAppNotification;
                imageView.setImageBitmap(cTInAppNotification2.getImage(cTInAppNotification2.getInAppMediaForOrientation(this.currentOrientation)));
                imageView.setTag(Integer.valueOf(0));
                imageView.setOnClickListener(new CTInAppNativeButtonClickListener());
            }
        }
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        closeImageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CTInAppNativeCoverImageFragment.this.didDismiss(null);
                CTInAppNativeCoverImageFragment.this.getActivity().finish();
            }
        });
        if (!this.inAppNotification.hideCloseButton) {
            closeImageView.setVisibility(8);
        } else {
            closeImageView.setVisibility(0);
        }
        return inflate;
    }
}

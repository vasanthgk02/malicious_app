package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppBaseFragment.CTInAppNativeButtonClickListener;
import java.util.ArrayList;

public class CTInAppNativeCoverFragment extends CTInAppBaseFullNativeFragment {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        View inflate = layoutInflater.inflate(R$layout.inapp_cover, viewGroup, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.inapp_cover_frame_layout);
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R$id.cover_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(this.inAppNotification.backgroundColor));
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R$id.cover_linear_layout);
        Button button = (Button) linearLayout.findViewById(R$id.cover_button1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(R$id.cover_button2);
        arrayList.add(button2);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R$id.backgroundImage);
        if (this.inAppNotification.getInAppMediaForOrientation(this.currentOrientation) != null) {
            CTInAppNotification cTInAppNotification = this.inAppNotification;
            if (cTInAppNotification.getImage(cTInAppNotification.getInAppMediaForOrientation(this.currentOrientation)) != null) {
                CTInAppNotification cTInAppNotification2 = this.inAppNotification;
                imageView.setImageBitmap(cTInAppNotification2.getImage(cTInAppNotification2.getInAppMediaForOrientation(this.currentOrientation)));
                imageView.setTag(Integer.valueOf(0));
                imageView.setOnClickListener(new CTInAppNativeButtonClickListener());
            }
        }
        TextView textView = (TextView) relativeLayout.findViewById(R$id.cover_title);
        textView.setText(this.inAppNotification.title);
        textView.setTextColor(Color.parseColor(this.inAppNotification.titleColor));
        TextView textView2 = (TextView) relativeLayout.findViewById(R$id.cover_message);
        textView2.setText(this.inAppNotification.message);
        textView2.setTextColor(Color.parseColor(this.inAppNotification.messageColor));
        ArrayList<CTInAppNotificationButton> arrayList2 = this.inAppNotification.buttons;
        if (arrayList2.size() == 1) {
            int i = this.currentOrientation;
            if (i == 2) {
                button.setVisibility(8);
            } else if (i == 1) {
                button.setVisibility(4);
            }
            setupInAppButton(button2, arrayList2.get(0), 0);
        } else if (!arrayList2.isEmpty()) {
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                if (i2 < 2) {
                    setupInAppButton((Button) arrayList.get(i2), arrayList2.get(i2), i2);
                }
            }
        }
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(199272);
        closeImageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CTInAppNativeCoverFragment.this.didDismiss(null);
                CTInAppNativeCoverFragment.this.getActivity().finish();
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

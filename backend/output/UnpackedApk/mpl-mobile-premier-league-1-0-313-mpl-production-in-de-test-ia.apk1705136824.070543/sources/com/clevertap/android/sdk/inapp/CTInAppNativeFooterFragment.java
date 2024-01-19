package com.clevertap.android.sdk.inapp;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import java.util.ArrayList;

public class CTInAppNativeFooterFragment extends CTInAppBasePartialNativeFragment {
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        View inflate = layoutInflater.inflate(R$layout.inapp_footer, viewGroup, false);
        this.inAppView = inflate;
        new LayoutParams(-1, -1);
        RelativeLayout relativeLayout = (RelativeLayout) ((FrameLayout) inflate.findViewById(R$id.footer_frame_layout)).findViewById(R$id.footer_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(this.inAppNotification.backgroundColor));
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R$id.footer_linear_layout_2);
        LinearLayout linearLayout2 = (LinearLayout) relativeLayout.findViewById(R$id.footer_linear_layout_3);
        Button button = (Button) linearLayout2.findViewById(R$id.footer_button_1);
        arrayList.add(button);
        Button button2 = (Button) linearLayout2.findViewById(R$id.footer_button_2);
        arrayList.add(button2);
        ImageView imageView = (ImageView) ((LinearLayout) relativeLayout.findViewById(R$id.footer_linear_layout_1)).findViewById(R$id.footer_icon);
        if (!this.inAppNotification.mediaList.isEmpty()) {
            CTInAppNotification cTInAppNotification = this.inAppNotification;
            Bitmap image = cTInAppNotification.getImage(cTInAppNotification.mediaList.get(0));
            if (image != null) {
                imageView.setImageBitmap(image);
            } else {
                imageView.setVisibility(8);
            }
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) linearLayout.findViewById(R$id.footer_title);
        textView.setText(this.inAppNotification.title);
        textView.setTextColor(Color.parseColor(this.inAppNotification.titleColor));
        TextView textView2 = (TextView) linearLayout.findViewById(R$id.footer_message);
        textView2.setText(this.inAppNotification.message);
        textView2.setTextColor(Color.parseColor(this.inAppNotification.messageColor));
        ArrayList<CTInAppNotificationButton> arrayList2 = this.inAppNotification.buttons;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            for (int i = 0; i < arrayList2.size(); i++) {
                if (i < 2) {
                    setupInAppButton((Button) arrayList.get(i), arrayList2.get(i), i);
                }
            }
        }
        if (this.inAppNotification.buttonCount == 1) {
            hideSecondaryButton(button, button2);
        }
        this.inAppView.setOnTouchListener(new OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                CTInAppNativeFooterFragment.this.gd.onTouchEvent(motionEvent);
                return true;
            }
        });
        return this.inAppView;
    }
}

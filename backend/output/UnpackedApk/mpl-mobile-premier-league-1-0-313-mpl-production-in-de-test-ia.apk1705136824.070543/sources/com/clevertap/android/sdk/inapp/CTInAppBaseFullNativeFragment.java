package com.clevertap.android.sdk.inapp;

import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Button;
import com.clevertap.android.sdk.inapp.CTInAppBaseFragment.CTInAppNativeButtonClickListener;

public abstract class CTInAppBaseFullNativeFragment extends CTInAppBaseFullFragment {
    public void setupInAppButton(Button button, CTInAppNotificationButton cTInAppNotificationButton, int i) {
        ShapeDrawable shapeDrawable;
        int i2;
        Button button2 = button;
        CTInAppNotificationButton cTInAppNotificationButton2 = cTInAppNotificationButton;
        if (cTInAppNotificationButton2 != null) {
            button2.setVisibility(0);
            button2.setTag(Integer.valueOf(i));
            button2.setText(cTInAppNotificationButton2.text);
            button2.setTextColor(Color.parseColor(cTInAppNotificationButton2.textColor));
            button2.setOnClickListener(new CTInAppNativeButtonClickListener());
            ShapeDrawable shapeDrawable2 = null;
            if (!cTInAppNotificationButton2.borderRadius.isEmpty()) {
                float parseFloat = Float.parseFloat(cTInAppNotificationButton2.borderRadius);
                WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
                if (windowManager == null) {
                    i2 = 0;
                } else if (VERSION.SDK_INT >= 30) {
                    i2 = this.context.getResources().getConfiguration().densityDpi;
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    i2 = displayMetrics.densityDpi;
                }
                float f2 = (480.0f / ((float) i2)) * parseFloat * 2.0f;
                shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
                shapeDrawable.getPaint().setColor(Color.parseColor(cTInAppNotificationButton2.backgroundColor));
                shapeDrawable.getPaint().setStyle(Style.FILL);
                shapeDrawable.getPaint().setAntiAlias(true);
                shapeDrawable2 = new ShapeDrawable(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, new float[]{f2, f2, f2, f2, f2, f2, f2, f2}));
            } else {
                shapeDrawable = null;
            }
            if (!cTInAppNotificationButton2.borderColor.isEmpty() && shapeDrawable2 != null) {
                shapeDrawable2.getPaint().setColor(Color.parseColor(cTInAppNotificationButton2.borderColor));
                shapeDrawable2.setPadding(1, 1, 1, 1);
                shapeDrawable2.getPaint().setStyle(Style.FILL);
            }
            if (shapeDrawable != null) {
                button2.setBackground(new LayerDrawable(new Drawable[]{shapeDrawable2, shapeDrawable}));
                return;
            }
            return;
        }
        button2.setVisibility(8);
    }
}

package com.razorpay;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public final class E$_6$ {
    public static void G__G_(ViewGroup viewGroup, int i, Context context, ArrayList<ApplicationDetails> arrayList, OnClickListener onClickListener, LayoutParams layoutParams) {
        LayoutParams layoutParams2 = layoutParams;
        int size = arrayList.size();
        LayoutInflater from = LayoutInflater.from(context);
        for (int i2 = 0; i2 < size; i2++) {
            ApplicationDetails applicationDetails = arrayList.get(i2);
            if (applicationDetails != null) {
                String appName = applicationDetails.getAppName();
                String iconBase64 = applicationDetails.getIconBase64();
                String packageName = applicationDetails.getPackageName();
                if (!(appName == null || iconBase64 == null || packageName == null)) {
                    byte[] decode = Base64.decode(iconBase64.substring(iconBase64.indexOf(",") + 1), 0);
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                    if (decodeByteArray != null) {
                        int i3 = i;
                        View inflate = from.inflate(i, null);
                        ((ImageView) inflate.findViewById(R.id.app_logo)).setImageBitmap(decodeByteArray);
                        ((TextView) inflate.findViewById(R.id.app_name)).setText(appName);
                        inflate.setTag(packageName);
                        inflate.setClickable(true);
                        inflate.setOnClickListener(onClickListener);
                        if (layoutParams2 != null) {
                            inflate.setLayoutParams(layoutParams2);
                        }
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{16843534});
                        inflate.setBackgroundResource(obtainStyledAttributes.getResourceId(0, 0));
                        obtainStyledAttributes.recycle();
                        ViewGroup viewGroup2 = viewGroup;
                        viewGroup.addView(inflate);
                    }
                }
            }
            ViewGroup viewGroup3 = viewGroup;
            int i4 = i;
            Context context2 = context;
            OnClickListener onClickListener2 = onClickListener;
        }
    }

    public static View Q_$2$(Context context, ArrayList<ApplicationDetails> arrayList, boolean z, int i, OnClickListener onClickListener) {
        return R$$r_(context, arrayList, z, i, onClickListener, null);
    }

    public static View R$$r_(Context context, ArrayList<ApplicationDetails> arrayList, boolean z, int i, OnClickListener onClickListener, String str) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (!z || arrayList.size() == 1) {
            return a_$P$(context, arrayList, onClickListener, str);
        }
        return R$$r_(context, arrayList, i, onClickListener);
    }

    public static View a_$P$(Context context, ArrayList<ApplicationDetails> arrayList, OnClickListener onClickListener, String str) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int dpToPixels = BaseUtils.dpToPixels(context, 12);
        layoutParams.setMargins(dpToPixels, BaseUtils.dpToPixels(context, 12), dpToPixels, BaseUtils.dpToPixels(context, 6));
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.razorpay_card));
        if (!(str == null || str.length() == 0)) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.app_display_list_heading_tv, null);
            ((TextView) relativeLayout.findViewById(R.id.text_view)).setText(str);
            linearLayout.addView(relativeLayout);
        }
        G__G_(linearLayout, R.layout.apps_display_list_element, context, arrayList, onClickListener, null);
        return linearLayout;
    }

    public static View R$$r_(Context context, ArrayList<ApplicationDetails> arrayList, int i, OnClickListener onClickListener) {
        GridLayout gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(4);
        int dpToPixels = BaseUtils.dpToPixels(context, 12);
        int dpToPixels2 = BaseUtils.dpToPixels(context, 16);
        int dpToPixels3 = BaseUtils.dpToPixels(context, 6);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.height = -2;
        layoutParams.width = -1;
        layoutParams.setMargins(dpToPixels, dpToPixels2, dpToPixels, dpToPixels3);
        gridLayout.setLayoutParams(layoutParams);
        gridLayout.setOrientation(0);
        gridLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.razorpay_card));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((float) ((i - dpToPixels) - dpToPixels)) / 4.0f), -2);
        layoutParams2.addRule(14);
        G__G_(gridLayout, R.layout.apps_display_grid_element, context, arrayList, onClickListener, layoutParams2);
        return gridLayout;
    }
}

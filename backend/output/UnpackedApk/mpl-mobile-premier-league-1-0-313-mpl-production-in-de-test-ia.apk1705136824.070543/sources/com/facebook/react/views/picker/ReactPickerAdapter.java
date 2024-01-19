package com.facebook.react.views.picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.util.List;

public class ReactPickerAdapter extends ArrayAdapter<ReactPickerItem> {
    public Integer mBackgroundColor;
    public final LayoutInflater mInflater;
    public Integer mPrimaryTextColor;

    public ReactPickerAdapter(Context context, List<ReactPickerItem> list) {
        super(context, 0, list);
        Object systemService = context.getSystemService("layout_inflater");
        ImageOriginUtils.assertNotNull(systemService);
        this.mInflater = (LayoutInflater) systemService;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup, true);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r3, android.view.View r4, android.view.ViewGroup r5, boolean r6) {
        /*
            r2 = this;
            java.lang.Object r3 = r2.getItem(r3)
            com.facebook.react.views.picker.ReactPickerItem r3 = (com.facebook.react.views.picker.ReactPickerItem) r3
            r0 = 0
            if (r4 != 0) goto L_0x0023
            if (r6 == 0) goto L_0x000f
            r4 = 17367049(0x1090009, float:2.516295E-38)
            goto L_0x0012
        L_0x000f:
            r4 = 17367048(0x1090008, float:2.5162948E-38)
        L_0x0012:
            android.view.LayoutInflater r1 = r2.mInflater
            android.view.View r4 = r1.inflate(r4, r5, r0)
            r5 = r4
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.content.res.ColorStateList r5 = r5.getTextColors()
            r4.setTag(r5)
            r0 = 1
        L_0x0023:
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r5 = r3.label
            r4.setText(r5)
            if (r6 != 0) goto L_0x0038
            java.lang.Integer r5 = r2.mPrimaryTextColor
            if (r5 == 0) goto L_0x0038
            int r3 = r5.intValue()
            r4.setTextColor(r3)
            goto L_0x0055
        L_0x0038:
            java.lang.Integer r3 = r3.color
            if (r3 == 0) goto L_0x0044
            int r3 = r3.intValue()
            r4.setTextColor(r3)
            goto L_0x0055
        L_0x0044:
            java.lang.Object r3 = r4.getTag()
            if (r3 == 0) goto L_0x0055
            if (r0 != 0) goto L_0x0055
            java.lang.Object r3 = r4.getTag()
            android.content.res.ColorStateList r3 = (android.content.res.ColorStateList) r3
            r4.setTextColor(r3)
        L_0x0055:
            java.lang.Integer r3 = r2.mBackgroundColor
            if (r3 == 0) goto L_0x0060
            int r3 = r3.intValue()
            r4.setBackgroundColor(r3)
        L_0x0060:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.picker.ReactPickerAdapter.getView(int, android.view.View, android.view.ViewGroup, boolean):android.view.View");
    }
}

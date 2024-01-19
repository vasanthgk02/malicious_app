package iyegoroff.RNColorMatrixImageFilters;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.views.view.ReactViewGroup;

public class ColorMatrixImageFilter extends ReactViewGroup {
    public ColorMatrixColorFilter mFilter = new ColorMatrixColorFilter(new ColorMatrix());

    public ColorMatrixImageFilter(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A[LOOP:0: B:1:0x0002->B:11:0x0025, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x001d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r5.getChildCount()
            if (r1 >= r2) goto L_0x0028
            android.view.View r2 = r5.getChildAt(r1)
        L_0x000c:
            boolean r3 = r2 instanceof android.widget.ImageView
            if (r3 != 0) goto L_0x001b
            boolean r4 = r2 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x001b
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.View r2 = r2.getChildAt(r0)
            goto L_0x000c
        L_0x001b:
            if (r3 == 0) goto L_0x0025
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            android.graphics.ColorMatrixColorFilter r0 = r5.mFilter
            r2.setColorFilter(r0)
            goto L_0x0028
        L_0x0025:
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0028:
            super.draw(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: iyegoroff.RNColorMatrixImageFilters.ColorMatrixImageFilter.draw(android.graphics.Canvas):void");
    }

    public void setMatrix(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        this.mFilter = new ColorMatrixColorFilter(fArr);
        invalidate();
    }
}

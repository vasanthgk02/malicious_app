package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewGroupDrawingOrderHelper {
    public int[] mDrawingOrderIndices;
    public int mNumberOfChildrenWithZIndex = 0;
    public final ViewGroup mViewGroup;

    public ViewGroupDrawingOrderHelper(ViewGroup viewGroup) {
        this.mViewGroup = viewGroup;
    }

    public int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrderIndices == null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i; i3++) {
                arrayList.add(this.mViewGroup.getChildAt(i3));
            }
            Collections.sort(arrayList, new Comparator<View>(this) {
                public int compare(Object obj, Object obj2) {
                    View view = (View) obj2;
                    Integer viewZIndex = ViewGroupManager.getViewZIndex((View) obj);
                    Integer valueOf = Integer.valueOf(0);
                    if (viewZIndex == null) {
                        viewZIndex = valueOf;
                    }
                    Integer viewZIndex2 = ViewGroupManager.getViewZIndex(view);
                    if (viewZIndex2 != null) {
                        valueOf = viewZIndex2;
                    }
                    return viewZIndex.intValue() - valueOf.intValue();
                }
            });
            this.mDrawingOrderIndices = new int[i];
            for (int i4 = 0; i4 < i; i4++) {
                this.mDrawingOrderIndices[i4] = this.mViewGroup.indexOfChild((View) arrayList.get(i4));
            }
        }
        return this.mDrawingOrderIndices[i2];
    }

    public boolean shouldEnableCustomDrawingOrder() {
        return this.mNumberOfChildrenWithZIndex > 0;
    }
}

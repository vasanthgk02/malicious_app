package com.th3rdwave.safeareacontext;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.util.EnumSet;

public class SafeAreaViewShadowNode extends LayoutShadowNode {
    public SafeAreaViewLocalData mLocalData;
    public float[] mMargins;
    public boolean mNeedsUpdate = false;
    public float[] mPaddings;

    public SafeAreaViewShadowNode() {
        int[] iArr = ViewProps.PADDING_MARGIN_SPACING_TYPES;
        this.mPaddings = new float[iArr.length];
        this.mMargins = new float[iArr.length];
        for (int i = 0; i < ViewProps.PADDING_MARGIN_SPACING_TYPES.length; i++) {
            this.mPaddings[i] = Float.NaN;
            this.mMargins[i] = Float.NaN;
        }
    }

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        if (this.mNeedsUpdate) {
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    public void setLocalData(Object obj) {
        if (obj instanceof SafeAreaViewLocalData) {
            SafeAreaViewLocalData safeAreaViewLocalData = (SafeAreaViewLocalData) obj;
            SafeAreaViewLocalData safeAreaViewLocalData2 = this.mLocalData;
            if (safeAreaViewLocalData2 != null) {
                SafeAreaViewMode safeAreaViewMode = safeAreaViewLocalData2.mMode;
                if (safeAreaViewMode != safeAreaViewLocalData.mMode) {
                    if (safeAreaViewMode == SafeAreaViewMode.PADDING) {
                        super.setPadding(1, this.mPaddings[1]);
                        super.setPadding(2, this.mPaddings[1]);
                        super.setPadding(3, this.mPaddings[3]);
                        super.setPadding(0, this.mPaddings[0]);
                    } else {
                        super.setMargin(1, this.mMargins[1]);
                        super.setMargin(2, this.mMargins[1]);
                        super.setMargin(3, this.mMargins[3]);
                        super.setMargin(0, this.mMargins[0]);
                    }
                }
            }
            this.mLocalData = safeAreaViewLocalData;
            this.mNeedsUpdate = false;
            updateInsets();
        }
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        this.mMargins[ViewProps.PADDING_MARGIN_SPACING_TYPES[i]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setMargins(i, dynamic);
        this.mNeedsUpdate = true;
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        this.mPaddings[ViewProps.PADDING_MARGIN_SPACING_TYPES[i]] = dynamic.getType() == ReadableType.Number ? (float) dynamic.asDouble() : Float.NaN;
        super.setPaddings(i, dynamic);
        this.mNeedsUpdate = true;
    }

    public final void updateInsets() {
        float f2;
        float f3;
        float f4;
        SafeAreaViewLocalData safeAreaViewLocalData = this.mLocalData;
        if (safeAreaViewLocalData != null) {
            float[] fArr = safeAreaViewLocalData.mMode == SafeAreaViewMode.PADDING ? this.mPaddings : this.mMargins;
            float f5 = fArr[8];
            float f6 = 0.0f;
            if (!Float.isNaN(f5)) {
                f4 = f5;
                f3 = f4;
                f2 = f3;
            } else {
                f5 = 0.0f;
                f4 = 0.0f;
                f3 = 0.0f;
                f2 = 0.0f;
            }
            float f7 = fArr[7];
            if (!Float.isNaN(f7)) {
                f5 = f7;
                f3 = f5;
            }
            float f8 = fArr[6];
            if (!Float.isNaN(f8)) {
                f4 = f8;
                f2 = f4;
            }
            float f9 = fArr[1];
            if (!Float.isNaN(f9)) {
                f5 = f9;
            }
            float f10 = fArr[2];
            if (!Float.isNaN(f10)) {
                f4 = f10;
            }
            float f11 = fArr[3];
            if (!Float.isNaN(f11)) {
                f3 = f11;
            }
            float f12 = fArr[0];
            if (!Float.isNaN(f12)) {
                f2 = f12;
            }
            float pixelFromDIP = ImageOriginUtils.toPixelFromDIP(f5);
            float pixelFromDIP2 = ImageOriginUtils.toPixelFromDIP(f4);
            float pixelFromDIP3 = ImageOriginUtils.toPixelFromDIP(f3);
            float pixelFromDIP4 = ImageOriginUtils.toPixelFromDIP(f2);
            SafeAreaViewLocalData safeAreaViewLocalData2 = this.mLocalData;
            EnumSet<SafeAreaViewEdges> enumSet = safeAreaViewLocalData2.mEdges;
            EdgeInsets edgeInsets = safeAreaViewLocalData2.mInsets;
            float f13 = enumSet.contains(SafeAreaViewEdges.TOP) ? edgeInsets.top : 0.0f;
            float f14 = enumSet.contains(SafeAreaViewEdges.RIGHT) ? edgeInsets.right : 0.0f;
            float f15 = enumSet.contains(SafeAreaViewEdges.BOTTOM) ? edgeInsets.bottom : 0.0f;
            if (enumSet.contains(SafeAreaViewEdges.LEFT)) {
                f6 = edgeInsets.left;
            }
            if (this.mLocalData.mMode == SafeAreaViewMode.PADDING) {
                super.setPadding(1, f13 + pixelFromDIP);
                super.setPadding(2, f14 + pixelFromDIP2);
                super.setPadding(3, f15 + pixelFromDIP3);
                super.setPadding(0, f6 + pixelFromDIP4);
            } else {
                super.setMargin(1, f13 + pixelFromDIP);
                super.setMargin(2, f14 + pixelFromDIP2);
                super.setMargin(3, f15 + pixelFromDIP3);
                super.setMargin(0, f6 + pixelFromDIP4);
            }
        }
    }
}

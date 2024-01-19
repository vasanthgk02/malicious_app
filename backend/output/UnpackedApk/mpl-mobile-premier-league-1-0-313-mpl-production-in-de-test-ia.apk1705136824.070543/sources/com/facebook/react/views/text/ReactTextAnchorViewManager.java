package com.facebook.react.views.text;

import android.text.TextUtils.TruncateAt;
import android.view.View;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import org.apache.fontbox.ttf.HeaderTable;

public abstract class ReactTextAnchorViewManager<T extends View, C extends ReactBaseTextShadowNode> extends BaseViewManager<T, C> {
    public static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};

    @ReactProp(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(ReactTextView reactTextView, boolean z) {
        reactTextView.setAdjustFontSizeToFit(z);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactTextView reactTextView, int i, Integer num) {
        float f2 = Float.NaN;
        float intValue = num == null ? Float.NaN : (float) (num.intValue() & 16777215);
        if (num != null) {
            f2 = (float) (num.intValue() >>> 24);
        }
        reactTextView.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderColor(SPACING_TYPES[i], intValue, f2);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactTextView reactTextView, int i, float f2) {
        if (!ImageOriginUtils.isUndefined(f2)) {
            f2 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        if (i == 0) {
            reactTextView.setBorderRadius(f2);
            return;
        }
        reactTextView.mReactBackgroundManager.getOrCreateReactViewBackground().setRadius(f2, i - 1);
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactTextView reactTextView, String str) {
        reactTextView.setBorderStyle(str);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactTextView reactTextView, int i, float f2) {
        if (!ImageOriginUtils.isUndefined(f2)) {
            f2 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        reactTextView.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderWidth(SPACING_TYPES[i], f2);
    }

    @com.facebook.react.uimanager.annotations.ReactProp(name = "dataDetectorType")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDataDetectorType(com.facebook.react.views.text.ReactTextView r7, java.lang.String r8) {
        /*
            r6 = this;
            int r0 = r8.hashCode()
            r1 = 0
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1192969641: goto L_0x0035;
                case 96673: goto L_0x002b;
                case 3321850: goto L_0x0021;
                case 3387192: goto L_0x0017;
                case 96619420: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x003f
        L_0x000d:
            java.lang.String r0 = "email"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x003f
            r8 = 2
            goto L_0x0040
        L_0x0017:
            java.lang.String r0 = "none"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x003f
            r8 = 4
            goto L_0x0040
        L_0x0021:
            java.lang.String r0 = "link"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x003f
            r8 = 1
            goto L_0x0040
        L_0x002b:
            java.lang.String r0 = "all"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x003f
            r8 = 3
            goto L_0x0040
        L_0x0035:
            java.lang.String r0 = "phoneNumber"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x003f
            r8 = 0
            goto L_0x0040
        L_0x003f:
            r8 = -1
        L_0x0040:
            if (r8 == 0) goto L_0x005a
            if (r8 == r5) goto L_0x0056
            if (r8 == r4) goto L_0x0052
            if (r8 == r3) goto L_0x004c
            r7.setLinkifyMask(r1)
            goto L_0x005d
        L_0x004c:
            r8 = 15
            r7.setLinkifyMask(r8)
            goto L_0x005d
        L_0x0052:
            r7.setLinkifyMask(r4)
            goto L_0x005d
        L_0x0056:
            r7.setLinkifyMask(r5)
            goto L_0x005d
        L_0x005a:
            r7.setLinkifyMask(r2)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextAnchorViewManager.setDataDetectorType(com.facebook.react.views.text.ReactTextView, java.lang.String):void");
    }

    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactTextView reactTextView, boolean z) {
        reactTextView.setEnabled(!z);
    }

    @ReactProp(name = "ellipsizeMode")
    public void setEllipsizeMode(ReactTextView reactTextView, String str) {
        if (str == null || str.equals("tail")) {
            reactTextView.setEllipsizeLocation(TruncateAt.END);
        } else if (str.equals(HeaderTable.TAG)) {
            reactTextView.setEllipsizeLocation(TruncateAt.START);
        } else if (str.equals("middle")) {
            reactTextView.setEllipsizeLocation(TruncateAt.MIDDLE);
        } else if (str.equals("clip")) {
            reactTextView.setEllipsizeLocation(null);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid ellipsizeMode: ", str));
        }
    }

    @ReactProp(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(ReactTextView reactTextView, boolean z) {
        reactTextView.setIncludeFontPadding(z);
    }

    @ReactProp(name = "onInlineViewLayout")
    public void setNotifyOnInlineViewLayout(ReactTextView reactTextView, boolean z) {
        reactTextView.setNotifyOnInlineViewLayout(z);
    }

    @ReactProp(defaultInt = Integer.MAX_VALUE, name = "numberOfLines")
    public void setNumberOfLines(ReactTextView reactTextView, int i) {
        reactTextView.setNumberOfLines(i);
    }

    @ReactProp(name = "selectable")
    public void setSelectable(ReactTextView reactTextView, boolean z) {
        reactTextView.setTextIsSelectable(z);
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactTextView reactTextView, Integer num) {
        if (num == null) {
            reactTextView.setHighlightColor(ImageOriginUtils.getDefaultTextAttribute(reactTextView.getContext(), 16842905).getDefaultColor());
        } else {
            reactTextView.setHighlightColor(num.intValue());
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactTextView reactTextView, String str) {
        if (str == null || "auto".equals(str)) {
            reactTextView.setGravityVertical(0);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_TOP.equals(str)) {
            reactTextView.setGravityVertical(48);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM.equals(str)) {
            reactTextView.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactTextView.setGravityVertical(16);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid textAlignVertical: ", str));
        }
    }
}

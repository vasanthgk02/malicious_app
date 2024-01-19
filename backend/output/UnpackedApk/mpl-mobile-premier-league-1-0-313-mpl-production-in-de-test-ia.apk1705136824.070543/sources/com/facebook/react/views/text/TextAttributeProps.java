package com.facebook.react.views.text;

import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class TextAttributeProps {
    public static final int DEFAULT_BREAK_STRATEGY;
    public static final int DEFAULT_JUSTIFICATION_MODE = 0;
    public boolean mAllowFontScaling;
    public int mBackgroundColor;
    public int mColor;
    public String mFontFamily;
    public String mFontFeatureSettings;
    public int mFontSize;
    public float mFontSizeInput;
    public int mFontStyle;
    public int mFontWeight;
    public float mHeightOfTallestInlineImage;
    public boolean mIsBackgroundColorSet;
    public boolean mIsColorSet;
    public boolean mIsLineThroughTextDecorationSet;
    public boolean mIsUnderlineTextDecorationSet;
    public float mLetterSpacingInput;
    public float mLineHeight = Float.NaN;
    public float mLineHeightInput;
    public final ReactStylesDiffMap mProps;
    public int mTextShadowColor;
    public float mTextShadowOffsetDx;
    public float mTextShadowOffsetDy;
    public float mTextShadowRadius;
    public TextTransform mTextTransform;

    static {
        int i = VERSION.SDK_INT;
        int i2 = 0;
        if (VERSION.SDK_INT >= 23) {
            i2 = 1;
        }
        DEFAULT_BREAK_STRATEGY = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0152, code lost:
        r3 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextAttributeProps(com.facebook.react.uimanager.ReactStylesDiffMap r12) {
        /*
            r11 = this;
            r11.<init>()
            r0 = 2143289344(0x7fc00000, float:NaN)
            r11.mLineHeight = r0
            r1 = 0
            r11.mIsColorSet = r1
            r2 = 1
            r11.mAllowFontScaling = r2
            r11.mIsBackgroundColorSet = r1
            r3 = -1
            r11.mFontSize = r3
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11.mFontSizeInput = r4
            r11.mLineHeightInput = r4
            r11.mLetterSpacingInput = r0
            com.facebook.react.views.text.TextTransform r5 = com.facebook.react.views.text.TextTransform.UNSET
            r11.mTextTransform = r5
            r5 = 0
            r11.mTextShadowOffsetDx = r5
            r11.mTextShadowOffsetDy = r5
            r6 = 1065353216(0x3f800000, float:1.0)
            r11.mTextShadowRadius = r6
            r6 = 1426063360(0x55000000, float:8.796093E12)
            r11.mTextShadowColor = r6
            r11.mIsUnderlineTextDecorationSet = r1
            r11.mIsLineThroughTextDecorationSet = r1
            r11.mFontStyle = r3
            r11.mFontWeight = r3
            r7 = 0
            r11.mFontFamily = r7
            r11.mFontFeatureSettings = r7
            r11.mHeightOfTallestInlineImage = r0
            r11.mProps = r12
            java.lang.String r8 = "numberOfLines"
            r11.getIntProp(r8, r3)
            java.lang.String r8 = "lineHeight"
            float r8 = r11.getFloatProp(r8, r4)
            r11.setLineHeight(r8)
            java.lang.String r8 = "letterSpacing"
            float r0 = r11.getFloatProp(r8, r0)
            r11.mLetterSpacingInput = r0
            java.lang.String r0 = "allowFontScaling"
            boolean r0 = r11.getBooleanProp(r0, r2)
            boolean r8 = r11.mAllowFontScaling
            if (r0 == r8) goto L_0x006c
            r11.mAllowFontScaling = r0
            float r0 = r11.mFontSizeInput
            r11.setFontSize(r0)
            float r0 = r11.mLineHeightInput
            r11.setLineHeight(r0)
            float r0 = r11.mLetterSpacingInput
            r11.mLetterSpacingInput = r0
        L_0x006c:
            java.lang.String r0 = "fontSize"
            float r0 = r11.getFloatProp(r0, r4)
            r11.setFontSize(r0)
            com.facebook.react.bridge.ReadableMap r0 = r12.mBackingMap
            java.lang.String r4 = "color"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x0088
            int r0 = r12.getInt(r4, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0089
        L_0x0088:
            r0 = r7
        L_0x0089:
            if (r0 == 0) goto L_0x008d
            r4 = 1
            goto L_0x008e
        L_0x008d:
            r4 = 0
        L_0x008e:
            r11.mIsColorSet = r4
            if (r4 == 0) goto L_0x0098
            int r0 = r0.intValue()
            r11.mColor = r0
        L_0x0098:
            com.facebook.react.bridge.ReadableMap r0 = r12.mBackingMap
            java.lang.String r4 = "foregroundColor"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x00ab
            int r0 = r12.getInt(r4, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x00ac
        L_0x00ab:
            r0 = r7
        L_0x00ac:
            if (r0 == 0) goto L_0x00b0
            r4 = 1
            goto L_0x00b1
        L_0x00b0:
            r4 = 0
        L_0x00b1:
            r11.mIsColorSet = r4
            if (r4 == 0) goto L_0x00bb
            int r0 = r0.intValue()
            r11.mColor = r0
        L_0x00bb:
            com.facebook.react.bridge.ReadableMap r0 = r12.mBackingMap
            java.lang.String r4 = "backgroundColor"
            boolean r0 = r0.hasKey(r4)
            if (r0 == 0) goto L_0x00ce
            int r0 = r12.getInt(r4, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x00cf
        L_0x00ce:
            r0 = r7
        L_0x00cf:
            if (r0 == 0) goto L_0x00d3
            r4 = 1
            goto L_0x00d4
        L_0x00d3:
            r4 = 0
        L_0x00d4:
            r11.mIsBackgroundColorSet = r4
            if (r4 == 0) goto L_0x00de
            int r0 = r0.intValue()
            r11.mBackgroundColor = r0
        L_0x00de:
            java.lang.String r0 = "fontFamily"
            java.lang.String r0 = r11.getStringProp(r0)
            r11.mFontFamily = r0
            java.lang.String r0 = "fontWeight"
            java.lang.String r0 = r11.getStringProp(r0)
            if (r0 == 0) goto L_0x0116
            int r4 = r0.length()
            r8 = 3
            if (r4 != r8) goto L_0x0116
            java.lang.String r4 = "00"
            boolean r4 = r0.endsWith(r4)
            if (r4 == 0) goto L_0x0116
            char r4 = r0.charAt(r1)
            r8 = 57
            if (r4 > r8) goto L_0x0116
            char r4 = r0.charAt(r1)
            r8 = 49
            if (r4 < r8) goto L_0x0116
            char r4 = r0.charAt(r1)
            int r4 = r4 + -48
            int r4 = r4 * 100
            goto L_0x0117
        L_0x0116:
            r4 = -1
        L_0x0117:
            r8 = 500(0x1f4, float:7.0E-43)
            java.lang.String r9 = "normal"
            if (r4 >= r8) goto L_0x0135
            java.lang.String r10 = "bold"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0126
            goto L_0x0135
        L_0x0126:
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0133
            if (r4 == r3) goto L_0x0131
            if (r4 >= r8) goto L_0x0131
            goto L_0x0133
        L_0x0131:
            r0 = -1
            goto L_0x0136
        L_0x0133:
            r0 = 0
            goto L_0x0136
        L_0x0135:
            r0 = 1
        L_0x0136:
            int r4 = r11.mFontWeight
            if (r0 == r4) goto L_0x013c
            r11.mFontWeight = r0
        L_0x013c:
            java.lang.String r0 = "fontStyle"
            java.lang.String r0 = r11.getStringProp(r0)
            java.lang.String r4 = "italic"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x014c
            r3 = 2
            goto L_0x0153
        L_0x014c:
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0153
            r3 = 0
        L_0x0153:
            int r0 = r11.mFontStyle
            if (r3 == r0) goto L_0x0159
            r11.mFontStyle = r3
        L_0x0159:
            java.lang.String r0 = "fontVariant"
            com.facebook.react.uimanager.ReactStylesDiffMap r3 = r11.mProps
            com.facebook.react.bridge.ReadableMap r3 = r3.mBackingMap
            boolean r3 = r3.hasKey(r0)
            if (r3 == 0) goto L_0x016e
            com.facebook.react.uimanager.ReactStylesDiffMap r3 = r11.mProps
            com.facebook.react.bridge.ReadableMap r3 = r3.mBackingMap
            com.facebook.react.bridge.ReadableArray r0 = r3.getArray(r0)
            goto L_0x016f
        L_0x016e:
            r0 = r7
        L_0x016f:
            java.lang.String r0 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.parseFontVariant(r0)
            r11.mFontFeatureSettings = r0
            java.lang.String r0 = "includeFontPadding"
            r11.getBooleanProp(r0, r2)
            java.lang.String r0 = "textDecorationLine"
            java.lang.String r0 = r11.getStringProp(r0)
            r11.mIsUnderlineTextDecorationSet = r1
            r11.mIsLineThroughTextDecorationSet = r1
            if (r0 == 0) goto L_0x01a9
            java.lang.String r3 = "-"
            java.lang.String[] r0 = r0.split(r3)
            int r3 = r0.length
        L_0x018d:
            if (r1 >= r3) goto L_0x01a9
            r4 = r0[r1]
            java.lang.String r8 = "underline"
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x019c
            r11.mIsUnderlineTextDecorationSet = r2
            goto L_0x01a6
        L_0x019c:
            java.lang.String r8 = "strikethrough"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x01a6
            r11.mIsLineThroughTextDecorationSet = r2
        L_0x01a6:
            int r1 = r1 + 1
            goto L_0x018d
        L_0x01a9:
            com.facebook.react.bridge.ReadableMap r0 = r12.mBackingMap
            java.lang.String r1 = "textShadowOffset"
            boolean r0 = r0.hasKey(r1)
            if (r0 == 0) goto L_0x01b9
            com.facebook.react.bridge.ReadableMap r12 = r12.mBackingMap
            com.facebook.react.bridge.ReadableMap r7 = r12.getMap(r1)
        L_0x01b9:
            r11.mTextShadowOffsetDx = r5
            r11.mTextShadowOffsetDy = r5
            if (r7 == 0) goto L_0x01ef
            java.lang.String r12 = "width"
            boolean r0 = r7.hasKey(r12)
            if (r0 == 0) goto L_0x01d7
            boolean r0 = r7.isNull(r12)
            if (r0 != 0) goto L_0x01d7
            double r0 = r7.getDouble(r12)
            float r12 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toPixelFromDIP(r0)
            r11.mTextShadowOffsetDx = r12
        L_0x01d7:
            java.lang.String r12 = "height"
            boolean r0 = r7.hasKey(r12)
            if (r0 == 0) goto L_0x01ef
            boolean r0 = r7.isNull(r12)
            if (r0 != 0) goto L_0x01ef
            double r0 = r7.getDouble(r12)
            float r12 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.toPixelFromDIP(r0)
            r11.mTextShadowOffsetDy = r12
        L_0x01ef:
            java.lang.String r12 = "textShadowRadius"
            int r12 = r11.getIntProp(r12, r2)
            float r12 = (float) r12
            float r0 = r11.mTextShadowRadius
            int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01fe
            r11.mTextShadowRadius = r12
        L_0x01fe:
            java.lang.String r12 = "textShadowColor"
            int r12 = r11.getIntProp(r12, r6)
            int r0 = r11.mTextShadowColor
            if (r12 == r0) goto L_0x020a
            r11.mTextShadowColor = r12
        L_0x020a:
            java.lang.String r12 = "textTransform"
            java.lang.String r12 = r11.getStringProp(r12)
            if (r12 == 0) goto L_0x024e
            java.lang.String r0 = "none"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x021b
            goto L_0x024e
        L_0x021b:
            java.lang.String r0 = "uppercase"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0228
            com.facebook.react.views.text.TextTransform r12 = com.facebook.react.views.text.TextTransform.UPPERCASE
            r11.mTextTransform = r12
            goto L_0x0252
        L_0x0228:
            java.lang.String r0 = "lowercase"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0235
            com.facebook.react.views.text.TextTransform r12 = com.facebook.react.views.text.TextTransform.LOWERCASE
            r11.mTextTransform = r12
            goto L_0x0252
        L_0x0235:
            java.lang.String r0 = "capitalize"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0242
            com.facebook.react.views.text.TextTransform r12 = com.facebook.react.views.text.TextTransform.CAPITALIZE
            r11.mTextTransform = r12
            goto L_0x0252
        L_0x0242:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r1 = "Invalid textTransform: "
            java.lang.String r12 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r12)
            r0.<init>(r12)
            throw r0
        L_0x024e:
            com.facebook.react.views.text.TextTransform r12 = com.facebook.react.views.text.TextTransform.NONE
            r11.mTextTransform = r12
        L_0x0252:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextAttributeProps.<init>(com.facebook.react.uimanager.ReactStylesDiffMap):void");
    }

    public static int getJustificationMode(ReactStylesDiffMap reactStylesDiffMap) {
        if (!"justify".equals(reactStylesDiffMap.mBackingMap.hasKey("textAlign") ? reactStylesDiffMap.mBackingMap.getString("textAlign") : null) || VERSION.SDK_INT < 26) {
            return DEFAULT_JUSTIFICATION_MODE;
        }
        return 1;
    }

    public static int getTextAlignment(ReactStylesDiffMap reactStylesDiffMap) {
        String string = reactStylesDiffMap.mBackingMap.hasKey("textAlign") ? reactStylesDiffMap.mBackingMap.getString("textAlign") : null;
        if ("justify".equals(string)) {
            return 3;
        }
        if (string == null || "auto".equals(string)) {
            return 0;
        }
        if (RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(string)) {
            return 3;
        }
        if (RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(string)) {
            return 5;
        }
        if ("center".equals(string)) {
            return 1;
        }
        throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid textAlign: ", string));
    }

    public static int getTextBreakStrategy(String str) {
        int i = DEFAULT_BREAK_STRATEGY;
        if (str == null) {
            return i;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1924829944) {
            if (hashCode == -902286926 && str.equals("simple")) {
                c2 = 0;
            }
        } else if (str.equals("balanced")) {
            c2 = 1;
        }
        if (c2 != 0) {
            return c2 != 1 ? 1 : 2;
        }
        return 0;
    }

    public final boolean getBooleanProp(String str, boolean z) {
        if (!this.mProps.mBackingMap.hasKey(str)) {
            return z;
        }
        ReactStylesDiffMap reactStylesDiffMap = this.mProps;
        return reactStylesDiffMap.mBackingMap.isNull(str) ? z : reactStylesDiffMap.mBackingMap.getBoolean(str);
    }

    public float getEffectiveLineHeight() {
        return !Float.isNaN(this.mLineHeight) && !Float.isNaN(this.mHeightOfTallestInlineImage) && (this.mHeightOfTallestInlineImage > this.mLineHeight ? 1 : (this.mHeightOfTallestInlineImage == this.mLineHeight ? 0 : -1)) > 0 ? this.mHeightOfTallestInlineImage : this.mLineHeight;
    }

    public final float getFloatProp(String str, float f2) {
        if (!this.mProps.mBackingMap.hasKey(str)) {
            return f2;
        }
        ReactStylesDiffMap reactStylesDiffMap = this.mProps;
        return reactStylesDiffMap.mBackingMap.isNull(str) ? f2 : (float) reactStylesDiffMap.mBackingMap.getDouble(str);
    }

    public final int getIntProp(String str, int i) {
        return this.mProps.mBackingMap.hasKey(str) ? this.mProps.getInt(str, i) : i;
    }

    public float getLetterSpacing() {
        float f2;
        if (this.mAllowFontScaling) {
            f2 = ImageOriginUtils.toPixelFromSP(this.mLetterSpacingInput);
        } else {
            f2 = ImageOriginUtils.toPixelFromDIP(this.mLetterSpacingInput);
        }
        int i = this.mFontSize;
        if (i > 0) {
            return f2 / ((float) i);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FontSize should be a positive value. Current value: ");
        outline73.append(this.mFontSize);
        throw new IllegalArgumentException(outline73.toString());
    }

    public final String getStringProp(String str) {
        if (this.mProps.mBackingMap.hasKey(str)) {
            return this.mProps.mBackingMap.getString(str);
        }
        return null;
    }

    public void setFontSize(float f2) {
        double d2;
        this.mFontSizeInput = f2;
        if (f2 != -1.0f) {
            if (this.mAllowFontScaling) {
                d2 = Math.ceil((double) ImageOriginUtils.toPixelFromSP(f2));
            } else {
                d2 = Math.ceil((double) ImageOriginUtils.toPixelFromDIP(f2));
            }
            f2 = (float) d2;
        }
        this.mFontSize = (int) f2;
    }

    public void setLineHeight(float f2) {
        float f3;
        this.mLineHeightInput = f2;
        if (f2 == -1.0f) {
            this.mLineHeight = Float.NaN;
            return;
        }
        if (this.mAllowFontScaling) {
            f3 = ImageOriginUtils.toPixelFromSP(f2);
        } else {
            f3 = ImageOriginUtils.toPixelFromDIP(f2);
        }
        this.mLineHeight = f3;
    }
}

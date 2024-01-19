package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageSpan;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    public static final LayoutParams EMPTY_LAYOUT_PARAMS = new LayoutParams(0, 0);
    public boolean mAdjustsFontSizeToFit = false;
    public boolean mContainsImages;
    public int mDefaultGravityHorizontal = (getGravity() & 8388615);
    public int mDefaultGravityVertical = (getGravity() & 112);
    public TruncateAt mEllipsizeLocation = TruncateAt.END;
    public int mLinkifyMaskType = 0;
    public boolean mNotifyOnInlineViewLayout;
    public int mNumberOfLines = Integer.MAX_VALUE;
    public ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
    public Spannable mSpanned;
    public int mTextAlign = 0;

    public ReactTextView(Context context) {
        super(context);
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (context instanceof TintContextWrapper) {
            context = ((TintContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    public static WritableMap inlineViewJson(int i, int i2, int i3, int i4, int i5, int i6) {
        WritableMap createMap = Arguments.createMap();
        if (i == 8) {
            createMap.putString("visibility", "gone");
            createMap.putInt("index", i2);
        } else if (i == 0) {
            createMap.putString("visibility", "visible");
            createMap.putInt("index", i2);
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, (double) ImageOriginUtils.toDIPFromPixel((float) i3));
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_TOP, (double) ImageOriginUtils.toDIPFromPixel((float) i4));
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT, (double) ImageOriginUtils.toDIPFromPixel((float) i5));
            createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM, (double) ImageOriginUtils.toDIPFromPixel((float) i6));
        } else {
            createMap.putString("visibility", "unknown");
            createMap.putInt("index", i2);
        }
        return createMap;
    }

    public Spannable getSpanned() {
        return this.mSpanned;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDrawable == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onAttach();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onDetach();
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onAttach();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0077, code lost:
        if (r15 < (r4.getEllipsisStart(r14) + r4.getLineStart(r14))) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d2, code lost:
        if (r2 != false) goto L_0x00d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x013a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            r22 = this;
            r0 = r22
            java.lang.CharSequence r1 = r22.getText()
            boolean r1 = r1 instanceof android.text.Spanned
            if (r1 == 0) goto L_0x0183
            int r1 = r22.getId()
            int r1 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getUIManagerType(r1)
            r2 = 2
            if (r1 != r2) goto L_0x0017
            goto L_0x0183
        L_0x0017:
            com.facebook.react.bridge.ReactContext r1 = r22.getReactContext()
            java.lang.Class<com.facebook.react.uimanager.UIManagerModule> r2 = com.facebook.react.uimanager.UIManagerModule.class
            com.facebook.react.bridge.NativeModule r2 = r1.getNativeModule(r2)
            com.facebook.react.uimanager.UIManagerModule r2 = (com.facebook.react.uimanager.UIManagerModule) r2
            java.lang.CharSequence r3 = r22.getText()
            android.text.Spanned r3 = (android.text.Spanned) r3
            android.text.Layout r4 = r22.getLayout()
            int r5 = r3.length()
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r6 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            r7 = 0
            java.lang.Object[] r5 = r3.getSpans(r7, r5, r6)
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r5 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r5
            boolean r6 = r0.mNotifyOnInlineViewLayout
            if (r6 == 0) goto L_0x0045
            java.util.ArrayList r6 = new java.util.ArrayList
            int r8 = r5.length
            r6.<init>(r8)
            goto L_0x0046
        L_0x0045:
            r6 = 0
        L_0x0046:
            int r8 = r26 - r24
            int r9 = r27 - r25
            int r10 = r5.length
            r11 = 0
        L_0x004c:
            if (r11 >= r10) goto L_0x0145
            r12 = r5[r11]
            int r13 = r12.mReactTag
            android.view.View r13 = r2.resolveView(r13)
            int r15 = r3.getSpanStart(r12)
            int r14 = r4.getLineForOffset(r15)
            int r16 = r4.getEllipsisCount(r14)
            r17 = 1
            if (r16 <= 0) goto L_0x0069
            r16 = 1
            goto L_0x006b
        L_0x0069:
            r16 = 0
        L_0x006b:
            if (r16 == 0) goto L_0x0079
            int r16 = r4.getLineStart(r14)
            int r18 = r4.getEllipsisStart(r14)
            int r7 = r18 + r16
            if (r15 >= r7) goto L_0x011a
        L_0x0079:
            int r7 = r0.mNumberOfLines
            if (r14 >= r7) goto L_0x011a
            int r7 = r4.getLineEnd(r14)
            if (r15 < r7) goto L_0x0085
            goto L_0x011a
        L_0x0085:
            int r7 = r12.mWidth
            int r12 = r12.mHeight
            r20 = r2
            boolean r2 = r4.isRtlCharAt(r15)
            r21 = r5
            int r5 = r4.getParagraphDirection(r14)
            r27 = r10
            r10 = -1
            if (r5 != r10) goto L_0x009c
            r5 = 1
            goto L_0x009d
        L_0x009c:
            r5 = 0
        L_0x009d:
            int r16 = r3.length()
            int r10 = r16 + -1
            if (r15 != r10) goto L_0x00b5
            if (r5 == 0) goto L_0x00af
            float r5 = r4.getLineWidth(r14)
            int r5 = (int) r5
            int r5 = r8 - r5
            goto L_0x00d5
        L_0x00af:
            float r5 = r4.getLineRight(r14)
            int r5 = (int) r5
            goto L_0x00d4
        L_0x00b5:
            if (r5 != r2) goto L_0x00b9
            r10 = 1
            goto L_0x00ba
        L_0x00b9:
            r10 = 0
        L_0x00ba:
            if (r10 == 0) goto L_0x00c1
            float r10 = r4.getPrimaryHorizontal(r15)
            goto L_0x00c5
        L_0x00c1:
            float r10 = r4.getSecondaryHorizontal(r15)
        L_0x00c5:
            int r10 = (int) r10
            if (r5 == 0) goto L_0x00d1
            float r5 = r4.getLineRight(r14)
            int r5 = (int) r5
            int r5 = r5 - r10
            int r5 = r8 - r5
            goto L_0x00d2
        L_0x00d1:
            r5 = r10
        L_0x00d2:
            if (r2 == 0) goto L_0x00d5
        L_0x00d4:
            int r5 = r5 - r7
        L_0x00d5:
            if (r2 == 0) goto L_0x00dc
            int r2 = r22.getTotalPaddingRight()
            goto L_0x00e0
        L_0x00dc:
            int r2 = r22.getTotalPaddingLeft()
        L_0x00e0:
            int r2 = r2 + r5
            int r5 = r24 + r2
            int r10 = r22.getTotalPaddingTop()
            int r14 = r4.getLineBaseline(r14)
            int r14 = r14 + r10
            int r14 = r14 - r12
            int r10 = r25 + r14
            if (r8 <= r2) goto L_0x00f6
            if (r9 > r14) goto L_0x00f4
            goto L_0x00f6
        L_0x00f4:
            r17 = 0
        L_0x00f6:
            if (r17 == 0) goto L_0x00fb
            r14 = 8
            goto L_0x00fc
        L_0x00fb:
            r14 = 0
        L_0x00fc:
            int r2 = r5 + r7
            int r7 = r10 + r12
            r13.setVisibility(r14)
            r13.layout(r5, r10, r2, r7)
            boolean r12 = r0.mNotifyOnInlineViewLayout
            if (r12 == 0) goto L_0x013a
            r16 = r5
            r17 = r10
            r18 = r2
            r19 = r7
            com.facebook.react.bridge.WritableMap r2 = inlineViewJson(r14, r15, r16, r17, r18, r19)
            r6.add(r2)
            goto L_0x013a
        L_0x011a:
            r20 = r2
            r21 = r5
            r27 = r10
            r2 = 8
            r13.setVisibility(r2)
            boolean r2 = r0.mNotifyOnInlineViewLayout
            if (r2 == 0) goto L_0x013a
            r14 = 8
            r16 = -1
            r17 = -1
            r18 = -1
            r19 = -1
            com.facebook.react.bridge.WritableMap r2 = inlineViewJson(r14, r15, r16, r17, r18, r19)
            r6.add(r2)
        L_0x013a:
            int r11 = r11 + 1
            r10 = r27
            r2 = r20
            r5 = r21
            r7 = 0
            goto L_0x004c
        L_0x0145:
            boolean r2 = r0.mNotifyOnInlineViewLayout
            if (r2 == 0) goto L_0x0183
            com.facebook.react.views.text.ReactTextView$1 r2 = new com.facebook.react.views.text.ReactTextView$1
            r2.<init>()
            java.util.Collections.sort(r6, r2)
            com.facebook.react.bridge.WritableArray r2 = com.facebook.react.bridge.Arguments.createArray()
            java.util.Iterator r3 = r6.iterator()
        L_0x0159:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0169
            java.lang.Object r4 = r3.next()
            com.facebook.react.bridge.WritableMap r4 = (com.facebook.react.bridge.WritableMap) r4
            r2.pushMap(r4)
            goto L_0x0159
        L_0x0169:
            com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r4 = "inlineViews"
            r3.putArray(r4, r2)
            java.lang.Class<com.facebook.react.uimanager.events.RCTEventEmitter> r2 = com.facebook.react.uimanager.events.RCTEventEmitter.class
            com.facebook.react.bridge.JavaScriptModule r1 = r1.getJSModule(r2)
            com.facebook.react.uimanager.events.RCTEventEmitter r1 = (com.facebook.react.uimanager.events.RCTEventEmitter) r1
            int r2 = r22.getId()
            java.lang.String r4 = "topInlineViewLayout"
            r1.receiveEvent(r2, r4, r3)
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextView.onLayout(boolean, int, int, int, int):void");
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                ((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDraweeHolder.onDetach();
            }
        }
    }

    public int reactTagForTouch(float f2, float f3) {
        CharSequence text = getText();
        int id = getId();
        int i = (int) f2;
        int i2 = (int) f3;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        int lineForVertical = layout.getLineForVertical(i2);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i >= lineLeft && i <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) i);
                ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                if (reactTagSpanArr != null) {
                    int length = text.length();
                    for (int i3 = 0; i3 < reactTagSpanArr.length; i3++) {
                        int spanStart = spanned.getSpanStart(reactTagSpanArr[i3]);
                        int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i3]);
                        if (spanEnd > offsetForHorizontal) {
                            int i4 = spanEnd - spanStart;
                            if (i4 <= length) {
                                id = reactTagSpanArr[i3].mReactTag;
                                length = i4;
                            }
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Crash in HorizontalMeasurementProvider: ");
                outline73.append(e2.getMessage());
                FLog.e((String) "ReactNative", outline73.toString());
            }
        }
        return id;
    }

    public void setAdjustFontSizeToFit(boolean z) {
        this.mAdjustsFontSizeToFit = z;
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderRadius(float f2) {
        this.mReactBackgroundManager.setBorderRadius(f2);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setEllipsizeLocation(TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    public void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & -8 & -8388616));
    }

    public void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    public void setLinkifyMask(int i) {
        this.mLinkifyMaskType = i;
    }

    public void setNotifyOnInlineViewLayout(boolean z) {
        this.mNotifyOnInlineViewLayout = z;
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        setSingleLine(z);
        setMaxLines(this.mNumberOfLines);
    }

    public void setSpanned(Spannable spannable) {
        this.mSpanned = spannable;
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        this.mContainsImages = reactTextUpdate.mContainsImages;
        if (getLayoutParams() == null) {
            setLayoutParams(EMPTY_LAYOUT_PARAMS);
        }
        Spannable spannable = reactTextUpdate.mText;
        int i = this.mLinkifyMaskType;
        if (i > 0) {
            Linkify.addLinks(spannable, i);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        setText(spannable);
        float f2 = reactTextUpdate.mPaddingLeft;
        float f3 = reactTextUpdate.mPaddingTop;
        float f4 = reactTextUpdate.mPaddingRight;
        float f5 = reactTextUpdate.mPaddingBottom;
        if (f2 != -1.0f) {
            int i2 = (f5 > -1.0f ? 1 : (f5 == -1.0f ? 0 : -1));
            if (!(i2 == 0 || f4 == -1.0f || i2 == 0)) {
                setPadding((int) Math.floor((double) f2), (int) Math.floor((double) f3), (int) Math.floor((double) f4), (int) Math.floor((double) f5));
            }
        }
        int i3 = reactTextUpdate.mTextAlign;
        if (this.mTextAlign != i3) {
            this.mTextAlign = i3;
        }
        setGravityHorizontal(this.mTextAlign);
        if (VERSION.SDK_INT >= 23) {
            int breakStrategy = getBreakStrategy();
            int i4 = reactTextUpdate.mTextBreakStrategy;
            if (breakStrategy != i4) {
                setBreakStrategy(i4);
            }
        }
        if (VERSION.SDK_INT >= 26) {
            int justificationMode = getJustificationMode();
            int i5 = reactTextUpdate.mJustificationMode;
            if (justificationMode != i5) {
                setJustificationMode(i5);
            }
        }
        requestLayout();
    }

    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan textInlineImageSpan : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (((FrescoBasedReactTextInlineImageSpan) textInlineImageSpan).mDrawable == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }
}

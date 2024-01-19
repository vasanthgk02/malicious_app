package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;
import java.util.ArrayList;
import java.util.Map;

@TargetApi(23)
public class ReactTextShadowNode extends ReactBaseTextShadowNode {
    public static final TextPaint sTextPaintInstance = new TextPaint(1);
    public Spannable mPreparedSpannableText;
    public boolean mShouldNotifyOnTextLayout;
    public final YogaMeasureFunction mTextMeasureFunction;

    public ReactTextShadowNode() {
        super(null);
        AnonymousClass1 r0 = new YogaMeasureFunction() {
            public long measure(YogaNode yogaNode, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
                AnonymousClass1 r2;
                float f4 = f2;
                YogaMeasureMode yogaMeasureMode3 = yogaMeasureMode;
                Spannable spannable = ReactTextShadowNode.this.mPreparedSpannableText;
                ImageOriginUtils.assertNotNull(spannable, "Spannable element has not been prepared in onBeforeLayout");
                Spannable spannable2 = spannable;
                Layout access$100 = ReactTextShadowNode.access$100(ReactTextShadowNode.this, spannable2, f4, yogaMeasureMode3);
                ReactTextShadowNode reactTextShadowNode = ReactTextShadowNode.this;
                int i = -1;
                int i2 = 0;
                if (reactTextShadowNode.mAdjustsFontSizeToFit) {
                    int effectiveFontSize = reactTextShadowNode.mTextAttributes.getEffectiveFontSize();
                    int effectiveFontSize2 = ReactTextShadowNode.this.mTextAttributes.getEffectiveFontSize();
                    float f5 = (float) effectiveFontSize;
                    int max = (int) Math.max(ReactTextShadowNode.this.mMinimumFontScale * f5, ImageOriginUtils.toPixelFromDIP(4.0f));
                    while (effectiveFontSize2 > max) {
                        if (ReactTextShadowNode.this.mNumberOfLines == i || access$100.getLineCount() <= ReactTextShadowNode.this.mNumberOfLines) {
                            if (yogaMeasureMode2 != YogaMeasureMode.UNDEFINED) {
                                if (((float) access$100.getHeight()) <= f3) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            YogaMeasureMode yogaMeasureMode4 = yogaMeasureMode2;
                        }
                        effectiveFontSize2 -= (int) ImageOriginUtils.toPixelFromDIP(1.0f);
                        float f6 = ((float) effectiveFontSize2) / f5;
                        ReactAbsoluteSizeSpan[] reactAbsoluteSizeSpanArr = (ReactAbsoluteSizeSpan[]) spannable2.getSpans(i2, spannable2.length(), ReactAbsoluteSizeSpan.class);
                        int length = reactAbsoluteSizeSpanArr.length;
                        int i3 = 0;
                        while (i3 < length) {
                            ReactAbsoluteSizeSpan reactAbsoluteSizeSpan = reactAbsoluteSizeSpanArr[i3];
                            spannable2.setSpan(new ReactAbsoluteSizeSpan((int) Math.max(((float) reactAbsoluteSizeSpan.getSize()) * f6, (float) max)), spannable2.getSpanStart(reactAbsoluteSizeSpan), spannable2.getSpanEnd(reactAbsoluteSizeSpan), spannable2.getSpanFlags(reactAbsoluteSizeSpan));
                            spannable2.removeSpan(reactAbsoluteSizeSpan);
                            i3++;
                            f6 = f6;
                        }
                        access$100 = ReactTextShadowNode.access$100(ReactTextShadowNode.this, spannable2, f4, yogaMeasureMode3);
                        i = -1;
                        i2 = 0;
                    }
                }
                ReactTextShadowNode reactTextShadowNode2 = ReactTextShadowNode.this;
                if (reactTextShadowNode2.mShouldNotifyOnTextLayout) {
                    ThemedReactContext themedContext = reactTextShadowNode2.getThemedContext();
                    TextPaint textPaint = ReactTextShadowNode.sTextPaintInstance;
                    DisplayMetrics displayMetrics = themedContext.getResources().getDisplayMetrics();
                    WritableArray createArray = Arguments.createArray();
                    TextPaint textPaint2 = new TextPaint(textPaint);
                    textPaint2.setTextSize(textPaint2.getTextSize() * 100.0f);
                    Rect rect = new Rect();
                    int i4 = 0;
                    textPaint2.getTextBounds("T", 0, 1, rect);
                    double height = (double) ((((float) rect.height()) / 100.0f) / displayMetrics.density);
                    Rect rect2 = new Rect();
                    textPaint2.getTextBounds("x", 0, 1, rect2);
                    double height2 = (double) ((((float) rect2.height()) / 100.0f) / displayMetrics.density);
                    while (i4 < access$100.getLineCount()) {
                        Rect rect3 = new Rect();
                        access$100.getLineBounds(i4, rect3);
                        WritableMap createMap = Arguments.createMap();
                        createMap.putDouble("x", (double) (access$100.getLineLeft(i4) / displayMetrics.density));
                        createMap.putDouble("y", (double) (((float) rect3.top) / displayMetrics.density));
                        createMap.putDouble("width", (double) (access$100.getLineWidth(i4) / displayMetrics.density));
                        createMap.putDouble("height", (double) (((float) rect3.height()) / displayMetrics.density));
                        createMap.putDouble("descender", (double) (((float) access$100.getLineDescent(i4)) / displayMetrics.density));
                        createMap.putDouble("ascender", (double) (((float) (-access$100.getLineAscent(i4))) / displayMetrics.density));
                        createMap.putDouble("baseline", (double) (((float) access$100.getLineBaseline(i4)) / displayMetrics.density));
                        createMap.putDouble("capHeight", height);
                        createMap.putDouble("xHeight", height2);
                        createMap.putString("text", spannable2.subSequence(access$100.getLineStart(i4), access$100.getLineEnd(i4)).toString());
                        createArray.pushMap(createMap);
                        i4++;
                        themedContext = themedContext;
                    }
                    ThemedReactContext themedReactContext = themedContext;
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putArray("lines", createArray);
                    if (themedReactContext.hasActiveCatalystInstance()) {
                        r2 = this;
                        ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ReactTextShadowNode.this.mReactTag, "topTextLayout", createMap2);
                    } else {
                        r2 = this;
                        ReactSoftException.logSoftException("ReactTextShadowNode", new ReactNoCrashSoftException((String) "Cannot get RCTEventEmitter, no CatalystInstance"));
                    }
                } else {
                    r2 = this;
                }
                int i5 = ReactTextShadowNode.this.mNumberOfLines;
                if (i5 == -1 || i5 >= access$100.getLineCount()) {
                    return ImageOriginUtils.make(access$100.getWidth(), access$100.getHeight());
                }
                return ImageOriginUtils.make(access$100.getWidth(), access$100.getLineBottom(ReactTextShadowNode.this.mNumberOfLines - 1));
            }
        };
        this.mTextMeasureFunction = r0;
        setMeasureFunction(r0);
    }

    public static Layout access$100(ReactTextShadowNode reactTextShadowNode, Spannable spannable, float f2, YogaMeasureMode yogaMeasureMode) {
        TextPaint textPaint = sTextPaintInstance;
        textPaint.setTextSize((float) reactTextShadowNode.mTextAttributes.getEffectiveFontSize());
        Metrics isBoring = BoringLayout.isBoring(spannable, textPaint);
        float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannable, textPaint) : Float.NaN;
        boolean z = yogaMeasureMode == YogaMeasureMode.UNDEFINED || f2 < 0.0f;
        Alignment alignment = Alignment.ALIGN_NORMAL;
        int textAlign = reactTextShadowNode.getTextAlign();
        if (textAlign == 1) {
            alignment = Alignment.ALIGN_CENTER;
        } else if (textAlign == 3) {
            alignment = Alignment.ALIGN_NORMAL;
        } else if (textAlign == 5) {
            alignment = Alignment.ALIGN_OPPOSITE;
        }
        Alignment alignment2 = alignment;
        if (isBoring == null && (z || (!ImageOriginUtils.isUndefined(desiredWidth) && desiredWidth <= f2))) {
            int ceil = (int) Math.ceil((double) desiredWidth);
            if (VERSION.SDK_INT < 23) {
                StaticLayout staticLayout = new StaticLayout(spannable, textPaint, ceil, alignment2, 1.0f, 0.0f, reactTextShadowNode.mIncludeFontPadding);
                return staticLayout;
            }
            Builder hyphenationFrequency = Builder.obtain(spannable, 0, spannable.length(), textPaint, ceil).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(reactTextShadowNode.mIncludeFontPadding).setBreakStrategy(reactTextShadowNode.mTextBreakStrategy).setHyphenationFrequency(reactTextShadowNode.mHyphenationFrequency);
            if (VERSION.SDK_INT >= 26) {
                hyphenationFrequency.setJustificationMode(reactTextShadowNode.mJustificationMode);
            }
            if (VERSION.SDK_INT >= 28) {
                hyphenationFrequency.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency.build();
        } else if (isBoring != null && (z || ((float) isBoring.width) <= f2)) {
            return BoringLayout.make(spannable, textPaint, isBoring.width, alignment2, 1.0f, 0.0f, isBoring, reactTextShadowNode.mIncludeFontPadding);
        } else if (VERSION.SDK_INT < 23) {
            StaticLayout staticLayout2 = new StaticLayout(spannable, textPaint, (int) f2, alignment2, 1.0f, 0.0f, reactTextShadowNode.mIncludeFontPadding);
            return staticLayout2;
        } else {
            Builder hyphenationFrequency2 = Builder.obtain(spannable, 0, spannable.length(), textPaint, (int) f2).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(reactTextShadowNode.mIncludeFontPadding).setBreakStrategy(reactTextShadowNode.mTextBreakStrategy).setHyphenationFrequency(reactTextShadowNode.mHyphenationFrequency);
            if (VERSION.SDK_INT >= 28) {
                hyphenationFrequency2.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency2.build();
        }
    }

    public Iterable<? extends ReactShadowNode> calculateLayoutOnChildren() {
        Map<Integer, ReactShadowNode> map = this.mInlineViews;
        if (map == null || map.isEmpty()) {
            return null;
        }
        Spannable spannable = this.mPreparedSpannableText;
        ImageOriginUtils.assertNotNull(spannable, "Spannable element has not been prepared in onBeforeLayout");
        Spanned spanned = spannable;
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) spanned.getSpans(0, spanned.length(), TextInlineViewPlaceholderSpan.class);
        ArrayList arrayList = new ArrayList(textInlineViewPlaceholderSpanArr.length);
        for (TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan : textInlineViewPlaceholderSpanArr) {
            ReactShadowNode reactShadowNode = this.mInlineViews.get(Integer.valueOf(textInlineViewPlaceholderSpan.mReactTag));
            reactShadowNode.calculateLayout();
            arrayList.add(reactShadowNode);
        }
        return arrayList;
    }

    public final int getTextAlign() {
        int i = this.mTextAlign;
        if (this.mYogaNode.getLayoutDirection() != YogaDirection.RTL) {
            return i;
        }
        if (i == 5) {
            return 3;
        }
        if (i == 3) {
            return 5;
        }
        return i;
    }

    public boolean hoistNativeChildren() {
        return true;
    }

    public boolean isVirtualAnchor() {
        return false;
    }

    public void markUpdated() {
        super.markUpdated();
        super.dirty();
    }

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        this.mPreparedSpannableText = spannedFromShadowNode(this, null, true, nativeViewHierarchyOptimizer);
        super.markUpdated();
        super.dirty();
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        Spannable spannable = this.mPreparedSpannableText;
        if (spannable != null) {
            ReactTextUpdate reactTextUpdate = new ReactTextUpdate(spannable, -1, this.mContainsImages, getPadding(4), getPadding(1), getPadding(5), getPadding(3), getTextAlign(), this.mTextBreakStrategy, this.mJustificationMode, -1, -1);
            uIViewOperationQueue.enqueueUpdateExtraData(this.mReactTag, reactTextUpdate);
        }
    }

    @ReactProp(name = "onTextLayout")
    public void setShouldNotifyOnTextLayout(boolean z) {
        this.mShouldNotifyOnTextLayout = z;
    }

    public ReactTextShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        super(reactTextViewManagerCallback);
        AnonymousClass1 r1 = new YogaMeasureFunction() {
            public long measure(YogaNode yogaNode, float f2, YogaMeasureMode yogaMeasureMode, float f3, YogaMeasureMode yogaMeasureMode2) {
                AnonymousClass1 r2;
                float f4 = f2;
                YogaMeasureMode yogaMeasureMode3 = yogaMeasureMode;
                Spannable spannable = ReactTextShadowNode.this.mPreparedSpannableText;
                ImageOriginUtils.assertNotNull(spannable, "Spannable element has not been prepared in onBeforeLayout");
                Spannable spannable2 = spannable;
                Layout access$100 = ReactTextShadowNode.access$100(ReactTextShadowNode.this, spannable2, f4, yogaMeasureMode3);
                ReactTextShadowNode reactTextShadowNode = ReactTextShadowNode.this;
                int i = -1;
                int i2 = 0;
                if (reactTextShadowNode.mAdjustsFontSizeToFit) {
                    int effectiveFontSize = reactTextShadowNode.mTextAttributes.getEffectiveFontSize();
                    int effectiveFontSize2 = ReactTextShadowNode.this.mTextAttributes.getEffectiveFontSize();
                    float f5 = (float) effectiveFontSize;
                    int max = (int) Math.max(ReactTextShadowNode.this.mMinimumFontScale * f5, ImageOriginUtils.toPixelFromDIP(4.0f));
                    while (effectiveFontSize2 > max) {
                        if (ReactTextShadowNode.this.mNumberOfLines == i || access$100.getLineCount() <= ReactTextShadowNode.this.mNumberOfLines) {
                            if (yogaMeasureMode2 != YogaMeasureMode.UNDEFINED) {
                                if (((float) access$100.getHeight()) <= f3) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            YogaMeasureMode yogaMeasureMode4 = yogaMeasureMode2;
                        }
                        effectiveFontSize2 -= (int) ImageOriginUtils.toPixelFromDIP(1.0f);
                        float f6 = ((float) effectiveFontSize2) / f5;
                        ReactAbsoluteSizeSpan[] reactAbsoluteSizeSpanArr = (ReactAbsoluteSizeSpan[]) spannable2.getSpans(i2, spannable2.length(), ReactAbsoluteSizeSpan.class);
                        int length = reactAbsoluteSizeSpanArr.length;
                        int i3 = 0;
                        while (i3 < length) {
                            ReactAbsoluteSizeSpan reactAbsoluteSizeSpan = reactAbsoluteSizeSpanArr[i3];
                            spannable2.setSpan(new ReactAbsoluteSizeSpan((int) Math.max(((float) reactAbsoluteSizeSpan.getSize()) * f6, (float) max)), spannable2.getSpanStart(reactAbsoluteSizeSpan), spannable2.getSpanEnd(reactAbsoluteSizeSpan), spannable2.getSpanFlags(reactAbsoluteSizeSpan));
                            spannable2.removeSpan(reactAbsoluteSizeSpan);
                            i3++;
                            f6 = f6;
                        }
                        access$100 = ReactTextShadowNode.access$100(ReactTextShadowNode.this, spannable2, f4, yogaMeasureMode3);
                        i = -1;
                        i2 = 0;
                    }
                }
                ReactTextShadowNode reactTextShadowNode2 = ReactTextShadowNode.this;
                if (reactTextShadowNode2.mShouldNotifyOnTextLayout) {
                    ThemedReactContext themedContext = reactTextShadowNode2.getThemedContext();
                    TextPaint textPaint = ReactTextShadowNode.sTextPaintInstance;
                    DisplayMetrics displayMetrics = themedContext.getResources().getDisplayMetrics();
                    WritableArray createArray = Arguments.createArray();
                    TextPaint textPaint2 = new TextPaint(textPaint);
                    textPaint2.setTextSize(textPaint2.getTextSize() * 100.0f);
                    Rect rect = new Rect();
                    int i4 = 0;
                    textPaint2.getTextBounds("T", 0, 1, rect);
                    double height = (double) ((((float) rect.height()) / 100.0f) / displayMetrics.density);
                    Rect rect2 = new Rect();
                    textPaint2.getTextBounds("x", 0, 1, rect2);
                    double height2 = (double) ((((float) rect2.height()) / 100.0f) / displayMetrics.density);
                    while (i4 < access$100.getLineCount()) {
                        Rect rect3 = new Rect();
                        access$100.getLineBounds(i4, rect3);
                        WritableMap createMap = Arguments.createMap();
                        createMap.putDouble("x", (double) (access$100.getLineLeft(i4) / displayMetrics.density));
                        createMap.putDouble("y", (double) (((float) rect3.top) / displayMetrics.density));
                        createMap.putDouble("width", (double) (access$100.getLineWidth(i4) / displayMetrics.density));
                        createMap.putDouble("height", (double) (((float) rect3.height()) / displayMetrics.density));
                        createMap.putDouble("descender", (double) (((float) access$100.getLineDescent(i4)) / displayMetrics.density));
                        createMap.putDouble("ascender", (double) (((float) (-access$100.getLineAscent(i4))) / displayMetrics.density));
                        createMap.putDouble("baseline", (double) (((float) access$100.getLineBaseline(i4)) / displayMetrics.density));
                        createMap.putDouble("capHeight", height);
                        createMap.putDouble("xHeight", height2);
                        createMap.putString("text", spannable2.subSequence(access$100.getLineStart(i4), access$100.getLineEnd(i4)).toString());
                        createArray.pushMap(createMap);
                        i4++;
                        themedContext = themedContext;
                    }
                    ThemedReactContext themedReactContext = themedContext;
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putArray("lines", createArray);
                    if (themedReactContext.hasActiveCatalystInstance()) {
                        r2 = this;
                        ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(ReactTextShadowNode.this.mReactTag, "topTextLayout", createMap2);
                    } else {
                        r2 = this;
                        ReactSoftException.logSoftException("ReactTextShadowNode", new ReactNoCrashSoftException((String) "Cannot get RCTEventEmitter, no CatalystInstance"));
                    }
                } else {
                    r2 = this;
                }
                int i5 = ReactTextShadowNode.this.mNumberOfLines;
                if (i5 == -1 || i5 >= access$100.getLineCount()) {
                    return ImageOriginUtils.make(access$100.getWidth(), access$100.getHeight());
                }
                return ImageOriginUtils.make(access$100.getWidth(), access$100.getLineBottom(ReactTextShadowNode.this.mNumberOfLines - 1));
            }
        };
        this.mTextMeasureFunction = r1;
        setMeasureFunction(r1);
    }
}

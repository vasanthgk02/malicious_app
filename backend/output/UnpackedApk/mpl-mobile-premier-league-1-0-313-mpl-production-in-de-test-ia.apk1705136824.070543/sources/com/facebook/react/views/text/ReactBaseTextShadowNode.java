package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageShadowNode;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageSpan;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaValue;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;

@TargetApi(23)
public abstract class ReactBaseTextShadowNode extends LayoutShadowNode {
    public boolean mAdjustsFontSizeToFit;
    public int mBackgroundColor;
    public int mColor;
    public boolean mContainsImages;
    public String mFontFamily;
    public String mFontFeatureSettings;
    public int mFontStyle;
    public int mFontWeight;
    public int mHyphenationFrequency;
    public boolean mIncludeFontPadding;
    public Map<Integer, ReactShadowNode> mInlineViews;
    public boolean mIsBackgroundColorSet;
    public boolean mIsColorSet;
    public boolean mIsLineThroughTextDecorationSet;
    public boolean mIsUnderlineTextDecorationSet;
    public int mJustificationMode;
    public float mMinimumFontScale;
    public int mNumberOfLines;
    public ReactTextViewManagerCallback mReactTextViewManagerCallback;
    public int mTextAlign;
    public TextAttributes mTextAttributes;
    public int mTextBreakStrategy;
    public int mTextShadowColor;
    public float mTextShadowOffsetDx;
    public float mTextShadowOffsetDy;
    public float mTextShadowRadius;

    public static class SetSpanOperation {
        public int end;
        public int start;
        public ReactSpan what;

        public SetSpanOperation(int i, int i2, ReactSpan reactSpan) {
            this.start = i;
            this.end = i2;
            this.what = reactSpan;
        }
    }

    public ReactBaseTextShadowNode() {
        this(null);
    }

    public static void buildSpannedFromShadowNode(ReactBaseTextShadowNode reactBaseTextShadowNode, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list, TextAttributes textAttributes, boolean z, Map<Integer, ReactShadowNode> map, int i) {
        TextAttributes textAttributes2;
        TextAttributes textAttributes3;
        int i2;
        float f2;
        float f3;
        ReactBaseTextShadowNode reactBaseTextShadowNode2 = reactBaseTextShadowNode;
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        List<SetSpanOperation> list2 = list;
        TextAttributes textAttributes4 = textAttributes;
        int i3 = i;
        if (textAttributes4 != null) {
            TextAttributes textAttributes5 = reactBaseTextShadowNode2.mTextAttributes;
            textAttributes2 = new TextAttributes();
            textAttributes2.mAllowFontScaling = textAttributes4.mAllowFontScaling;
            textAttributes2.mFontSize = !Float.isNaN(textAttributes5.mFontSize) ? textAttributes5.mFontSize : textAttributes4.mFontSize;
            textAttributes2.mLineHeight = !Float.isNaN(textAttributes5.mLineHeight) ? textAttributes5.mLineHeight : textAttributes4.mLineHeight;
            textAttributes2.mLetterSpacing = !Float.isNaN(textAttributes5.mLetterSpacing) ? textAttributes5.mLetterSpacing : textAttributes4.mLetterSpacing;
            textAttributes2.mMaxFontSizeMultiplier = !Float.isNaN(textAttributes5.mMaxFontSizeMultiplier) ? textAttributes5.mMaxFontSizeMultiplier : textAttributes4.mMaxFontSizeMultiplier;
            textAttributes2.mHeightOfTallestInlineViewOrImage = !Float.isNaN(textAttributes5.mHeightOfTallestInlineViewOrImage) ? textAttributes5.mHeightOfTallestInlineViewOrImage : textAttributes4.mHeightOfTallestInlineViewOrImage;
            TextTransform textTransform = textAttributes5.mTextTransform;
            if (textTransform == TextTransform.UNSET) {
                textTransform = textAttributes4.mTextTransform;
            }
            textAttributes2.mTextTransform = textTransform;
        } else {
            textAttributes2 = reactBaseTextShadowNode2.mTextAttributes;
        }
        TextAttributes textAttributes6 = textAttributes2;
        int childCount = reactBaseTextShadowNode.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            ReactShadowNodeImpl childAt = reactBaseTextShadowNode2.getChildAt(i4);
            if (childAt instanceof ReactRawTextShadowNode) {
                spannableStringBuilder2.append(TextTransform.apply(((ReactRawTextShadowNode) childAt).mText, textAttributes6.mTextTransform));
            } else if (childAt instanceof ReactBaseTextShadowNode) {
                buildSpannedFromShadowNode((ReactBaseTextShadowNode) childAt, spannableStringBuilder, list, textAttributes6, z, map, spannableStringBuilder.length());
            } else {
                if (childAt instanceof ReactTextInlineImageShadowNode) {
                    spannableStringBuilder2.append("0");
                    int length = spannableStringBuilder.length();
                    FrescoBasedReactTextInlineImageShadowNode frescoBasedReactTextInlineImageShadowNode = (FrescoBasedReactTextInlineImageShadowNode) ((ReactTextInlineImageShadowNode) childAt);
                    i2 = childCount;
                    textAttributes3 = textAttributes6;
                    FrescoBasedReactTextInlineImageSpan frescoBasedReactTextInlineImageSpan = new FrescoBasedReactTextInlineImageSpan(frescoBasedReactTextInlineImageShadowNode.getThemedContext().getResources(), (int) Math.ceil((double) frescoBasedReactTextInlineImageShadowNode.mHeight), (int) Math.ceil((double) frescoBasedReactTextInlineImageShadowNode.mWidth), frescoBasedReactTextInlineImageShadowNode.mTintColor, frescoBasedReactTextInlineImageShadowNode.mUri, frescoBasedReactTextInlineImageShadowNode.mHeaders, frescoBasedReactTextInlineImageShadowNode.mDraweeControllerBuilder, frescoBasedReactTextInlineImageShadowNode.mCallerContext, frescoBasedReactTextInlineImageShadowNode.mResizeMode);
                    list2.add(new SetSpanOperation(spannableStringBuilder.length() - 1, length, frescoBasedReactTextInlineImageSpan));
                    Map<Integer, ReactShadowNode> map2 = map;
                } else {
                    textAttributes3 = textAttributes6;
                    i2 = childCount;
                    if (z) {
                        int reactTag = childAt.getReactTag();
                        YogaValue styleWidth = childAt.getStyleWidth();
                        YogaValue styleHeight = childAt.getStyleHeight();
                        YogaUnit yogaUnit = styleWidth.unit;
                        YogaUnit yogaUnit2 = YogaUnit.POINT;
                        if (yogaUnit == yogaUnit2 && styleHeight.unit == yogaUnit2) {
                            f3 = styleWidth.value;
                            f2 = styleHeight.value;
                        } else {
                            childAt.calculateLayout();
                            f3 = childAt.getLayoutWidth();
                            f2 = childAt.getLayoutHeight();
                        }
                        spannableStringBuilder2.append("0");
                        list2.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(reactTag, (int) f3, (int) f2)));
                        map.put(Integer.valueOf(reactTag), childAt);
                    } else {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unexpected view type nested under a <Text> or <TextInput> node: ");
                        outline73.append(childAt.getClass());
                        throw new IllegalViewOperationException(outline73.toString());
                    }
                }
                childAt.markUpdateSeen();
                i4++;
                reactBaseTextShadowNode2 = reactBaseTextShadowNode;
                TextAttributes textAttributes7 = textAttributes;
                int i5 = i;
                childCount = i2;
                textAttributes6 = textAttributes3;
            }
            Map<Integer, ReactShadowNode> map3 = map;
            textAttributes3 = textAttributes6;
            i2 = childCount;
            childAt.markUpdateSeen();
            i4++;
            reactBaseTextShadowNode2 = reactBaseTextShadowNode;
            TextAttributes textAttributes72 = textAttributes;
            int i52 = i;
            childCount = i2;
            textAttributes6 = textAttributes3;
        }
        TextAttributes textAttributes8 = textAttributes6;
        int length2 = spannableStringBuilder.length();
        int i6 = i;
        if (length2 >= i6) {
            ReactBaseTextShadowNode reactBaseTextShadowNode3 = reactBaseTextShadowNode;
            if (reactBaseTextShadowNode3.mIsColorSet) {
                list2.add(new SetSpanOperation(i6, length2, new ReactForegroundColorSpan(reactBaseTextShadowNode3.mColor)));
            }
            if (reactBaseTextShadowNode3.mIsBackgroundColorSet) {
                list2.add(new SetSpanOperation(i6, length2, new ReactBackgroundColorSpan(reactBaseTextShadowNode3.mBackgroundColor)));
            }
            float effectiveLetterSpacing = textAttributes8.getEffectiveLetterSpacing();
            if (!Float.isNaN(effectiveLetterSpacing) && (textAttributes == null || textAttributes.getEffectiveLetterSpacing() != effectiveLetterSpacing)) {
                list2.add(new SetSpanOperation(i6, length2, new CustomLetterSpacingSpan(effectiveLetterSpacing)));
            }
            int effectiveFontSize = textAttributes8.getEffectiveFontSize();
            if (textAttributes == null || textAttributes.getEffectiveFontSize() != effectiveFontSize) {
                list2.add(new SetSpanOperation(i6, length2, new ReactAbsoluteSizeSpan(effectiveFontSize)));
            }
            if (!(reactBaseTextShadowNode3.mFontStyle == -1 && reactBaseTextShadowNode3.mFontWeight == -1 && reactBaseTextShadowNode3.mFontFamily == null)) {
                CustomStyleSpan customStyleSpan = new CustomStyleSpan(reactBaseTextShadowNode3.mFontStyle, reactBaseTextShadowNode3.mFontWeight, reactBaseTextShadowNode3.mFontFeatureSettings, reactBaseTextShadowNode3.mFontFamily, reactBaseTextShadowNode.getThemedContext().getAssets());
                list2.add(new SetSpanOperation(i6, length2, customStyleSpan));
            }
            if (reactBaseTextShadowNode3.mIsUnderlineTextDecorationSet) {
                list2.add(new SetSpanOperation(i6, length2, new ReactUnderlineSpan()));
            }
            if (reactBaseTextShadowNode3.mIsLineThroughTextDecorationSet) {
                list2.add(new SetSpanOperation(i6, length2, new ReactStrikethroughSpan()));
            }
            if (!((reactBaseTextShadowNode3.mTextShadowOffsetDx == 0.0f && reactBaseTextShadowNode3.mTextShadowOffsetDy == 0.0f && reactBaseTextShadowNode3.mTextShadowRadius == 0.0f) || Color.alpha(reactBaseTextShadowNode3.mTextShadowColor) == 0)) {
                list2.add(new SetSpanOperation(i6, length2, new ShadowStyleSpan(reactBaseTextShadowNode3.mTextShadowOffsetDx, reactBaseTextShadowNode3.mTextShadowOffsetDy, reactBaseTextShadowNode3.mTextShadowRadius, reactBaseTextShadowNode3.mTextShadowColor)));
            }
            float effectiveLineHeight = textAttributes8.getEffectiveLineHeight();
            if (!Float.isNaN(effectiveLineHeight) && (textAttributes == null || textAttributes.getEffectiveLineHeight() != effectiveLineHeight)) {
                list2.add(new SetSpanOperation(i6, length2, new CustomLineHeightSpan(effectiveLineHeight)));
            }
            list2.add(new SetSpanOperation(i6, length2, new ReactTagSpan(reactBaseTextShadowNode3.mReactTag)));
        }
    }

    @ReactProp(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(boolean z) {
        if (z != this.mAdjustsFontSizeToFit) {
            this.mAdjustsFontSizeToFit = z;
            markUpdated();
        }
    }

    @ReactProp(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(boolean z) {
        TextAttributes textAttributes = this.mTextAttributes;
        if (z != textAttributes.mAllowFontScaling) {
            textAttributes.mAllowFontScaling = z;
            markUpdated();
        }
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(Integer num) {
        if (isVirtual()) {
            boolean z = num != null;
            this.mIsBackgroundColorSet = z;
            if (z) {
                this.mBackgroundColor = num.intValue();
            }
            markUpdated();
        }
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(Integer num) {
        boolean z = num != null;
        this.mIsColorSet = z;
        if (z) {
            this.mColor = num.intValue();
        }
        markUpdated();
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(String str) {
        this.mFontFamily = str;
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "fontSize")
    public void setFontSize(float f2) {
        this.mTextAttributes.mFontSize = f2;
        markUpdated();
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(String str) {
        int parseFontStyle = ImageOriginUtils.parseFontStyle(str);
        if (parseFontStyle != this.mFontStyle) {
            this.mFontStyle = parseFontStyle;
            markUpdated();
        }
    }

    @ReactProp(name = "fontVariant")
    public void setFontVariant(ReadableArray readableArray) {
        String parseFontVariant = ImageOriginUtils.parseFontVariant(readableArray);
        if (!TextUtils.equals(parseFontVariant, this.mFontFeatureSettings)) {
            this.mFontFeatureSettings = parseFontVariant;
            markUpdated();
        }
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(String str) {
        int parseFontWeight = ImageOriginUtils.parseFontWeight(str);
        if (parseFontWeight != this.mFontWeight) {
            this.mFontWeight = parseFontWeight;
            markUpdated();
        }
    }

    @ReactProp(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(boolean z) {
        this.mIncludeFontPadding = z;
    }

    @ReactProp(defaultFloat = Float.NaN, name = "letterSpacing")
    public void setLetterSpacing(float f2) {
        this.mTextAttributes.mLetterSpacing = f2;
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "lineHeight")
    public void setLineHeight(float f2) {
        this.mTextAttributes.mLineHeight = f2;
        markUpdated();
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(float f2) {
        TextAttributes textAttributes = this.mTextAttributes;
        if (f2 != textAttributes.mMaxFontSizeMultiplier) {
            textAttributes.setMaxFontSizeMultiplier(f2);
            markUpdated();
        }
    }

    @ReactProp(name = "minimumFontScale")
    public void setMinimumFontScale(float f2) {
        if (f2 != this.mMinimumFontScale) {
            this.mMinimumFontScale = f2;
            markUpdated();
        }
    }

    @ReactProp(defaultInt = -1, name = "numberOfLines")
    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = -1;
        }
        this.mNumberOfLines = i;
        markUpdated();
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(String str) {
        if ("justify".equals(str)) {
            if (VERSION.SDK_INT >= 26) {
                this.mJustificationMode = 1;
            }
            this.mTextAlign = 3;
        } else {
            if (VERSION.SDK_INT >= 26) {
                this.mJustificationMode = 0;
            }
            if (str == null || "auto".equals(str)) {
                this.mTextAlign = 0;
            } else if (RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(str)) {
                this.mTextAlign = 3;
            } else if (RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(str)) {
                this.mTextAlign = 5;
            } else if ("center".equals(str)) {
                this.mTextAlign = 1;
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid textAlign: ", str));
            }
        }
        markUpdated();
    }

    @ReactProp(name = "textBreakStrategy")
    public void setTextBreakStrategy(String str) {
        if (VERSION.SDK_INT >= 23) {
            if (str == null || "highQuality".equals(str)) {
                this.mTextBreakStrategy = 1;
            } else if ("simple".equals(str)) {
                this.mTextBreakStrategy = 0;
            } else if ("balanced".equals(str)) {
                this.mTextBreakStrategy = 2;
            } else {
                throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid textBreakStrategy: ", str));
            }
            markUpdated();
        }
    }

    @ReactProp(name = "textDecorationLine")
    public void setTextDecorationLine(String str) {
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (str != null) {
            for (String str2 : str.split(CMap.SPACE)) {
                if ("underline".equals(str2)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if ("line-through".equals(str2)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
            }
        }
        markUpdated();
    }

    @ReactProp(customType = "Color", defaultInt = 1426063360, name = "textShadowColor")
    public void setTextShadowColor(int i) {
        if (i != this.mTextShadowColor) {
            this.mTextShadowColor = i;
            markUpdated();
        }
    }

    @ReactProp(name = "textShadowOffset")
    public void setTextShadowOffset(ReadableMap readableMap) {
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                this.mTextShadowOffsetDx = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble("width"));
            }
            if (readableMap.hasKey("height") && !readableMap.isNull("height")) {
                this.mTextShadowOffsetDy = ImageOriginUtils.toPixelFromDIP(readableMap.getDouble("height"));
            }
        }
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "textShadowRadius")
    public void setTextShadowRadius(float f2) {
        if (f2 != this.mTextShadowRadius) {
            this.mTextShadowRadius = f2;
            markUpdated();
        }
    }

    @ReactProp(name = "textTransform")
    public void setTextTransform(String str) {
        if (str == null) {
            this.mTextAttributes.mTextTransform = TextTransform.UNSET;
        } else if ("none".equals(str)) {
            this.mTextAttributes.mTextTransform = TextTransform.NONE;
        } else if ("uppercase".equals(str)) {
            this.mTextAttributes.mTextTransform = TextTransform.UPPERCASE;
        } else if ("lowercase".equals(str)) {
            this.mTextAttributes.mTextTransform = TextTransform.LOWERCASE;
        } else if ("capitalize".equals(str)) {
            this.mTextAttributes.mTextTransform = TextTransform.CAPITALIZE;
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline50("Invalid textTransform: ", str));
        }
        markUpdated();
    }

    public Spannable spannedFromShadowNode(ReactBaseTextShadowNode reactBaseTextShadowNode, String str, boolean z, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        int i;
        ReactBaseTextShadowNode reactBaseTextShadowNode2 = reactBaseTextShadowNode;
        String str2 = str;
        NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer2 = nativeViewHierarchyOptimizer;
        int i2 = 0;
        ImageOriginUtils.assertCondition(!z || nativeViewHierarchyOptimizer2 != null, "nativeViewHierarchyOptimizer is required when inline views are supported");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        Map<Integer, ReactShadowNode> hashMap = z ? new HashMap<>() : null;
        if (str2 != null) {
            spannableStringBuilder.append(TextTransform.apply(str2, reactBaseTextShadowNode2.mTextAttributes.mTextTransform));
        }
        buildSpannedFromShadowNode(reactBaseTextShadowNode, spannableStringBuilder, arrayList, null, z, hashMap, 0);
        reactBaseTextShadowNode2.mContainsImages = false;
        reactBaseTextShadowNode2.mInlineViews = hashMap;
        float f2 = Float.NaN;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SetSpanOperation setSpanOperation = (SetSpanOperation) it.next();
            ReactSpan reactSpan = setSpanOperation.what;
            boolean z2 = reactSpan instanceof TextInlineImageSpan;
            if (z2 || (reactSpan instanceof TextInlineViewPlaceholderSpan)) {
                if (z2) {
                    i = ((FrescoBasedReactTextInlineImageSpan) ((TextInlineImageSpan) setSpanOperation.what)).mHeight;
                    reactBaseTextShadowNode2.mContainsImages = true;
                } else {
                    TextInlineViewPlaceholderSpan textInlineViewPlaceholderSpan = (TextInlineViewPlaceholderSpan) setSpanOperation.what;
                    int i3 = textInlineViewPlaceholderSpan.mHeight;
                    ReactShadowNode reactShadowNode = hashMap.get(Integer.valueOf(textInlineViewPlaceholderSpan.mReactTag));
                    if (nativeViewHierarchyOptimizer2 != null) {
                        if (reactShadowNode.isLayoutOnly()) {
                            nativeViewHierarchyOptimizer2.transitionLayoutOnlyViewToNativeView(reactShadowNode, null);
                        }
                        reactShadowNode.setLayoutParent(reactBaseTextShadowNode2);
                        i = i3;
                    } else {
                        throw null;
                    }
                }
                if (Float.isNaN(f2) || ((float) i) > f2) {
                    f2 = (float) i;
                }
            }
            spannableStringBuilder.setSpan(setSpanOperation.what, setSpanOperation.start, setSpanOperation.end, ((setSpanOperation.start == 0 ? 18 : 34) & -16711681) | ((i2 << 16) & 16711680));
            i2++;
        }
        reactBaseTextShadowNode2.mTextAttributes.mHeightOfTallestInlineViewOrImage = f2;
        ReactTextViewManagerCallback reactTextViewManagerCallback = this.mReactTextViewManagerCallback;
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    public ReactBaseTextShadowNode(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        this.mIsColorSet = false;
        this.mIsBackgroundColorSet = false;
        this.mNumberOfLines = -1;
        this.mTextAlign = 0;
        this.mTextBreakStrategy = VERSION.SDK_INT < 23 ? 0 : 1;
        int i = VERSION.SDK_INT;
        this.mHyphenationFrequency = 0;
        int i2 = VERSION.SDK_INT;
        this.mJustificationMode = 0;
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        this.mTextShadowRadius = 0.0f;
        this.mTextShadowColor = 1426063360;
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        this.mIncludeFontPadding = true;
        this.mAdjustsFontSizeToFit = false;
        this.mMinimumFontScale = 0.0f;
        this.mFontStyle = -1;
        this.mFontWeight = -1;
        this.mFontFamily = null;
        this.mFontFeatureSettings = null;
        this.mContainsImages = false;
        this.mTextAttributes = new TextAttributes();
        this.mReactTextViewManagerCallback = reactTextViewManagerCallback;
    }
}
